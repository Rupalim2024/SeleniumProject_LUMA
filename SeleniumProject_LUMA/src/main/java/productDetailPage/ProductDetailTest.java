package productDetailPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ProductDetailTest {
WebDriver driver;
@BeforeClass
public void setUp() {
	driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("https://magento.softwaretestingboard.com/");
}
@Test
public void testVerifyProductDetailPage() {
	driver.findElement(By.linkText("Men")).click();
    driver.findElement(By.linkText("Jackets")).click();
    driver.findElement(By.cssSelector(".product-item-info a")).click();
    
    String productName = driver.findElement(By.cssSelector("span[itemprop='name']")).getText();
    Assert.assertFalse(productName.isEmpty());
    
    String productPrice = driver.findElement(By.cssSelector(".price")).getText();
    Assert.assertFalse(productPrice.isEmpty());
    
    String productDescription = driver.findElement(By.cssSelector("#description")).getText();
    Assert.assertFalse(productDescription.isEmpty());
}
@AfterClass
public void tearDown() {
	driver.quit();
}
}
