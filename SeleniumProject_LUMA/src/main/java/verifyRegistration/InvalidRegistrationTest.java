package verifyRegistration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class InvalidRegistrationTest {
	WebDriver driver;
	@BeforeClass
	public void setUp() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://magento.softwaretestingboard.com/");
	}
	@Test
	public void testUserRegistrationWithInvalidData() {
		driver.findElement(By.linkText("Create an Account")).click();
		driver.findElement(By.id("firstname")).sendKeys("");
		driver.findElement(By.id("lastname")).sendKeys("");
		driver.findElement(By.id("email_address")).sendKeys("invalid-email");
		driver.findElement(By.id("password")).sendKeys("123");
		driver.findElement(By.id("password-confirmation")).sendKeys("123");
		driver.findElement(By.cssSelector("button.action.submit.primary")).click();
		
		String firstNameError = driver.findElement(By.id("firstname-error")).getText();
		String lastNameError = driver.findElement(By.id("lastname-error")).getText();
		String emailError = driver.findElement(By.id("email_address-error")).getText();
		String passwordError = driver.findElement(By.id("password-error")).getText();
		
		Assert.assertTrue(firstNameError.contains("This is a required field."));
		Assert.assertTrue(lastNameError.contains("This is a required field."));
		Assert.assertTrue(emailError.contains("Please enter a valid email address (Ex: johndoe@domain.com)."));
		Assert.assertTrue(passwordError.contains("Minimum length of this field must be equal or greater than 8 symbols. Leading and trailing spaces will be ignored"));
		
	}
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}
