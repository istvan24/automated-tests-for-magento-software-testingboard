package tests;

import helpers.Address;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObjects.AccountPage;
import pageObjects.AddressPage;

import static driver.WebDriverSingleton.closeBrowserAtEnd;
import static helpers.Constants.*;

public class MyAccountTest extends BaseTest {

    @BeforeMethod
    public static void accessAccount() {
        landingPage = landingPage.clickSignIn().login(VALIDEMAIL, VALIDPASSWORD);
    }
    @Test
    //"Check if new address is successfully added"
    public void addNewAddressTest() {
        try {
            AccountPage accountPage = landingPage.clickMyAccountButton();
            AddressPage addressPage = accountPage.clickAddressBookButton();
            addressPage.addNewAddress(new Address().createFakeAddress());
            Assert.assertTrue(addressPage.isAddressSavedMsgDisplayed());
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
