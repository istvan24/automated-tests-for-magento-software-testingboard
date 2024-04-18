package tests;

import ObjectModels.LoginModel;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class LoginDataSourceTests extends BaseTest {

    String browser = "chrome";

    /* ############################################## JSON #############################################################  */

    @DataProvider(name = "jsonDP")
    public Iterator<Object[]> jsonDpCollection() throws IOException {
        Collection<Object[]> dp = new ArrayList<>();
//      here we will start deserialization of json into LoginModel obj
        ObjectMapper objectMapper = new ObjectMapper();
        File file = new File("src\\test\\resources\\Data\\testData.json");

        LoginModel[] lmList = objectMapper.readValue(file, LoginModel[].class);

        for (LoginModel lm : lmList)
            dp.add(new Object[]{lm});

        return dp.iterator();
    }

    @Test(dataProvider = "jsonDP")
    public void loginWithJsonAsDataSource(LoginModel lm) {
        loginWithLoginModel(lm, browser);
    }

    /* ############################################## SQL (MySQL) ###########################################################  */

    @DataProvider(name = "sqlDP")
    public Iterator<Object[]> sqlDpCollection() throws Exception {
        Collection<Object[]> dp = new ArrayList<>();

        String dbHostname = "localhost";
        String dbUser = "root";
        String dbPassword = "root";
        String dbSchema = "aut14";
        String dbPort = "3306";

        // db connection
        Connection connection = DriverManager.getConnection("jdbc:mysql://" + dbHostname + ":" + dbPort + "/" +
                dbSchema, dbUser, dbPassword);

        Statement statement = connection.createStatement();

        ResultSet resultSet = statement.executeQuery("SELECT * FROM login_errors;");
        while (resultSet.next()) {
            LoginModel lm = new LoginModel(resultSet.getString("username"),
                    resultSet.getString("password"), resultSet.getString("usernameErr"),
                    resultSet.getString("passwordErr"), resultSet.getString("generalErr"));

            dp.add(new Object[]{lm});
        }

        return dp.iterator();
    }

    @Test(dataProvider = "sqlDP")
    public void loginWithSQLAsDataSource(LoginModel lm) {
        loginWithLoginModel(lm, browser);
    }

    private void loginWithLoginModel(LoginModel lm, String browser) {
    }
}