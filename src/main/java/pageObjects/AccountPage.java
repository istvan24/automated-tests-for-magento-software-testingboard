package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountPage extends BasePage{

    @FindBy(className = "success")
    private WebElement registrationMsg;

    @FindBy(css = ".nav li:nth-of-type(6) a")
    private WebElement addressBookButton;

    @FindBy(css = ".nav li:nth-of-type(4) a")
    private WebElement wishListButton;

    public AccountPage() {
        super();
    }

    @Override
    public void waitForPageToLoad() {
    }

    public AddressPage clickAddressBookButton() {
        addressBookButton.click();
        return new AddressPage();
    }

    public WishListPage clickMyWishListButton() {
        wishListButton.click();
        return new WishListPage();
    }

    public boolean isRegistrationMsgDisplayed() {
        return registrationMsg.isDisplayed();
    }
}
