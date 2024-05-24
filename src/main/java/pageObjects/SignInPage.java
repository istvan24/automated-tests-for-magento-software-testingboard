package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SignInPage extends BasePage{

    @FindBy(id = "email")
    WebElement emailField;

    @FindBy(id = "pass")
    WebElement passwordField;

    @FindBy(id = "send2")
    WebElement signInButton;

    @FindBy(xpath = "//div[@role='alert']")
    WebElement generalErrorElement;

    public SignInPage() {
        super();
    }

    public LandingPage login(String email, String password) {
        fillEmailField(email);
        fillPasswordField(password);
        clickSignInButton();
        return new LandingPage();
    }

    private void fillEmailField(String email) {
        emailField.clear();
        emailField.sendKeys(email);
    }

    private void fillPasswordField(String password) {
        passwordField.clear();
        passwordField.sendKeys(password);
    }

    public void clickSignInButton() {
        signInButton.click();
    }

    public String getUsernameErr() {
        return getErrorMsg("user");
    }

    public String getPassErr() {
        return getErrorMsg("pass");
    }

    public String getGeneralErr() {
        return generalErrorElement.getText();
    }

    //TODO - find a commun slector if possible
    private String getErrorMsg(String type) {
        return wait.until(
                ExpectedConditions.presenceOfElementLocated(
                        By.xpath("//div[@id='" + type + "-error']"))).getText();
    }
}
