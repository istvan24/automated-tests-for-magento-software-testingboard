package tests;

import driver.WebDriverSingleton;
import org.testng.annotations.AfterTest;
import pageObjects.LoginPage;
import pageObjects.WelcomePage;
import org.testng.annotations.AfterMethod;

public class LoginBasedTest extends BaseTest {

    LoginPage signInPage;
    WelcomePage welcomePage;

    protected void loginUser(String username, String password) {
        setupDriver();
        //driver.get(url + "/signin");
        signInPage = new LoginPage();
        welcomePage = new WelcomePage();
        signInPage.login(username, password);
    }
/*
    protected void loginUserCheckErr(String username, String password, String usernameError, String passwordError,
                                     String generalError) {

        loginUser(username, password);

        if (usernameError.isEmpty() && passwordError.isEmpty())
            Assert.assertEquals(generalError, signInPage.getGeneralErr());
        else {
            if (!usernameError.isEmpty())
                Assert.assertEquals(usernameError, signInPage.getUsernameErr());
            if (!passwordError.isEmpty())
                Assert.assertEquals(passwordError, signInPage.getPassErr());
        }

    }

    protected void loginWithLoginModel(LoginModel loginModel) {
        System.out.println(loginModel);
        loginUserCheckErr(loginModel.getAccount().getUsername(), loginModel.getAccount().getPassword(),
                loginModel.getUsernameErr(), loginModel.getPasswordErr(), loginModel.getGeneralErr());
    }*/

}
