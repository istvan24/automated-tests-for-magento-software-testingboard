package tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObjects.StorePage;
import pageObjects.WishListPage;

import static helpers.Constants.*;

public class WishlistTest extends BaseTest {

    @BeforeMethod
    public static void accessAccount() {
        landingPage = landingPage.clickSignIn().login(VALID_EMAIL, VALID_PASSWORD);
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

    @AfterMethod
    public void logout() {
        landingPage.clickLogout();
    }

}



