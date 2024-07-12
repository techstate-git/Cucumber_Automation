package stepDefinitions.sauceDemo;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import pages.sauceDemo.HomePage;

import java.util.List;

import static stepDefinitions.Hooks.driver;

public class SauceHomeSteps {
    HomePage homePage = new HomePage(driver);

    @Given("user is adding to cart items below")
    public void add_items_to_cart(List<String> items){
        homePage.clickOnItem(items);
    }

    @Then("prices are not exceed $ {double}")
    public void store_all_prices(Double expectedPrice){
        boolean decision = homePage.itemsPriceCheck(expectedPrice);
        // decision is true - found a bug
        // decision is false - no bug
        Assert.assertFalse(decision);
    }
}
