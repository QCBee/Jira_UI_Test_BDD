package stepdefinition;

import io.cucumber.java.en.Then;
import pages.HomePage;

public class HomePageSteps {
    @Then("^I am on the Home Page$")
    public void atTheHomePage() {
        assert new HomePage().onPage();
    }
}
