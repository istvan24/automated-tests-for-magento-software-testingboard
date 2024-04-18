package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.List;
import java.util.Random;

public class ProductPage extends BasePage{
    Random random;

    //select sizes on ProductPage: XS, S, M, L, XL
    @FindBy(css = ".swatch-option.text")
    private List<WebElement> productSizeOptions;

    //select the color of products
    @FindBy(css = ".swatch-option.color")
    private List<WebElement> productColorOptions;

    @FindBy(className = "towishlist")
    private WebElement toWishlistBtn;

    @FindBy(id = "product-addtocart-button")
    private static WebElement addToCartBtn;

    //category button for the selected product page
    @FindBy(xpath = "//li[contains(@class, 'item category')][last()]/a")
    private WebElement categoryBtn;

    //constructor for ProductPage + initializes a Random object for potential use within the ProductPage class.
    public ProductPage() {
        super();
        random = new Random();
    }

    //click on Wishlist button
    public WishListPage wishListProduct() {
        toWishlistBtn.click();
        return new WishListPage();
    }

    public WishListPage wishListProductWithRandomSizeAndColor() {
        chooseRandomSize();
        chooseRandomColor();
        toWishlistBtn.click();
        return new WishListPage();
    }

    public void addProductToCart() {
        chooseRandomSize();
        chooseRandomColor();
        addToCartBtn.click();
    }

    public void addProductToCartWithoutQty() {
        addToCartBtn.click();
    }


    public void chooseRandomSize() {
        WebElement randomSize = productSizeOptions.get(random.nextInt(productSizeOptions.size() - 1));
        randomSize.click();
    }

    public void chooseRandomColor() {
        WebElement randomColor = productColorOptions.get(random.nextInt(productColorOptions.size() - 1));
        randomColor.click();
    }

    public StorePage goBackToCategory() {
        categoryBtn.click();
        return new StorePage();
    }
}
