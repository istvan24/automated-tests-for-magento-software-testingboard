package dataProviders;

import ObjectModels.LoginModel;
import org.testng.annotations.DataProvider;
import utils.DatabaseUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class DBDataProviders
{
    @DataProvider(name = "login_errors_sql")
    public Iterator<Object[]> loginErrorsDpCollection() throws Exception {
        Collection<Object[]> dp = new ArrayList<>();

        DatabaseUtils databaseUtils = new DatabaseUtils();
        // db connection
        Connection connection = databaseUtils.connect();
        Statement statement = databaseUtils.getStatement(connection);

        ResultSet resultSet = statement.executeQuery("SELECT * FROM login_errors;");
        while (resultSet.next()) {
            LoginModel lm = new LoginModel(resultSet.getString("username"),
                    resultSet.getString("password"), resultSet.getString("usernameErr"),
                    resultSet.getString("passwordErr"), resultSet.getString("generalErr"));

            dp.add(new Object[]{lm});
        }

        return dp.iterator();
    }
}
