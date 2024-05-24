package tests;

import driver.WebDriverSingleton;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pageObjects.LandingPage;
import pageObjects.SignInPage;
import utils.ConstantUtils;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import static helpers.Constants.EMPTYDEMAIL;
import static helpers.Constants.EMPTYPASSWORD;

public class LoginNegativeTest {
    protected static WebDriver driver;
    protected static LandingPage landingPage;
    protected final SoftAssert softAssert = new SoftAssert();
    private int screenshotIndex = 0;

    @Test
    //Check if the login is not possible with invalid credentials.
    public void loginWithInvalidUsernameTest() {
        try {
            driver = WebDriverSingleton.getDriver();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

            landingPage = new LandingPage();
            landingPage.openLandingPage();

            SignInPage signInPage = landingPage.clickSignIn();
            landingPage = signInPage.login(EMPTYDEMAIL, EMPTYPASSWORD);

            softAssert.assertTrue(landingPage.loginEmailFieldisEmptyMsgDisplayed());
            softAssert.assertTrue(landingPage.loginPassFieldisEmptyMsgDisplayed());
            softAssert.assertAll();
        } catch (Throwable e) {
            takeScreenshot();
            throw e;
        }
    }

    //take Screenshoot for failed test and save them to the target folder
    protected void takeScreenshot() {
        File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        final String fileName = ConstantUtils.SCREENSHOT_FILE + screenshotIndex + ".png";

        File finalFile = new File(fileName);

        try {
            FileUtils.copyFile(screenshotFile, finalFile);
            Reporter.log("<img src='screenshot" + screenshotIndex + ".png' width='400' height='400'>");
        } catch (IOException e) {
            e.printStackTrace();
        }
        screenshotIndex++;
    }
}
