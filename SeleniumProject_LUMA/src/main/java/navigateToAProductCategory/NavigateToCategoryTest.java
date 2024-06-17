package navigateToAProductCategory;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class NavigateToCategoryTest {
WebDriver driver;
@Before
public void setUp() {
	driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("https://magento.softwaretestingboard.com/");
}
@Test
public void testNavigateToCategory() {
	driver.findElement(By.linkText("Men")).click();
	driver.findElement(By.linkText("Jackets")).click();
	String categoryTitle = driver.findElement(By.cssSelector(".page-title span")).getText();
	Assert.assertEquals("Jackets", categoryTitle);
}
@After
public void tearDown() {
	driver.quit();
}
}
