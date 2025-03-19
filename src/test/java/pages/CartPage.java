package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CartPage extends CommonPage {
        @FindBy(xpath = "//button[@id='checkout']")
        public WebElement checkOutButton;

        @FindBy(xpath = "//div[@class='inventory_item_name']")
        public List<WebElement> productName;

        @FindBy(xpath = "//div[@class='inventory_item_price']")
        public List<WebElement> productPrice;

    }


