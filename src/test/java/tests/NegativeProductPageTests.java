package tests;

import com.pitechplus.qautils.annotations.TestInfo;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.StorePage;

import static helpers.Constants.*;


public class NegativeProductPageTests extends BaseTest {

    @Test
    @TestInfo(expectedResult = "Check if both validation messages appears for on Product page if no size and no " +
            "color is selected.")
    public void verifyRequiredFieldMessageTest() {

        StorePage storePage = landingPage.getNavigationBar().selectCategory(NEW_CATEGORY);
        storePage.addProductsToCartWithoutQty();

        WebElement warningMessageForSize = driver.findElement(
                By.cssSelector("div.swatch-attribute.size > div.mage-error"));
        Assert.assertTrue(warningMessageForSize.getText().contains("This is a required field."),
                "Warning message for size is not displayed");

        WebElement warningMessageForColor = driver.findElement(
                By.cssSelector("div.swatch-attribute.color > div.mage-error"));
        Assert.assertTrue(warningMessageForColor.getText().contains("This is a required field."),
                "Warning message for color is not displayed");

        softAssert.assertAll();
    }

}

