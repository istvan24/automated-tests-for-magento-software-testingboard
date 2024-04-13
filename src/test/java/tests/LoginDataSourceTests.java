package tests;

import ObjectModels.LoginModel;
import com.opencsv.exceptions.CsvException;
import dataProviders.DBDataProviders;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utils.CSVUtils;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class LoginDataSourceTests extends BaseTest {

    String browser = "chrome";

    /* ############################################## SQL (MySQL) ###########################################################  */

    @DataProvider(name = "sqlDP")
    public Iterator<Object[]> sqlDpCollection() throws Exception {
        Collection<Object[]> dp = new ArrayList<>();
        // define DB connection details -> to do -> we need to move this info inside config files in future
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

    /* ############################################## CSV ###########################################################  */

    @DataProvider(name = "csvDP")
    public Iterator<Object[]> csvDpCollection() throws IOException, CsvException {
        Collection<Object[]> dp = new ArrayList<>();

        List<String[]> csvData = CSVUtils.readCsv("src\\test\\resources\\Data\\testData.csv");

        //we create legend
        int usernamePoz = 0, passwordPoz = 1, usernameErrPoz = 2, passwordErrPoz = 3, generalErrPoz = 4;

        //we have header on csv, in this case we will drop first line
        for (int i = 1; i < csvData.size(); i++) {
            String[] line = csvData.get(i);
            LoginModel lm = new LoginModel(line[usernamePoz], line[passwordPoz], line[usernameErrPoz],
                    line[passwordErrPoz], line[generalErrPoz]);
            dp.add(new Object[]{lm});
        }
        return dp.iterator();
    }

    @Test(dataProvider = "csvDP")
    public void loginWithCSVAsDataSource(LoginModel lm) {
        loginWithLoginModel(lm, browser);
    }

}