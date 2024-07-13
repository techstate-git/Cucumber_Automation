package stepDefinitions.ui.orangeHRM;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.orangeHRM.AdminPage;
import pages.orangeHRM.HomePage;
import stepDefinitions.Hooks;
import utilities.WebUtils;

import java.time.Duration;

public class AdminSteps {

    private AdminPage adminPage = new AdminPage(Hooks.driver);
    private HomePage homePage = new HomePage(Hooks.driver);

    @And("the admin enters username in the search field {string}")
    public void theAdminEntersUsername(String u)  {
        adminPage.enterUsername(u);
    }

    @And("the admin clicks searchBox")
    public void theAdminClicksSearchBox()  {
        adminPage.getSearchBtn().click();
    }

    @Then("there should be record found")
    public void thereShouldBeRecordFound() throws InterruptedException {
        Thread.sleep(1000);
        Assert.assertTrue(adminPage.getRecordsFound().getText().contains("1"));
    }

    @When("the user clicks admin menu section")
    public void theUserClicksAdminMenuSection() {
        WebUtils.clickElement(homePage.getAdminMenuSection(), Duration.ofSeconds(5));
    }
}
