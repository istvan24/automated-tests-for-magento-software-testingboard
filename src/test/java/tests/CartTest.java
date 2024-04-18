package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.CartPage;
import pageObjects.StorePage;
import pageObjects.WishListPage;
import static helpers.Constants.RANDOM;

import static helpers.Constants.*;

public class CartTest extends BaseTest {

    @Test
    //Check if a product from wishlist page is added to cart via add all to cart button.
    public void addProductFromWishListToCartTest() {
        try {
            StorePage storePage = landingPage.getNavigationBar().selectCategory(NEW_CATEGORY);
            WishListPage wishlistPage = storePage.goToProductPage(RANDOM).wishListProductWithRandomSizeAndColor();
            wishlistPage.clickAddAllToCartBtn();

            Assert.assertTrue(wishlistPage.isProductFromWishListToCartSuccessMsgDisplayed(), "Add All to Cart operation failed.");

        } catch (Throwable e) {
            takeScreenshot();
            throw e;
        }
    }

    @Test
    //"Check if cart pricing:Product subtotal, Total is accurately calculated"
    public void cartPricingTest() {
        try {
            int productQuantity = 3;
            StorePage storePage = landingPage.getNavigationBar()
                    .selectCategory(MEN_CATEGORY, BOTTOMS_SUB_CATEGORY, SHORTS_SUB_CATEGORY);
            storePage.addProductsToCart(productQuantity);
            CartPage cartPage = storePage.getNavigationBar().goToCart();

            //pica aici cu IndexOutOfBoundsExceptio
            softAssert.assertTrue(cartPage.isProductSubtotalValid());
            softAssert.assertTrue(cartPage.isCartSubtotalValid());
            softAssert.assertTrue(cartPage.isTotalValid());

            softAssert.assertAll();
        } catch (Throwable e) {
            takeScreenshot();
            throw e;
        }
    }

    @Test
    //"Check if given number of products are successfully added to cart"
    public void productAddedSuccesfullyToCartTest() {
        try {
            int addedQuantity = 3;
            CartPage cartPage = landingPage.getNavigationBar().goToCart();
            int initialQuantity = cartPage.getProductQuantity();
            StorePage storePage = cartPage.getNavigationBar().selectCategory(NEW_CATEGORY);
            storePage.addProductsToCart(addedQuantity);
            cartPage = storePage.getNavigationBar().goToCart();
            softAssert.assertTrue(cartPage.isProductQuantityValid(initialQuantity, addedQuantity));
        } catch (Throwable e) {
            takeScreenshot();
            throw e;

        }
    }
}
