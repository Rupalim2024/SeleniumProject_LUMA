package verifyProductSorting;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SortByPosition {
WebDriver driver;
@BeforeMethod
public void setUp() throws Exception {
	driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("https://magento.softwaretestingboard.com/");
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	Thread.sleep(3000);
}
@Test
public void Validate_the_Products_list_is_sort_By_Position() throws InterruptedException {
	driver.findElement(By.xpath("(//span[@class='ui-menu-icon ui-icon ui-icon-carat-1-e'])[1]")).click();
	driver.findElement(By.linkText("Jackets")).click();
	Select sel = new Select(driver.findElement(By.id("sorter")));
	sel.selectByValue("position");
	Thread.sleep(3000);
}
@AfterMethod
public void tearDown() {
	driver.quit();
}
 }
