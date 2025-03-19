package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutPage  extends CommonPage {

    @FindBy(xpath = "//input[@data-test='firstName']")
    public WebElement firstNameBox;

    @FindBy(xpath = "//input[@data-test='lastName']")
    public WebElement lastNameBox;

    @FindBy(xpath = "//input[@data-test='postalCode']")
    public WebElement postalCodeBox;

    @FindBy(xpath = "//input[@data-test='continue']")
    public WebElement continueButton;

    @FindBy(css = "button#finish")
    public WebElement finishButton;

    @FindBy(xpath = "//h2")
    public WebElement successMessageForFinish;

    @FindBy(xpath = "//div[@class='summary_tax_label']")
    public WebElement taxLabel;

    @FindBy(xpath = "//div[@class='summary_info_label summary_total_label']")
    public WebElement totalLabel;

}
