package pageObjects;

import helpers.User;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegisterPage extends BasePage{

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

    @FindBy(id = "password")
    private WebElement passwordField;

    @FindBy(id = "password-error")
    private WebElement minimumValueErrorForpasswordField;

    @FindBy(id = "password-error")
    private WebElement errorMessagesForpasswordField;

    @FindBy(xpath = "//div[@id='password-strength-meter']")
    private WebElement passwordStrengthStrongMsg;

    @FindBy(id = "password-confirmation")
    private WebElement confirmPasswordField;

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

    public void fillRegistrationFields(User user) {
        firstNameField.sendKeys(user.getFirstName());
        lastNameField.sendKeys(user.getLastName());
        emailAdressField.sendKeys(user.getEmail());
        passwordField.sendKeys(user.getPassword());
        confirmPasswordField.sendKeys(user.getPassword());
    }

}
