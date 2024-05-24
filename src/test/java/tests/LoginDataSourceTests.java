package tests;

import objectModels.LoginModel;
import org.testng.annotations.Test;

public class LoginDataSourceTests extends BaseTest {
    String browser = "chrome";
    @Test(dataProvider = "jsonDataProvider")
    public void loginWithJsonAsDataSource(LoginModel lm) {
        loginWithLoginModel(lm, browser);
    }
    @Test(dataProvider = "sqlDataProvider")
    public void loginWithSQLAsDataSource(LoginModel lm) {
        loginWithLoginModel(lm, browser);
    }
    @Test(dataProvider = "csvDataProvider")
    public void loginWithCSVAsDataSource(LoginModel lm) {
        loginWithLoginModel(lm, browser);
    }
    @Test(dataProvider = "xlsxDataProvider")
    public void loginWithXLSXAsDataSource(LoginModel lm) {
        loginWithLoginModel(lm, browser);
    }

    private void loginWithLoginModel(LoginModel lm, String browser) {
    }
}