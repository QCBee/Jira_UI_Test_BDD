package stepdefinition;

import com.google.common.io.Files;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import pages.HomePage;
import utils.WebDriverFactory;

import java.io.File;
import java.io.IOException;

public class HomePageSteps {
    @After
    public void afterCucumberScenario(Scenario scenario) {
        if (scenario.getStatus().toString().contains("FAILED")) {
            try {
                takeScreenshot();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        WebDriverFactory.closeBrowser();
    }

    public void takeScreenshot() throws IOException {
        File scrFile = ((TakesScreenshot) WebDriverFactory.getDriver()).getScreenshotAs(OutputType.FILE);
        File trgtFile = new File(System.getProperty("user.dir") + "//screenshots/screenshot.png");
        System.out.println("SAVING Screenshot to " + trgtFile.getAbsolutePath());
        trgtFile.getParentFile().mkdir();
        trgtFile.createNewFile();
        Files.copy(scrFile, trgtFile);
    }

    @Then("^I am on the Home Page$")
    public void atTheHomePage() {
        assert new HomePage().onPage();
    }

    @Given("^I click on Create button on Home Page$")
    public void clickCreateButton(){
        new HomePage().clickCreateIssueButton();
    }

    @Then("^Successful notification is shown on Home Page$")
    public void successfulNotificationShown(){
        assert new HomePage().isIssueCreateNotificationShown();
    }
}