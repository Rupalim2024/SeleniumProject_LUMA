package searchForAProduct;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SearchProductTest {
WebDriver driver;
@Before
public void setUp() {
	driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("https://magento.softwaretestingboard.com/");
}
@Test
public void testSearchProductWithValidKeyword() {
	driver.findElement(By.id("search")).sendKeys("Jackets");
	driver.findElement(By.cssSelector(".action.search")).click();
	String searchResultTitle = driver.getTitle();
	Assert.assertTrue(searchResultTitle.contains("Jackets"));
}
@After
public void tearDown() {
	driver.quit();
}
}
