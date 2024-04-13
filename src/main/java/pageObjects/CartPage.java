package pageObjects;

import lombok.SneakyThrows;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.text.DecimalFormat;
import java.util.List;
import java.util.Locale;

public class CartPage extends BasePage {

    @FindBy(className = "item-info")
    private List<WebElement> productList;

    @FindBy(css = ".price .cart-price .price")
    private List<WebElement> PriceForOneProduct;

    @FindBy(css = "input-text qty")
    private List<WebElement> productQuantities;

    @FindBy(css = ".subtotal .cart-price .price")
    private List<WebElement> productSubtotals;

    //20poff - 20% discountcode
    @FindBy(css = "td[data-th='Discount'] .price")
    private List<WebElement> discount;

    @FindBy(css = ".totals-tax .price")
    private List<WebElement> tax;

    @FindBy(css = ".sub .price")
    private WebElement cartSubtotal;

    @FindBy(css = ".grand .price")
    private WebElement orderTotal;

    public CartPage() {
        super();
    }
    @SneakyThrows
    public static String extractMoneyValue(String text)  {
        return DecimalFormat.getCurrencyInstance(Locale.US).parse(text).toString();
    }

    public NavigationBar getNavigationBar() {
        return new NavigationBar();
    }

    public int getProductQuantity() {
        int initialQuantity = 0;
        for (WebElement productQuantity : productQuantities) {
            int quantity = Integer.parseInt(productQuantity.getAttribute("value"));
            initialQuantity += quantity;
        }

        return initialQuantity;
    }

    public boolean isProductSubtotalValid() {
        for (int i = 0; i < productList.size(); i++) {

            WebElement productPrice = PriceForOneProduct.get(i);
            double price = extractDouble(productPrice.getText());

            WebElement productQuantity = productQuantities.get(i);
            int quantity = Integer.parseInt(productQuantity.getAttribute("value"));

            WebElement productSubtotal = productSubtotals.get(i);
            double subtotal = extractDouble(productSubtotal.getText());

            if (price * quantity != subtotal) {
                return false;
            }
        }

        return true;
    }
    public boolean isCartSubtotalValid() {

        double expectedSubtotal = extractDouble(cartSubtotal.getText());
        double actualSubtotal = 0;

        for (WebElement productSubtotal : productSubtotals) {
            double subtotal = extractDouble(productSubtotal.getText());
            actualSubtotal += subtotal;
        }

        return actualSubtotal == expectedSubtotal;
    }

    public boolean isProductQuantityValid(int initialQuantity, int addedQuantity) {
        int finalQuantity = getProductQuantity();
        return initialQuantity + addedQuantity == finalQuantity;
    }

    public boolean isTotalValid() {
        double totalValue = extractDouble(orderTotal.getText());
        double subtotalValue = extractDouble(cartSubtotal.getText());
        double discountValue = 0;
        double taxValue = 0;

        if (!discount.isEmpty()) {
            discountValue = extractDouble(discount.get(0).getText());
        }

        if (!tax.isEmpty()) {
            taxValue = extractDouble(tax.get(0).getText());
        }

        return subtotalValue - discountValue + taxValue == totalValue;
    }

    public double extractDouble(String text) {
        return Double.parseDouble(extractMoneyValue(text));
    }
}
