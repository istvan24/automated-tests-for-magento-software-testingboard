package tests;

import helpers.Address;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.AccountPage;
import pageObjects.AddressPage;

public class MyAccountTest extends BaseTest {

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
}
