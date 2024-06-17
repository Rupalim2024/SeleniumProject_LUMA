package verifyProductPriceDisplay;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ProductPriceTest {
WebDriver driver;
@Before
public void setUp() {
	driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("https://magento.softwaretestingboard.com/");
}
@Test
public void testProductPriceDisplay() {
	WebElement product = driver.findElement(By.cssSelector("li.product-item"));
	WebElement productPrice = product.findElement(By.cssSelector(".price"));
	assertTrue("Product price is not displayed.", productPrice.isDisplayed());
	System.out.println("Product price is displayed successfully: " + productPrice.getText());
}
@After
public void tearDown() {
	driver.quit();
}
}
