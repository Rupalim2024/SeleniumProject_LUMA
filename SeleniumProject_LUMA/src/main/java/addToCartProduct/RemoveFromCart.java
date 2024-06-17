package addToCartProduct;


import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class RemoveFromCart {
WebDriver driver;
@BeforeClass
public void setUp() {
	driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	driver.get("https://magento.softwaretestingboard.com/");
}
@Test(priority = 1)
public void verifyAddToCart() {
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
@Test(priority=2)
public void verifyRemoveFromCart() throws Exception {
	WebElement cartLink = driver.findElement(By.xpath("//a[@class='action showcart']"));
    cartLink.click();
    Thread.sleep(2000);    
    
    WebElement removeLink = driver.findElement(By.xpath("//a[@class='action delete']"));
    removeLink.click();
}
@AfterClass
public void tearDown() {
	driver.quit();
}
}
