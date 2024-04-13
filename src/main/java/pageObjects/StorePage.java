package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.Random;

import static helpers.Constants.RANDOM;

public class StorePage extends BasePage{

    @FindBy(className = "product-item-link")
    private List<WebElement> products;

    public StorePage() {
        super();
    }

    //go to a random product page
    public ProductPage goToProductPage(String productName) {
        if (productName.equals(RANDOM)) {
            return selectRandomProduct();
        }
        return selectProduct(productName);
    }

    public NavigationBar getNavigationBar() {
        return new NavigationBar();
    }

    //select a Random product from product page
    public ProductPage selectRandomProduct() {
        Random random = new Random();
        WebElement randomProduct = products.get(random.nextInt(products.size() - 1));
        randomProduct.click();
        return new ProductPage();
    }

    public ProductPage selectProduct(String productName) {
        WebElement selectedProduct = products.stream().filter(p -> productName.equals(p.getText())).findFirst()
                .orElseThrow(RuntimeException::new);
        selectedProduct.click();
        return new ProductPage();
    }

    //add the selected product to the cart
    public void addProductsToCart(int quantity) {
        for (int i = 1; i < quantity; i++) {
            ProductPage productPage = selectRandomProduct();
            productPage.addProductToCart();
            productPage.goBackToCategory();
        }
    }

    public void addProductsToCartWithoutQty() {
        ProductPage productPage = selectRandomProduct();
        productPage.addProductToCartWithoutQty();
    }
}
