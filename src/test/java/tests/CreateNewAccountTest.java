package tests;

import helpers.User;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import pageObjects.AccountPage;
import pageObjects.RegisterPage;

public class CreateNewAccountTest extends BaseTest {

    @Test
    //Check if new user can register.
    public void createNewUserTest() {
        try {
            RegisterPage registerPage = landingPage.clickCreateNewAccountButton();
            AccountPage accountPage = registerPage.registerAccount(new User().createFakeUser());
            softAssert.assertTrue(accountPage.isRegistrationMsgDisplayed());
        } catch (Throwable e) {
            takeScreenshot();
            throw e;
        }
    }

    @AfterTest
    public void logout() {
        landingPage.clickLogout();
    }
}