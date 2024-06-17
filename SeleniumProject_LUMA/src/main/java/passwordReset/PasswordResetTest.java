package passwordReset;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class PasswordResetTest {
WebDriver driver;
@BeforeClass
public void setUp() {
	driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("https://magento.softwaretestingboard.com/customer/account/forgotpassword/");
}
@Test
public void testPasswordResetWithValidEmail() {
	driver.findElement(By.id("email_address")).sendKeys("rupalimishra25121991@gmail.com");
	driver.findElement(By.cssSelector(".action.submit")).click();
	String successMessage = driver.findElement(By.cssSelector(".message-success")).getText();
	Assert.assertTrue(successMessage.contains("If there is an account associated with rupalimishra25121991@gmail.com you will receive an email with a link to reset your password"));
	
}
@AfterClass
public void tearDown() {
driver.quit();
}
}