package tests;

import org.testng.Assert;
import org.testng.annotations.*;
import pageObjects.LoginPage;

import static driver.WebDriverSingleton.closeBrowserAtEnd;
import static helpers.Constants.*;

public class LoginTest extends BaseTest {

    @Test
    //Check if the login is possible with valid credentials.
    public void loginWithValidCredentialsTests() {
        try {
            LoginPage signInPage = landingPage.clickSignIn();
            landingPage = signInPage.login(VALIDEMAIL, VALIDPASSWORD);
            Assert.assertTrue(landingPage.isLoggedInMsgDisplayed());
        } catch (Throwable e) {
            takeScreenshot();
            throw e;
        }

    }

}
