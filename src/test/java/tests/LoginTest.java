package tests;

import org.testng.Assert;
import org.testng.annotations.*;
import pageObjects.LoginPage;

import static helpers.Constants.*;

public class LoginTest extends BaseTest {

    @Test
    //Check if the login is possible with valid credentials.
    public void loginWithValidCredentialsTests() {
        try {
            LoginPage loginPage = landingPage.clickSignIn();
            landingPage = loginPage.login(VALIDEMAIL, VALIDPASSWORD);
            Assert.assertTrue(landingPage.isLoggedInMsgDisplayed());
        } catch (Throwable e) {
            takeScreenshot();
            throw e;
        }
    }

    @AfterMethod
    public void logout() {
        landingPage.clickLogout();
    }

}
