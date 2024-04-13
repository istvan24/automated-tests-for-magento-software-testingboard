package tests;

import com.pitechplus.qautils.annotations.TestInfo;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.AccountPage;
import pageObjects.StorePage;
import pageObjects.WishListPage;

import static helpers.Constants.*;

public class WishlistTest extends BaseTest {

    @BeforeTest
    public static void accesAccount() {
        landingPage = landingPage.clickSignIn().login(VALIDEMAIL, VALIDPASSWORD);
    }

    @Test
    @TestInfo(expectedResult = "Random product is succesfully added to the wishlist.")
    public void addRandomProductToWishlistTest() {
        try {
            StorePage storePage = landingPage.getNavigationBar().selectCategory(NEW_CATEGORY);
            WishListPage wishlistPage = storePage.goToProductPage(RANDOM).wishListProduct();
            Assert.assertTrue(wishlistPage.isProductWishListMsgDisplayed());
        } catch (Throwable e) {
            takeScreenshot();
            throw e;
        } finally {
            driver.quit();
        }
    }

    @Test
    @TestInfo(expectedResult = "Check if a product from landing page is successfully added to wishlist.")
    public void addProductToWishlistTest() {
        try {
            StorePage storePage = landingPage.getNavigationBar().selectCategory(MEN_CATEGORY, TOPS_SUB_CATEGORY, TEES_SUB_CATEGORY);
            WishListPage wishlistPage = storePage.goToProductPage(MEN_TEE).wishListProduct();
            Assert.assertTrue(wishlistPage.isProductWishListMsgDisplayed());
        } catch (Throwable e) {
            takeScreenshot();
            throw e;
        } finally {
            driver.quit();
        }
    }

    /* ------ need to implement the hover on wishlist also!
    @Test(groups = "remove.product.from.wishlist")
    @TestInfo(expectedResult = "Check if a product previously added to wishlist can be removed from it.")
    public void removeProductFromWishListTest() {
        AccountPage accountPage = landingPage.clickMyAccountButton();
        WishListPage wishListPage = accountPage.clickMyWishListButton();
        //hover here!!!

    }*/
    @Test
    @TestInfo(expectedResult = "Check if a product is added to cart via add all to cart button from wishlist page.")
    public void addProductToCartFromWishListTest() {
        try {
            AccountPage accountPage = landingPage.clickMyAccountButton();
            WishListPage wishListPage = accountPage.clickMyWishListButton();
            //TBD

        } catch (Throwable e) {
            takeScreenshot();
            throw e;
        } finally {
            driver.quit();
        }
    }
}

/*
    @AfterClass
    public void goBackToLanding() {
        landingPage.openLandingPage();
    }
*/
