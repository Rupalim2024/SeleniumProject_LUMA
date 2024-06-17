package verifyLogin;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class LoginWithValidCredential {
	WebDriver driver;
	@Before
	public void setUp() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://magento.softwaretestingboard.com/");
		}
@Test
public void verifyLoginWithValidCredentials() {
	driver.findElement(By.linkText("Sign In")).click();
	driver.findElement(By.id("email")).sendKeys("rupalimishra25121991@gmail.com");
	driver.findElement(By.id("pass")).sendKeys("India@123");
	driver.findElement(By.name("send")).click();
	

}
@After
public void tearDown() {
	driver.quit();
}
}
