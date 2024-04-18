package tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.StorePage;
import pageObjects.WishListPage;

import static driver.WebDriverSingleton.closeBrowserAtEnd;
import static helpers.Constants.*;

public class WishlistTest extends BaseTest {

    @BeforeTest
    public static void accesAccount() {
        landingPage = landingPage.clickSignIn().login(VALIDEMAIL, VALIDPASSWORD);
    }

    @Test
    //Random product is succesfully added to the wishlist.
    public void addRandomProductToWishlistTest() {
        try {
            StorePage storePage = landingPage.getNavigationBar().selectCategory(NEW_CATEGORY);
            WishListPage wishlistPage = storePage.goToProductPage(RANDOM).wishListProduct();

            Assert.assertTrue(wishlistPage.isProductWishListMsgDisplayed(),
                    "The succes message for adding the product to wishlist is not displayed.");
        } catch (Throwable e) {
            takeScreenshot();
            throw e;
        }
    }

}



