package stepDefinitions.uiStepDef;

import enums.LINKS;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import pages.CommonPage;
import utilities.BrowserUtilities;
import utilities.ConfigurationReader;
import utilities.Driver;

import java.util.ArrayList;
import java.util.List;

import static stepDefinitions.Hooks.*;

public class US_001_LoginAndPurchase extends CommonPage {


    private List<String> itemName = new ArrayList<>();
    private List<Double> itemPrice = new ArrayList<>();
    ;


    @Given("user goes to login page")
    public void userGoesToLoginPage() {
        driver.get(ConfigurationReader.getProperty("baseUrl"));
    }

    @Given("user login with the username and password {string} and {string}")
    public void userLoginWithTheUsernameAndPasswordAnd(String userName, String password) {
        BrowserUtilities.login(userName, password);
    }

    @And("user clicks login button")
    public void userClicksLoginButton() {
        getLoginPage().loginButton.click();
    }

    @When("user selects the highest priced item on the inventory page")
    public void userSelectsHighestPricedItemOnTheInventoryPage() {
        List<WebElement> productNames = getHomePage().productName;
        List<WebElement> productPrices = getHomePage().productPrice;
        List<WebElement> addToCartButtons = getHomePage().addtoCart;

        double highestPrice = 0.0;
        int highestPriceIndex = 0;

        for (int i = 0; i < productPrices.size(); i++) {
            double price = Double.parseDouble(productPrices.get(i).getText().replace("$", ""));
            if (price > highestPrice) {
                highestPrice = price;
                highestPriceIndex = i;
            }
        }

        itemName.add(productNames.get(highestPriceIndex).getText());
        itemPrice.add(highestPrice);
        addToCartButtons.get(highestPriceIndex).click();
    }


    @When("user selects items on the inventory page")
    public void userSelectsItemsOnTheInventoryPage() {
        itemName.add(getHomePage().productName.get(0).getText());
        itemPrice.add(Double.parseDouble(getHomePage().productPrice.get(0).getText().replace("$","")));
        getHomePage().addtoCart.get(0).click();
        itemName.add(getHomePage().productName.get(1).getText());
        itemPrice.add(Double.parseDouble(getHomePage().productPrice.get(1).getText().replace("$","")));
        getHomePage().addtoCart.get(0).click();

    }

    @When("user clicks on the basket icon to go to the basket page")
    public void userClicksOnTheBasketIconToGoToTheBasketPage() {
        BrowserUtilities.waitForVisibility(getHomePage().goToCartNumber, 5);
        getHomePage().goToCartNumber.click();
    }

    @Then("user is able to be on the basket page")
    public void userIsAbleToBeOnTheBasketPage() {
        Assert.assertEquals(LINKS.CARTPAGE.getLink(),Driver.getDriver().getCurrentUrl());
    }

    @When("user clicks on the check out button")
    public void userClicksOnTheCheckOutButton() {
        getCartPage().checkOutButton.click();
    }

    @Then("user is able to be on the checkout page")
    public void userIsAbleToBeOnTheCheckoutPage() {
        Assert.assertEquals(LINKS.CHECKOUTSTEPONE.getLink(),Driver.getDriver().getCurrentUrl());
        Assert.assertEquals(getHomePage().title.getText(),"Checkout: Your Information");

    }

    @And("user able to see product has been added to cart")
    public void userAbleToSeeProductHasBeenAddedToCart(){
        Assert.assertEquals(itemName.get(0),getCartPage().productName.get(0).getText());
    }

    @When("user enters the firstname as {string} , lastname as {string}, and postalcode as {string}")
    public void userEntersTheFirstnameAsLastnameAsAndPostalcodeAs(String name, String lastname, String postalCode) {
        BrowserUtilities.waitForVisibility(getCheckoutPage().firstNameBox, 5);
        getCheckoutPage().firstNameBox.sendKeys(name);
        getCheckoutPage().lastNameBox.sendKeys(lastname);
        getCheckoutPage().postalCodeBox.sendKeys(postalCode);
    }

    @Then("user is able to see the firstname as {string} , lastname as {string}, and postalcode as {string}")
    public void userIsAbleToSeeTheFirstnameAsLastnameAsAndPostalcodeAs(String firstName, String lastName, String postalCode) {
        Assert.assertEquals(firstName,getCheckoutPage().firstNameBox.getAttribute("value"));
        Assert.assertEquals(lastName,getCheckoutPage().lastNameBox.getAttribute("value"));
        Assert.assertEquals(postalCode,getCheckoutPage().postalCodeBox.getAttribute("value"));
    }

    @When("user clicks on continue button")
    public void userClicksOnContinueButton() {
        getCheckoutPage().continueButton.click();
    }

    @Then("user is able to be on the overview page")
    public void userIsAbleToBeOnTheOverviewPage() {
        Assert.assertEquals(LINKS.CHECKOUTSTEPTWO.getLink(),Driver.getDriver().getCurrentUrl());
        Assert.assertEquals(getHomePage().title.getText(),"Checkout: Overview");
    }

    @And("user is able to see prices of the items")
    public void userIsAbleToSeePricesOfTheItems() {
        Assert.assertTrue(Double.parseDouble(getCartPage().productPrice.get(0).getText().replace("$",""))>0);
        Assert.assertEquals(itemPrice.get(0), Double.parseDouble(getCartPage().productPrice.get(0).getText().replace("$","")),0.0);
    }


    @And("is able to see the total is equal to tax plus item total")
    public void isAbleToSeeTheTotalIsEqualToTaxPlusItemTotal() {
        Assert.assertEquals(itemPrice.get(0) + Double.parseDouble(getCheckoutPage().taxLabel.getText().substring(6, 10)), Double.parseDouble(getCheckoutPage().totalLabel.getText().substring(8, 13)), 0.0);
    }

    @When("user clicks on finish button")
    public void userClicksOnFinishButton() {
       getCheckoutPage().finishButton.click();
    }

    @Then("user is able to see the {string} message")
    public void userIsAbleToSeeTheMessage(String arg0) {
        Assert.assertEquals("Thank you for your order!", getCheckoutPage().successMessageForFinish.getText());
    }
    @And("user is able to see items' names and totals are equal on the cart")
    public void userIsAbleToSeeItemTotalIsEqualToItemPrice() {
        List<String> productNamesOnTheCart = new ArrayList<>();

        List<Double> productPricesOnTheCart = new ArrayList<>();

        productNamesOnTheCart.add(getCartPage().productName.get(0).getText());
        productPricesOnTheCart.add(Double.valueOf(getCartPage().productPrice.get(0).getText().substring(1)));

        productNamesOnTheCart.add(getCartPage().productName.get(1).getText());
        productPricesOnTheCart.add(Double.valueOf(getCartPage().productPrice.get(1).getText().substring(1)));

        Assert.assertEquals(itemName,productNamesOnTheCart);
        Assert.assertEquals(itemPrice,productPricesOnTheCart);

    }
}