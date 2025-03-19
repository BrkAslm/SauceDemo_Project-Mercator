package enums;

public enum LINKS {
    BASEURL("https://www.saucedemo.com/"),
    INVENTORYPAGE("https://www.saucedemo.com/inventory.html"),
    CARTPAGE("https://www.saucedemo.com/cart.html"),
    CHECKOUTSTEPONE("https://www.saucedemo.com/checkout-step-one.html"),
    CHECKOUTSTEPTWO("https://www.saucedemo.com/checkout-step-two.html"),
    TWITTERPAGE("https://twitter.com/saucelabs"),
    FACEBOOKPAGE("https://www.facebook.com/saucelabs"),
    LINKEDINPAGE("https://www.linkedin.com/company/sauce-labs/"),
    ;
    private String getLink;

    LINKS(String getLink) {
        this.getLink = getLink;
    }

    public String getLink() {
        return getLink;
    }
}
