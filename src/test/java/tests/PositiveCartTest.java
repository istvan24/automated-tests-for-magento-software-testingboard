package tests;

import com.pitechplus.qautils.annotations.TestInfo;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageObjects.CartPage;
import pageObjects.StorePage;

import static helpers.Constants.*;

public class PositiveCartTest extends BaseTest {

    @BeforeClass
    public static void accessAccount() {

        landingPage = landingPage.clickSignIn().login(VALIDEMAIL, VALIDPASSWORD);
    }

    @Test
    @TestInfo(expectedResult = "Check if cart pricing:Product subtotal, Total is accurately calculated")
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
        } finally {
            driver.quit();
        }
    }

    @Test
    @TestInfo(expectedResult = "Check if given number of products are successfully added to cart")
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
        } finally {
            driver.quit();
        }
    }

    @AfterTest
    public void goBackToLanding() {
        landingPage.openLandingPage();
    }
}
