package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WelcomePage extends BasePage {

    @FindBy(className = "logged-in")
    private WebElement loggedInMessage;

    public WelcomePage() {
        super();
    }

    public boolean loggedInMessageDisplayed() {
        return loggedInMessage.isDisplayed();
    }
}
