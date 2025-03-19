package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends CommonPage {

    @FindBy(css = "[data-test=username]")
    public WebElement userNameBox;

    @FindBy(css = "[data-test=password]")
    public WebElement passwordBox;

    @FindBy(id = "login-button")
    public WebElement loginButton;

    @FindBy(css = "h3[data-test='error']")
    public WebElement errorText;

}
