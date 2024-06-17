package verifyProductImageDisplay;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ProductImageTest {
WebDriver driver;
@BeforeClass
public void setUp() {
	driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("https://magento.softwaretestingboard.com/");
}
@Test
public void testProductImageDisplay() {
	WebElement product = driver.findElement(By.cssSelector("li.product-item"));
	WebElement productImage = product.findElement(By.cssSelector("img.product-image-photo"));
	assertTrue(productImage.isDisplayed(), "Product image is not displayed.");
	System.out.println("Product image is displayed successfully.");
	
}
@AfterClass
public void tearDown() {
	driver.quit();
}
}
