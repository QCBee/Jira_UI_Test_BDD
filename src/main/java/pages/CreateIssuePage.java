package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.WebDriverFactory;
import java.time.Duration;

public class CreateIssuePage {
    //List of used locators - locators for actions
    private By createIssuePopPup = By.id("create-issue-dialog");
    private By projectInput = By.id("project-field");
    private By issueTypeInputEnabled = By.xpath("//*[@id='issuetype-field'][not(@disabled)]");
    private By issueTypeInput = By.id("issuetype-field");
    private By summaryInputEnabled = By.xpath("//*[@id='summary'][not(@disabled)]");
    private By summaryInput = By.id("summary");
    private By reporterInput = By.id("reporter-field");
    private By createButton = By.id("create-issue-submit");

    public boolean isCreateIssuePopUpShown() {
        WebDriverWait wait = new WebDriverWait(WebDriverFactory.getDriver(), Duration.ofSeconds(TimeOutTypes.LOW.getTimeOutInSec()).getSeconds());
        return wait.until(ExpectedConditions.presenceOfElementLocated(createIssuePopPup)).isDisplayed();
    }

    public boolean isCreateIssuePopUpNotShown() {
        WebDriverWait wait = new WebDriverWait(WebDriverFactory.getDriver(), Duration.ofSeconds(TimeOutTypes.LOW.getTimeOutInSec()).getSeconds());
        return wait.until(ExpectedConditions.invisibilityOfElementLocated(createIssuePopPup));
    }

    public boolean isProjectInputEnabled() {
        WebDriverWait wait = new WebDriverWait(WebDriverFactory.getDriver(), Duration.ofSeconds(TimeOutTypes.LOW.getTimeOutInSec()).getSeconds());
        return wait.until(ExpectedConditions.presenceOfElementLocated(createIssuePopPup)).isDisplayed();
    }

    public void enterProject(String projectValue) {
        WebDriverFactory.getDriver().findElement(projectInput).clear();
        WebDriverFactory.getDriver().findElement(projectInput).sendKeys(projectValue);
        WebDriverFactory.getDriver().findElement(projectInput).sendKeys(Keys.ENTER);
    }

    public boolean isTypeIssueInputEnabled() {
        WebDriverWait wait = new WebDriverWait(WebDriverFactory.getDriver(), Duration.ofSeconds(TimeOutTypes.LOW.getTimeOutInSec()).getSeconds());
        return wait.until(ExpectedConditions.presenceOfElementLocated(issueTypeInputEnabled)).isEnabled();
    }

    public void enterTypeIssue(String typeValue) {
        clickOnElementWithRetry(issueTypeInput, issueTypeInputEnabled, 4, TimeOutTypes.LOW.getTimeOutInSec());
        WebDriverFactory.getDriver().findElement(issueTypeInputEnabled).clear();
        WebDriverFactory.getDriver().findElement(issueTypeInputEnabled).sendKeys(typeValue);
        WebDriverFactory.getDriver().findElement(issueTypeInputEnabled).sendKeys(Keys.ENTER);
    }

    public boolean isSummaryInputEnabled() {
        WebDriverWait wait = new WebDriverWait(WebDriverFactory.getDriver(), Duration.ofSeconds(TimeOutTypes.LOW.getTimeOutInSec()).getSeconds());
        return wait.until(ExpectedConditions.presenceOfElementLocated(summaryInput)).isEnabled();
    }

    public void enterSummary(String summaryValue) {
        clickOnElementWithRetry(summaryInput, summaryInputEnabled, 4, TimeOutTypes.LOW.getTimeOutInSec());
        WebDriverFactory.getDriver().findElement(summaryInput).sendKeys(summaryValue);
    }

    public void enterReporter(String reporterValue) {
        WebDriverFactory.getDriver().findElement(reporterInput).clear();
        WebDriverFactory.getDriver().findElement(reporterInput).sendKeys(reporterValue);
        WebDriverFactory.getDriver().findElement(reporterInput).sendKeys(Keys.ENTER);
    }

    public void clickCreateButton() {
        WebDriverFactory.getDriver().findElement(createButton).click();
    }

    private void clickOnElementWithRetry(By elementToBeClicked, By successCriteria, int attempts, int timeOutInSec) {
        WebDriverWait wait = new WebDriverWait(WebDriverFactory.getDriver(), timeOutInSec);
        for (int i = 0; i < attempts; i++) {
            WebDriverFactory.getDriver().findElement(elementToBeClicked).click();
            try {
                wait.until(ExpectedConditions.visibilityOfElementLocated(successCriteria)).isDisplayed();
                break;
            } catch (TimeoutException e) {
                e.printStackTrace();

            }
        }
    }
}
