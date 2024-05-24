package tests;

import objectModels.LoginModel;
import org.testng.Assert;
import pageObjects.SignInPage;

public class LoginBasedTest extends BaseTest {
    SignInPage signInPage;

    protected void loginUser(String username, String password) {
        setupDriver();
        signInPage = new SignInPage();
        signInPage.login(username, password);
    }

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
    }
}
