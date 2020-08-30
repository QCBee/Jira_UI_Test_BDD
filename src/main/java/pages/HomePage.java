package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.WebDriverFactory;
import java.time.Duration;
import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

public class HomePage {
    private By userProfileIcon = By.cssSelector(".aui-avatar-inner");

    public boolean onPage(){
        WebDriverWait wait = new WebDriverWait(WebDriverFactory.getDriver(), Duration.ofSeconds(5).getSeconds());
        return wait.until(presenceOfElementLocated(userProfileIcon)).isDisplayed();
    }

}
