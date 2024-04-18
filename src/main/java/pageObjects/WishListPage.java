package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WishListPage extends BasePage {

    @FindBy(className = "message-success")
    private WebElement productWishlistSuccesMsg;

    @FindBy(css = "button[title='Add All to Cart']")
    private WebElement addAllToCartButton;

    @FindBy(xpath = "//div[@class='message-success success message']")
    private static WebElement productFromWishlistToCartSuccessMessage;


    public WishListPage() {
        super();
    }

    public boolean isProductFromWishListToCartSuccessMsgDisplayed() {
        return productFromWishlistToCartSuccessMessage.isDisplayed();
    }

    public boolean isProductWishListMsgDisplayed() {
        return productWishlistSuccesMsg.isDisplayed();
    }

    public void clickAddAllToCartBtn() {
        addAllToCartButton.click();
    }


}
