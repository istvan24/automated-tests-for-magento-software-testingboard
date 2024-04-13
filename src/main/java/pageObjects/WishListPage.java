package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WishListPage extends BasePage {

    @FindBy(className = "message-success")
    private WebElement productWishlistSuccesMsg;

    //xpath -> //button[@title='Add All to Cart']
    @FindBy(css = "button[title='Add All to Cart']")
    private WebElement addAllToCart;

    public WishListPage() {
        super();
    }

    @Override
    public void waitForPageToLoad() {

    }

    public boolean isProductWishListMsgDisplayed() {
        return productWishlistSuccesMsg.isDisplayed();
    }
}
