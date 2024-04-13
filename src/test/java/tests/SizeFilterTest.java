package tests;

import com.pitechplus.qautils.annotations.TestInfo;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class SizeFilterTest extends BaseTest {
/*
    @Test
    @TestInfo(expectedResult = "Check if size filter is working on a product page.")
    public void verifySizeFilterOnProductPageTest() {

        //StorePage storePage  = landingPage.getNavigationBar().selectCategory(MEN_CATEGORY, TOPS_SUB_CATEGORY, TEES_SUB_CATEGORY);

        driver.get("https://magento.softwaretestingboard.com/men/tops-men/jackets-men.html");

        String sizeToFilter = "XL";

        WebElement sizeFilterElement = driver.findElement(By.xpath("//div[@class='filter-options-title'][text()='Size']"));
        sizeFilterElement.click();

        WebElement sizeOption = driver.findElement(By.xpath("//div[@class='filter-options-content']//a[contains(@class, 'swatch-option') and contains(@title, '" + sizeToFilter + "')]"));
        sizeOption.click();

        // Wait for products to be filtered
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Verify if products are filtered by selected size
        List<WebElement> products = driver.findElements(By.cssSelector(".product-item-info"));
        boolean allProductsHaveSelectedSize = true;

        for (WebElement product : products) {
            WebElement sizeElement = product.findElement(By.xpath(".//div[contains(@class,'swatch-option') and contains(@title,'" + sizeToFilter + "']"));
            if (sizeElement == null) {
                allProductsHaveSelectedSize = false;
                break;
            }
        }

        Assert.assertTrue(allProductsHaveSelectedSize, "Not all products have the selected size: " + sizeToFilter);
    }
*/

    @Test
    @TestInfo(expectedResult = "Check if size filter is working on a product page.")
    public void verifySizeFilterOnProductPageTest() {

        driver.get("https://magento.softwaretestingboard.com/men/tops-men/jackets-men.html");

        String sizeToFilter = "XL";

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement sizeFilterElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='filter-options-title'][text()='Size']")));
        sizeFilterElement.click();

        WebElement sizeOption = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@aria-label='XL']//div[contains(@class,'swatch-option text')][normalize-space()='XL']")));
        sizeOption.click();

        // Wait for products to be filtered
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Verify if products are filtered by selected size
        List<WebElement> products = driver.findElements(By.cssSelector(".product-item-info"));
        boolean allProductsHaveSelectedSize = true;

        for (WebElement product : products) {

            WebElement sizeElement = product.findElement(By.xpath("(//div[@id='option-label-size-143-item-170'])"));
            if (sizeElement == null) {
                allProductsHaveSelectedSize = false;
                break;
            }
        }

        Assert.assertTrue(allProductsHaveSelectedSize, "Not all products have the selected size: " + sizeToFilter);
    }
}


