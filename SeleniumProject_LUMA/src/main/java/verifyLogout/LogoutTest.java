package verifyLogout;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LogoutTest {
WebDriver driver;
@Before
public void setUp() {
	driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("https://magento.softwaretestingboard.com/");
}
@Test
public void testLogout() {
	try {
		driver.findElement(By.linkText("Sign In")).click();
        WebElement emailField = driver.findElement(By.id("email"));
        WebElement passwordField = driver.findElement(By.id("pass"));
        WebElement signInButton = driver.findElement(By.id("send2"));
        
        emailField.sendKeys("rupalimishra25121991@gmail.com");
        passwordField.sendKeys("India@123");
        signInButton.click();
        Thread.sleep(3000);
        WebElement accountMenu = driver.findElement(By.cssSelector("button[data-action='customer-menu-toggle']"));
        accountMenu.click();
        WebElement signOutLink = driver.findElement(By.linkText("Sign Out"));
        signOutLink.click();
        Thread.sleep(3000);
        WebElement signInLink = driver.findElement(By.linkText("Sign In"));
        Assert.assertTrue(signInLink.isDisplayed());
	}catch (NoSuchElementException e) {
        Assert.fail("Element not found: " + e.getMessage());
    } catch (InterruptedException e) {
        e.printStackTrace();
}
}
@After
public void tearDown() {
	driver.quit();
}
}
