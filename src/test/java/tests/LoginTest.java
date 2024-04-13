package tests;

import com.pitechplus.qautils.annotations.TestInfo;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageObjects.SignInPage;

import static helpers.Constants.*;


public class LoginTest extends BaseTest {

    @DataProvider(name = "positiveLogin")
    public Object[][] dataProviderForPositiveLogin() {
        return new Object[][]{
                //       username | password | browserName
                {"fabianestefan31@gmail.com", "n6LfBFsXKi9ks@i", "chrome"},
        };
    }

    @TestInfo(expectedResult = "Check if the login is possible with valid credentials.")
    public void loginWithValidCredentialsTests() {
        try {
            SignInPage signInPage = landingPage.clickSignIn();
            landingPage = signInPage.login(VALIDEMAIL, VALIDPASSWORD);
            Assert.assertTrue(landingPage.isLoggedInMsgDisplayed());
        } catch (Throwable e) {
            takeScreenshot();
            throw e;
        } finally {
            driver.quit();
        }
    }

    @Test(groups = "Login")
    @TestInfo(expectedResult = "Check if the login is not possible with invalid credentials.")
    public void loginWithInvalidUsernameTest() {
        try {
            SignInPage signInPage = landingPage.clickSignIn();
            landingPage = signInPage.login(EMPTYDEMAIL, EMPTYPASSWORD);
            Assert.assertTrue(landingPage.loginEmailFieldisEmptyMsgDisplayed());
            Assert.assertTrue(landingPage.loginPassFieldisEmptyMsgDisplayed());
        } catch (Throwable e) {
            takeScreenshot();
            throw e;
        } finally {
            driver.quit();
        }
    }
}
