package tests;

import helpers.*;
import driver.WebDriverSingleton;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.asserts.SoftAssert;
import pageObjects.LandingPage;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class BaseTest {

    protected final SoftAssert softAssert = new SoftAssert();
    protected static WebDriver driver;
    protected static LandingPage landingPage;
    private int screenshotIndex = 0;

    @BeforeSuite
    public static void setupDriver() {
        driver = WebDriverSingleton.getDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

        landingPage = new LandingPage();
        landingPage.openLandingPage();
    }

    @AfterTest
    public void cleanUpAfterTest() {
        WebDriverSingleton.closeBrowserAtEnd();
    }

    //take Screenshoot for failed test and save them to the target folder
    protected void takeScreenshot() {
        File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        final String fileName = Constants.SCREENSHOT_FILE + screenshotIndex + ".png";

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