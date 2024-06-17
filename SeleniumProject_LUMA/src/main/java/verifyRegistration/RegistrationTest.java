package verifyRegistration;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class RegistrationTest {
	WebDriver driver;
	@Before
		public void setUp() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		}
	@Test
	public void verifyRegistrationWithValidData() throws Exception {
		driver.get("https://magento.softwaretestingboard.com/");
		Thread.sleep(2000);
		driver.findElement(By.linkText("Create an Account")).click();
		
		driver.findElement(By.id("firstname")).sendKeys("John");
		driver.findElement(By.id("lastname")).sendKeys("user");
		driver.findElement(By.id("email_address")).sendKeys("john.user"+ System.currentTimeMillis()+"@test.com");
		driver.findElement(By.id("password")).sendKeys("Password123");
		driver.findElement(By.id("password-confirmation")).sendKeys("Password123");
		
		driver.findElement(By.cssSelector(".action.submit")).click();
		
		WebElement successMessage = driver.findElement(By.cssSelector(".message-success"));
		Assert.assertTrue(successMessage.getText().contains("Thank you for registering with Main Website Store."));
	}
	@After
	public void tearDown() {
		if(driver != null) {
			driver.quit();
		}
	}
}
