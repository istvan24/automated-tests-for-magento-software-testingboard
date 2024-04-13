package tests;

import com.pitechplus.qautils.annotations.TestInfo;
import helpers.User;
import org.testng.annotations.Test;
import pageObjects.AccountPage;
import pageObjects.RegisterPage;

public class RegisterTest extends BaseTest {

    @Test(groups = "New.user.registration")
    @TestInfo(expectedResult = "Check if new user can register")
    public void registerUserTest(){
        RegisterPage registerPage = landingPage.clickCreateNewAccountButton();
        AccountPage accountPage = registerPage.registerAccount(new User().createFakeUser());
        softAssert.assertTrue(accountPage.isRegistrationMsgDisplayed());

    }
}