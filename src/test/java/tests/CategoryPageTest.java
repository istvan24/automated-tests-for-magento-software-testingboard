package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

import static helpers.Constants.*;

public class CategoryPageTest extends BaseTest {

    @BeforeTest
    public static void accesAccount() {
        landingPage = landingPage.clickSignIn().login(VALIDEMAIL, VALIDPASSWORD);
    }

    @Test
    //"Check if size filter is working on a product page."
    public void verifySizeFilterOnCategoryPageTest() {
        try {

            driver.get(MENJACKETS_URL);

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

            // Verify if the products are filtered by selected size - XL
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

        } catch (Throwable e) {
            takeScreenshot();
            throw e;
        }
    }

}


