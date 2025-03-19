package stepDefinitions.uiStepDef;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import pages.HomePage;

import java.util.ArrayList;
import java.util.List;

import static stepDefinitions.Hooks.commonPage;
import static stepDefinitions.Hooks.driver;

public class US_002_FailedLogin {
    @Given("assertion for unsuccesful login")
    public void assertionForUnsuccesfulLogin() {
        Assert.assertEquals("Epic sadface: Username and password do not match any user in this service",commonPage.getLoginPage().errorText.getText());
    }
}
