package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static helpers.Constants.WEBPAGE;

public class LandingPage extends BasePage {

    @FindBy(css = "li.authorization-link a")
    private WebElement signInButton;

    @FindBy(xpath = "//div[@aria-hidden='false']//a[normalize-space()='Sign Out']")
    private WebElement logoutButton;

    @FindBy(css = ".authorization-link + li a")
    private WebElement createNewAccountButton;

    @FindBy(className = "logged-in")
    private WebElement loggedInMessage;

    @FindBy(id = "email-error")
    private WebElement loginEmailErrorMessage;

    @FindBy(id = "pass-error")
    private WebElement loginPassErrorMessage;

    //"Please enter a valid email address (Ex: johndoe@domain.com).""
    @FindBy(id = "pass-error")
    private WebElement loginInvalidEmailErrorMessage;

    @FindBy(id = "pass-error")
    private WebElement loginInvalidPassErrorMessage;

    @FindBy(className = "switch")
    private WebElement accountSwitchMenuButton;

    @FindBy(css = ".customer-menu li:nth-of-type(1)")
    private WebElement myAccountButton;

    public LandingPage() {
        super();
    }

    public NavigationBar getNavigationBar() {
        return new NavigationBar();
    }

    public void openLandingPage() {
        driver.get(WEBPAGE);
    }

    public SignInPage clickSignIn() {

        signInButton.click();
        return new SignInPage();
    }

    public SignInPage clickLogout() {
        clickAccountMenuButton();
        logoutButton.click();
        return new SignInPage();
    }

     public RegisterPage clickCreateNewAccountButton() {
        createNewAccountButton.click();
        return new RegisterPage();
    }

    public AccountPage clickMyAccountButton() {
        clickAccountMenuButton();
        myAccountButton.click();
        return new AccountPage();
    }

    public boolean isLoggedInMsgDisplayed() {
        return loggedInMessage.isDisplayed();
    }

    public boolean loginEmailFieldisEmptyMsgDisplayed() {
        return loginEmailErrorMessage.isDisplayed();
    }

    public boolean loginPassFieldisEmptyMsgDisplayed() {
        return loginPassErrorMessage.isDisplayed();
    }

    public void clickAccountMenuButton() {
        accountSwitchMenuButton.click();
    }

}
