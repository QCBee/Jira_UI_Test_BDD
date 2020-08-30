package stepdefinition;

import com.google.common.io.Files;
import io.cucumber.java.*;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import pages.HomePage;
import pages.LoginPage;
import utils.WebDriverFactory;
import java.io.File;
import java.io.IOException;

public class LoginPageSteps {

    @Before
    public void beforeCucumberScenario(Scenario scenario) {
        System.out.println("Starting execution: " + scenario.getName());
        WebDriverFactory.createInstance("Chrome");
    }

    @After
    public void afterCucumberScenario(Scenario scenario) {
        if (scenario.getStatus().toString().contains("FAILED")) {
            try {
                takeScreenshot();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        WebDriverFactory.getDriver().quit();
    }

    public void takeScreenshot() throws IOException {
        File scrFile = ((TakesScreenshot) WebDriverFactory.getDriver()).getScreenshotAs(OutputType.FILE);
        File trgtFile = new File(System.getProperty("user.dir") + "//screenshots/screenshot.png");
        System.out.println("SAVING Screenshot to " + trgtFile.getAbsolutePath());
        trgtFile.getParentFile().mkdir();
        trgtFile.createNewFile();
        Files.copy(scrFile, trgtFile);
    }

    @Then("^I navigate to Login Page$")
    public void navigateToLoginPage() {
        new LoginPage().navigateTo();
    }

    @Then("^I enter user name - \"(.*?)\"$")
    public void enterUserName(String userName) {
        new LoginPage().enterUserName(userName);
    }

    @Then("^I enter password - \"(.*?)\"$")
    public void enterPassword(String password) {
        new LoginPage().enterPassword(password);
    }

    @Then("^I click on login button$")
    public void clickLoginButton() {
        new LoginPage().clickLogin();
    }

    @Then("^I am on the Home Page$")
    public void atTheHomePage() {
        assert new HomePage().onPage();
    }

    @And("^I debug$")
    public void debug() {
        int a = 0;
    }

    @Then("^I stay at Login Page$")
    public void atLoginPage(){
        assert new LoginPage().onPage();
    }

    @And ("I enter ([^\"]*) and ([^\"]*)$")
    public void enterUserNameForUnsuccessfulFlow(String userName, String userPass){
        new LoginPage().enterUserName(userName);
        new LoginPage().enterPassword(userPass);

    }

    @And ("^I enter password - ([^\"]*)$")
    public void enterUserPassForUnsuccessfulFlow(String userPass){
        new LoginPage().enterPassword(userPass);

    }

}


