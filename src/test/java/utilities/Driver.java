package utilities;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.time.Duration;
import java.util.HashMap;

import static stepDefinitions.Hooks.*;


public class Driver {

    /*
     Creating the private constructor so this class' object
     is not reachable from outside
      */
    private Driver() {
    }

    /*
    Making my 'driver' instance private so that it is not reachable from outside the class.
    I make it static, because we want it to run before everything else, and also we will use it in a static method
     */
    private static ThreadLocal<WebDriver> driverPool = new ThreadLocal<>();

    /*
    Creating re-usable utility method that will return same 'driver' instance everytime I call it.
     */
    public static WebDriver getDriver() {
        HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
        chromePrefs.put("download.default_directory", System.getProperty("user.dir") + "\\target");

        //setting various capabilities for browsers
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setExperimentalOption("prefs", chromePrefs);

        if (isHeadless) {
            chromeOptions.addArguments("use-fake-ui-for-media-stream");
            chromeOptions.addArguments("--disable-gpu");
            chromeOptions.addArguments("--headless");
            chromeOptions.addArguments("--window-size=1920,1080");
            chromeOptions.addArguments("--no-sandbox");
            chromeOptions.addArguments("--disable-dev-shm-usage");
            chromeOptions.addArguments("--remote-allow-origins=*");
        } else {
            chromeOptions.addArguments("use-fake-ui-for-media-stream");
            chromeOptions.addArguments("--disable-gpu");
            chromeOptions.addArguments("--window-size=1920,1080");
            chromeOptions.addArguments("--remote-allow-origins=*");
        }

        FirefoxOptions firefoxOptions = new FirefoxOptions();
        if (isHeadless) {
            firefoxOptions.addArguments("--headless");
            firefoxOptions.addArguments("--disable-gpu");
            firefoxOptions.addArguments("--window-size=1920,1080");
//            firefoxOptions.addArguments("use-fake-ui-for-media-stream");

        } else {
            firefoxOptions.addArguments("--disable-gpu");
            firefoxOptions.addArguments("--window-size=1920,1080");
//            firefoxOptions.addArguments("use-fake-ui-for-media-stream");

        }

        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.addArguments("use-fake-ui-for-media-stream");


        if (driverPool.get() == null) {
            synchronized (Driver.class) {

            /*
            I read my browser type from configuration.properties file using
            .getProperty method I create in ConfigurationReader class.
             */
                // String browserType = ConfigurationReader.getProperty("browser");

            /*
            Depending on the browser type my switch statement will determine
            to open specific type of browser/driver
             */
                switch (browserType) {

                    case "chrome":
                        WebDriverManager.chromedriver().setup();
                        driverPool.set(new ChromeDriver(chromeOptions));
                        break;

                    case "firefox":
                        WebDriverManager.firefoxdriver().setup();
                        driverPool.set(new FirefoxDriver(firefoxOptions));
                        break;

                    case "ie":
                        if (!System.getProperty("os.name").toLowerCase().contains("windows"))
                            throw new WebDriverException("Your OS doesn't support Internet Explorer");
                        WebDriverManager.iedriver().setup();
                        driverPool.set(new InternetExplorerDriver());
                        break;

                    case "edge":
                        if (!System.getProperty("os.name").toLowerCase().contains("windows"))
                            throw new WebDriverException("Your OS doesn't support Edge");
                        WebDriverManager.edgedriver().setup();
                        driverPool.set(new EdgeDriver());
                        break;

                    case "safari":
                        if (!System.getProperty("os.name").toLowerCase().contains("mac"))
                            throw new WebDriverException("Your OS doesn't support Safari");
                        WebDriverManager.getInstance(SafariDriver.class).setup();
                        driverPool.set(new SafariDriver());
                        break;
                }
                if (isFullScreen) {

                    driverPool.get().manage().window().maximize();
                } else {
                    Dimension dimension = new Dimension(width, height);
                    driverPool.get().manage().window().setSize(dimension);
                }
                driverPool.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
            }
        }
        /*
        Same driver instance will be returned every time we call Driver.getDriver(); method
         */
        return driverPool.get();
    }

    /*
    This method makes sure I have some form of driver session or driver id has.
    Either null or not null it must exist.
     */
    public static void closeDriver() {
        if (driverPool.get() != null) {
            driverPool.get().quit();
            driverPool.remove();
        }
    }
}

