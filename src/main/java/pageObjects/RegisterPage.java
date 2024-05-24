package pageObjects;

import helpers.User;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegisterPage extends BasePage {

    @FindBy(id = "firstname")
    private WebElement firstNameField;

    @FindBy(xpath = "//div[@id='firstname-error']")
    private WebElement firstNameRequiredFieldErrMsg;

    @FindBy(id = "lastname")
    private WebElement lastNameField;

    @FindBy(xpath = "//div[@id='lastname-error']")
    private WebElement lastNameRequiredFieldErrMsg;

    @FindBy(id = "email_address")
    private WebElement emailAdressField;

    @FindBy(xpath = "//div[@id='email_address-error']")
    private WebElement emailAddressFieldErrMsg;

    @FindBy(id = "password")
    private WebElement passwordField;

    @FindBy(id = "password-error")
    private WebElement passwordFieldErrMsg;

    @FindBy(id = "password-confirmation-error")
    private WebElement confirmPasswordFieldErrMsg;


    @FindBy(xpath = "//div[@id='password-strength-meter']")
    private WebElement passwordStrengthStrongMsg;

    @FindBy(id = "password-confirmation")
    private WebElement confirmPasswordField;

    @FindBy(xpath = "//fieldset[@class='fieldset create account']")
    private WebElement requiredFieldsErrMsg;

    @FindBy(className = "submit")
    private WebElement createAnAccountButton;

    public RegisterPage() {
        super();
    }


    public AccountPage registerAccount(User user) {
        fillRegistrationFields(user);
        createAnAccountButton.click();
        return new AccountPage();
    }

    public AccountPage cickOnCreateAnAccountButton() {
        createAnAccountButton.click();
        return new AccountPage();
    }

    public void fillRegistrationFields(User user) {
        firstNameField.sendKeys(user.getFirstName());
        lastNameField.sendKeys(user.getLastName());
        emailAdressField.sendKeys(user.getEmail());
        passwordField.sendKeys(user.getPassword());
        confirmPasswordField.sendKeys(user.getPassword());
    }

    public boolean firstNameRequiredFieldErrMsgDisplayed() {
        return firstNameRequiredFieldErrMsg.isDisplayed();
    }

    public boolean lastNameRequiredFieldErrMsgDisplayed() {
        return lastNameRequiredFieldErrMsg.isDisplayed();
    }

    public boolean emailAddressFieldErrMsgDisplayed() {
        return emailAddressFieldErrMsg.isDisplayed();
    }

    public boolean passwordFieldErrMsgDisplayed() {
        return passwordFieldErrMsg.isDisplayed();
    }

    public boolean confirmationPasswordFieldErrMsgDisplayed() {
        return confirmPasswordFieldErrMsg.isDisplayed();
    }

    public boolean requiredFieldsErrMsgDisplayed() {
        return requiredFieldsErrMsg.isDisplayed();
    }
}
