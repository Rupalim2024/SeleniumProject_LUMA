package addToCartProduct;

import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestAddCart {
	WebDriver driver;
	@Before
	public void setUp() {
		driver = new ChromeDriver();
	    driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}
	@Test
	public void verifyAddToCart() {
		driver.get("https://magento.softwaretestingboard.com/");
		WebElement menCategory = driver.findElement(By.linkText("Men"));
	    menCategory.click();
	    
	    WebElement topsSubCategory = driver.findElement(By.linkText("Tops"));
	    topsSubCategory.click();
	    
	    WebElement firstProduct = driver.findElement(By.cssSelector(".products-grid .product-item:first-child .product-item-link"));
	    firstProduct.click();
	    
	    WebElement sizeOption = driver.findElement(By.cssSelector("#option-label-size-143-item-168"));
	    sizeOption.click();
	    
	    WebElement colorOption = driver.findElement(By.cssSelector("#option-label-color-93-item-50"));
	    colorOption.click();
	    
	    WebElement cartMessage = driver.findElement(By.id("product-addtocart-button"));
	    cartMessage.click();
	    
	    WebElement successMessage = driver.findElement(By.cssSelector(".message-success.success.message"));
        String expectedMessage = "You added Cassius Sparring Tank to your shopping cart.";
        String actualMessage = successMessage.getText();
        assertEquals(expectedMessage, actualMessage);
	}
	@After
	public void tearDown() {
		driver.quit();
	}
}
