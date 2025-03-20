package utilities;


import enums.USERS;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import static stepDefinitions.Hooks.commonPage;
import static stepDefinitions.Hooks.driver;

public class BrowserUtilities {
    /**
     * it is used to make a hard wait
     * @param seconds it is a total waiting time in seconds
     * @author burak
     * @since 19.03.2025
     */

    public static void waitFor(int seconds) {
        try {
            Thread.sleep(seconds * 1000L);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void clickWithJs(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true); arguments[0].click();", element);
    }

    public static void scrollToElement(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public static void clearValue(WebElement element, String text) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].setAttribute('value','" + text + "')", element);
    }

    public static void clearValue(WebElement element) {
        String value = element.getAttribute("value");
        for (int i = 0; i < value.length(); i++) {
            element.sendKeys(Keys.BACK_SPACE);
        }
    }


    /**
     * method will wait until you click to the element
     *
     * @return current year: 2025
     * @author burak
     * @since 19.03.2025
     */
    public static String getCurrentYear() {//2025
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
        Date date = new Date();
        return sdf.format(date);
    }


    public static String getCurrentMonth() {
        SimpleDateFormat sdf = new SimpleDateFormat("MMM");
        Date date = new Date();
        return sdf.format(date);
    }

    public static String getCurrentDay() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd");
        Date date = new Date();
        return sdf.format(date);
    }

    public static WebElement waitForVisibility(WebElement element, int timeToWaitInSec) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(timeToWaitInSec));
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    public static void login(String userName, String password) {
        commonPage.getLoginPage().userNameBox.sendKeys(userName);
        commonPage.getLoginPage().passwordBox.sendKeys(password);
        commonPage.getLoginPage().loginButton.click();

    }

    public static void loginThroughEnum(USERS users) {
        commonPage.getLoginPage().userNameBox.sendKeys(users.getUsername());
        commonPage.getLoginPage().passwordBox.sendKeys(users.getPassword());

    }
}