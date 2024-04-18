package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountPage extends BasePage {

    @FindBy(className = "success")
    private WebElement registrationMsg;

    @FindBy(css = ".nav li:nth-of-type(6) a")
    private WebElement addressBookButton;

    @FindBy(css = ".nav li:nth-of-type(4) a")
    private WebElement wishListButton;

    @FindBy(xpath = "//button[@title='Add All to Cart']")
    private WebElement AddAllToCartButton;

    public AccountPage clickAddAllToCartButton() {
        AddAllToCartButton.click();
        return new AccountPage();
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
