package verifyHomePage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HomePageTest {
	WebDriver driver;
	@BeforeMethod
	public void setUp() {
		driver=new ChromeDriver();
		driver.get("https://magento.softwaretestingboard.com/");
		driver.manage().window().maximize();;
	}

	@Test
	public void verifyHomePageTitle() {
		String expectedTitle = "Home Page";
		String actualTitle = driver.getTitle();
		Assert.assertEquals(actualTitle, expectedTitle, "Home page title match the expected title");
	}
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
}
