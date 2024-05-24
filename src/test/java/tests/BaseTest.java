package tests;

import driver.WebDriverSingleton;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.testng.Reporter;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;
import pageObjects.LandingPage;
import utils.ConstantUtils;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class BaseTest {
    protected static WebDriver driver;
    protected static LandingPage landingPage;
    protected final SoftAssert softAssert = new SoftAssert();
    private int screenshotIndex = 0;

    @BeforeSuite
    public static void setupDriver() {
        driver = WebDriverSingleton.getDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        landingPage = new LandingPage();
        landingPage.openLandingPage();
    }

    @AfterTest
    public static void closeBrowser() {
        WebDriverSingleton.closeBrowserAtEnd();
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