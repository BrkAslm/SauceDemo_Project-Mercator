package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class HomePage extends CommonPage {
    @FindBy(css = ".btn_inventory")
    public List<WebElement> addtoCartGeneral;

    @FindBy(css = "[data-test^=add-to-cart]")
    public List<WebElement> addtoCart;

    @FindBy(css = ".shopping_cart_badge")
    public WebElement goToCartNumber;

    @FindBy(css = ".shopping_cart_link")
    public WebElement goToCart;

    @FindBy(css = "[class=title]")
    public WebElement title;

    @FindBy(xpath = "//div[@data-test='inventory-item-name']")
    public List<WebElement> productName;

    @FindBy(xpath = "//div[@class='inventory_item_price']")
    public List<WebElement> productPrice;
}