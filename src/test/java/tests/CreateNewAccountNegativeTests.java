package tests;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pageObjects.RegisterPage;

import static helpers.Constants.*;

public class CreateNewAccountNegativeTests extends BaseTest {

    @Test
    //verify all warning messages on Create new account page
    public void VerifyWarningMessagesOnRegisterPage() {
        try {
            RegisterPage registerPage = landingPage.clickCreateNewAccountButton();
            registerPage.clickOnCreateAnAccountButton();

            //check the weak password strength
            String actualMessage = registerPage.noPasswordFieldPaswStrengthGetText();
            softAssert.assertEquals(actualMessage,PASSWORD_STRENGTH_NO_PASSWORD);

            softAssert.assertTrue(registerPage.firstNameRequiredFieldErrMsgDisplayed());
            softAssert.assertTrue(registerPage.lastNameRequiredFieldErrMsgDisplayed());
            softAssert.assertTrue(registerPage.emailAddressFieldErrMsgDisplayed());
            softAssert.assertTrue(registerPage.passwordFieldErrMsgDisplayed());
            softAssert.assertTrue(registerPage.confirmationPswFieldErrMsgDisplayed());
            softAssert.assertTrue(registerPage.requiredFieldsErrMsgDisplayed());

        } catch (Throwable e) {
            takeScreenshot();
            throw e;
        }
    }

    @Test
    //verify the warning message in case if an invalid email is introduced
    public void VerifyEmailAddressFormat() {

        try {
            RegisterPage registerPage = landingPage.clickCreateNewAccountButton();
            registerPage.fillInvalidEmailAddressFormat();
            registerPage.clickOnCreateAnAccountButton();

            String actualMessage = registerPage.passwordFieldErrMsgGetText();
            softAssert.assertEquals(actualMessage,INVALID_EMAIL_ADDRESS);
        } catch (Throwable e) {
            takeScreenshot();
            throw e;
        }
    }

    @Test
    //verify the minimum length of the password field error message
    public void VerifyShortPasswordWarningMsgOnRegisterPage() {

        try {
            RegisterPage registerPage = landingPage.clickCreateNewAccountButton();
            registerPage.fillInvalidPasswordOnRegistrationPage();

            String actualMessage = registerPage.passwordFieldErrMsgGetText();

            softAssert.assertEquals(actualMessage,SHORT_PSW_WARNING_MSG_ON_REGISTER_PAGE);
        } catch (Throwable e) {
            takeScreenshot();
            throw e;
        }
    }

    @Test
    //verify the minimum length of the password field error message
    public void VerifyInvalidPasswordWarningMsgOnRegisterPage() {

        try {
            RegisterPage registerPage = landingPage.clickCreateNewAccountButton();
            registerPage.fillInvalidPasswordOnRegistrationPage();
            registerPage.clickOnCreateAnAccountButton();

            String actualMessage = registerPage.passwordFieldErrMsgGetText();

            softAssert.assertEquals(actualMessage,INVALID_PSW_WARNING_MSG_ON_REGISTER_PAGE);
        } catch (Throwable e) {
            takeScreenshot();
            throw e;
        }
    }

    @Test
    //verify the message for the case, when confirm password is not the same as the first password
    public void VerifySecondPasswordWarningMsgOnRegisterPage() {

        try {
            RegisterPage registerPage = landingPage.clickCreateNewAccountButton();
            registerPage.secondPasswordIsNotInSyncOnRegistrationPage();

            String actualMessage = registerPage.confirmPasswordFieldErrMsgGetText();

            softAssert.assertEquals(actualMessage,CONFIRM_PSW_WARNING_MSG_ON_REGISTER_PAGE);
        } catch (Throwable e) {
            takeScreenshot();
            throw e;
        }
    }

}
