package verifyLogin;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginWithInvalidCredential {
WebDriver driver;
@Before
public void setUp() {
	driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("https://magento.softwaretestingboard.com/");
	}
@Test
public void testInvalidLogin() {
	driver.findElement(By.linkText("Sign In")).click();
	driver.findElement(By.id("email")).sendKeys("invalidUser@test.com");
	driver.findElement(By.id("pass")).sendKeys("invalidPassword");
	driver.findElement(By.name("send")).click();
	String errorMessage = driver.findElement(By.cssSelector(".message-error")).getText();
	Assert.assertTrue(errorMessage.contains("The account sign-in was incorrect or your account is disabled temporarily. Please wait and try again later."));
}
@After
public void tearDown() {
	driver.quit();
}
}
