package tests;

import helpers.User;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import pageObjects.AccountPage;
import pageObjects.LandingPage;
import pageObjects.RegisterPage;

import static driver.WebDriverSingleton.closeBrowserAtEnd;

public class RegisterTest extends BaseTest {

    @Test
    //Check if new user can register.
    public void registerUserTest() {
        try {
            RegisterPage registerPage = landingPage.clickCreateNewAccountButton();
            AccountPage accountPage = registerPage.registerAccount(new User().createFakeUser());
            softAssert.assertTrue(accountPage.isRegistrationMsgDisplayed());
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