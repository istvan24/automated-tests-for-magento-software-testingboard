package tests;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.StorePage;
import pageObjects.WishListPage;

import static driver.WebDriverSingleton.closeBrowserAtEnd;
import static helpers.Constants.*;
import static helpers.Constants.RANDOM;

public class AddProductToCartTest extends BaseTest {

    @BeforeTest
    public static void accesAccount() {
        landingPage = landingPage.clickSignIn().login(VALIDEMAIL, VALIDPASSWORD);
    }

    @Test
    //Check if a product from wishlist page is added to cart via add all to cart button.
    public void addProductToCartTest() {
        try {
            StorePage storePage = landingPage.getNavigationBar().selectCategory(NEW_CATEGORY);
            WishListPage wishlistPage = storePage.goToProductPage(RANDOM).wishListProductWithRandomSizeAndColor();
            wishlistPage.clickAddAllToCartBtn();

            Assert.assertTrue(wishlistPage.isProductFromWishListToCartSuccessMsgDisplayed(), "Add All to Cart operation failed.");

        } catch (Throwable e) {
            takeScreenshot();
            throw e;
        } finally {
            driver.quit();
        }
    }

    @AfterTest
    public void cleanUpAfterTest() {
        closeBrowserAtEnd();
    }
}
