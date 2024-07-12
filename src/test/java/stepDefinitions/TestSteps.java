package stepDefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.List;

public class TestSteps {
    @Given("user is on home page")
    public void userIsOnHomePage() {
        System.out.println("User is on home page");
    }

    @When("user click button")
    public void userClickButton() {
        System.out.println("User clicks button");
    }

    @Then("user should see following elements")
    public void userShouldSeeFollowingElements(DataTable table) {
        List<String> list = table.asList();
        System.out.println(list);
    }
}
