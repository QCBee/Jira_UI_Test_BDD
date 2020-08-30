package stepdefinition;

import com.google.common.io.Files;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import pages.CreateIssuePage;
import utils.WebDriverFactory;

import java.io.File;
import java.io.IOException;

public class CreateIssuePageSteps {
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

    @Then("^Create Issue Pop Up is shown$")
    public void onCreateIssuePopUp(){
        assert new CreateIssuePage().isCreateIssuePopUpShown();
    }

    @Then("^Project field is available$")
    public void projectFieldAvailable(){
        assert new CreateIssuePage().isProjectInputEnabled();
    }

    @Then("^Issue Type field is available$")
    public void issueTypeAvailable(){
        assert new CreateIssuePage().isTypeIssueInputEnabled();
    }

    @Then("^Summary field is available$")
    public void summaryAvailable(){
        assert new CreateIssuePage().isSummaryInputEnabled();
    }

    @When("^I fill Project field with valid data - ([^\"]*)$")
    public void enterProject(String projectValue){
        new CreateIssuePage().enterProject(projectValue);
    }

    @When("^I fill Issue Type with valid data - ([^\"]*)$")
    public void enterType(String typeValue){
        new CreateIssuePage().enterTypeIssue(typeValue);
    }

    @When("^I fill Summary field with valid data - ([^\"]*)$")
    public void enterSummary(String summaryValue){
        new CreateIssuePage().enterSummary(summaryValue);
    }

    @When("^I fill Reporter field with valid data - ([^\"]*)$")
    public void enterReporter(String reporterValue){
        new CreateIssuePage().enterReporter(reporterValue);
    }

    @And("^I click on Create button on Create Issue pop-up$")
    public void clickCreateButton(){
        new CreateIssuePage().clickCreateButton();
    }

    @Then("^Create issue pop-up is closed$")
    public void createIssuePopUpClosed(){
        assert new CreateIssuePage().isCreateIssuePopUpNotShown();
    }
}
