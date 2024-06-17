package searchForAProduct;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SearchProductInvalidKeyword {
WebDriver driver;
@BeforeClass
public void SetUp() {
	driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("https://magento.softwaretestingboard.com/");
}
@Test
public void testSearchProductWithInvalidKeyword() {
	driver.findElement(By.id("search")).sendKeys("invalidKeyword123");
	driver.findElement(By.cssSelector(".action.search")).click();
	String noResultMessage = driver.findElement(By.cssSelector(".message.notice")).getText();
	Assert.assertTrue(noResultMessage.contains("Your search returned no results."));
}
@AfterClass
public void tearDown() {
	driver.quit();
}
}