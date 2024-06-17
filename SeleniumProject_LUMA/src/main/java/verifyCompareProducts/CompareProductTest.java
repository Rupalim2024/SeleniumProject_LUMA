package verifyCompareProducts;

import java.util.List;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CompareProductTest {
WebDriver driver;
@BeforeClass
public void setUp() {
	driver = new ChromeDriver();
	driver.manage().window().maximize();
	 driver.get("https://magento.softwaretestingboard.com/");
}
@Test
public void testCompareProducts() {
	// Add products to the compare list
    addProductsToCompare();
 
 
}
private void addProductsToCompare() {
	WebElement firstProduct = driver.findElement(By.cssSelector("li.product-item a.product-item-link"));
    firstProduct.click();
    WebElement addToCompareButton = driver.findElement(By.cssSelector(".action.tocompare"));
    addToCompareButton.click();
    driver.navigate().back();
    List<WebElement> products = driver.findElements(By.cssSelector("li.product-item a.product-item-link"));
    products.get(1).click();  // Clicking on the second product
    addToCompareButton = driver.findElement(By.cssSelector(".action.tocompare"));
    addToCompareButton.click();
    
}


@AfterClass
public void tearDown() {
    // Close the browser
    if (driver != null) {
        driver.quit();
    }
}

}
