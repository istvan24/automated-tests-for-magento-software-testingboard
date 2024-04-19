package tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.StorePage;

import static driver.WebDriverSingleton.closeBrowserAtEnd;
import static helpers.Constants.*;

public class ProductPageTest extends BaseTest {

    @Test
    //Check if both warning messages appears for on Product page if no size and no color is selected.
    public void verifyRequiredFieldMessageOnProductPageTest() {
        try {
            StorePage storePage = landingPage.getNavigationBar().selectCategory(NEW_CATEGORY);
            storePage.addProductsToCartWithoutQty();

            Assert.assertTrue(storePage.warningMessageForSizeMsgDisplayed(), "Warning message for size is not displayed");
            Assert.assertTrue(storePage.warningMessageForColorMsgDisplayed(), "This is a required field.");
            softAssert.assertAll();

        } catch (Throwable e) {
            takeScreenshot();
            throw e;
        }
    }
}

