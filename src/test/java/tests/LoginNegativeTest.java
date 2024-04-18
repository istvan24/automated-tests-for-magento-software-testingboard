package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.LoginPage;

import static helpers.Constants.EMPTYDEMAIL;
import static helpers.Constants.EMPTYPASSWORD;

public class LoginNegativeTest extends BaseTest {

    @Test
    //Check if the login is not possible with invalid credentials.
    public void loginWithInvalidUsernameTest() {
        try {
            LoginPage signInPage = landingPage.clickSignIn();
            landingPage = signInPage.login(EMPTYDEMAIL, EMPTYPASSWORD);
            Assert.assertTrue(landingPage.loginEmailFieldisEmptyMsgDisplayed());
            Assert.assertTrue(landingPage.loginPassFieldisEmptyMsgDisplayed());
        } catch (Throwable e) {
            takeScreenshot();
            throw e;
        }
    }

}
