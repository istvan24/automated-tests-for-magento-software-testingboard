package tests;

import org.testng.annotations.Test;
import pageObjects.AccountPage;
import pageObjects.RegisterPage;

public class CreateNewAccountNegativeTests extends BaseTest{

    @Test
    //verify all warning messages on Create new account page
    public void VerifyWarningMessagesOnRegisterPage() {
        try {
            RegisterPage registerPage = landingPage.clickCreateNewAccountButton();
            registerPage.cickOnCreateAnAccountButton();

            softAssert.assertTrue(registerPage.firstNameRequiredFieldErrMsgDisplayed());
            softAssert.assertTrue(registerPage.lastNameRequiredFieldErrMsgDisplayed());
            softAssert.assertTrue(registerPage.emailAddressFieldErrMsgDisplayed());
            softAssert.assertTrue(registerPage.passwordFieldErrMsgDisplayed());
            softAssert.assertTrue(registerPage.confirmationPasswordFieldErrMsgDisplayed());
            softAssert.assertTrue(registerPage.requiredFieldsErrMsgDisplayed());

        } catch (Throwable e) {
            takeScreenshot();
            throw e;
        }
    }
}
