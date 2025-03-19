package pages;

import org.openqa.selenium.support.PageFactory;

import static stepDefinitions.Hooks.driver;

public abstract class CommonPage {
    public CommonPage() {
        PageFactory.initElements(driver, this);
    }

    private HomePage homePage;

    private LoginPage loginPage;

    private CartPage cartPage;

    private CheckoutPage checkoutPage;


    public HomePage getHomePage() {
        if (homePage == null) {
            homePage = new HomePage();
        }
        return homePage;
    }

    public LoginPage getLoginPage() {
        if (loginPage == null) {
            loginPage = new LoginPage();
        }
        return loginPage;
    }

    public CartPage getCartPage() {
        if (cartPage == null) {
            cartPage = new CartPage();
        }
        return cartPage;
    }

    public CheckoutPage getCheckoutPage() {
        if (checkoutPage == null) {
            checkoutPage = new CheckoutPage();
        }
        return checkoutPage;
    }

}
