package addNewAddress;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class EditAddress {
WebDriver driver;
@Before
public void setUp() {
	driver = new ChromeDriver();
	driver.get("https://magento.softwaretestingboard.com/");
    driver.manage().window().maximize();
    login();
}
private void login() {
    // Click on Sign In link
    driver.findElement(By.linkText("Sign In")).click();
 // Enter email
    driver.findElement(By.id("email")).sendKeys("rupalimishra25121991@gmail.com");
 // Enter password
    driver.findElement(By.id("pass")).sendKeys("India@123");

    // Click on Sign In button
    driver.findElement(By.id("send2")).click();
}
@Test
public void testAddEditDeleteAddress() {
	

    // Edit the address
    editAddress();

    
}
private void editAddress() {
	// Click on the account dropdown and select My Account
    WebElement accountDropdown = driver.findElement(By.cssSelector(".customer-name"));
    accountDropdown.click();

    WebElement myAccountLink = driver.findElement(By.linkText("My Account"));
    myAccountLink.click();
    WebElement addressBookLink = driver.findElement(By.linkText("Address Book"));
    addressBookLink.click();
	
 // Click on Edit link for the first address
    driver.findElement(By.linkText("Change Billing Address")).click();
 // Edit the address details
    WebElement streetField = driver.findElement(By.id("street_1"));
    streetField.clear();
    streetField.sendKeys("456 Street");
 // Click on Save Address button
    driver.findElement(By.cssSelector("button[title='Save Address']")).click();
}
@After
public void tearDown() {
	driver.quit();
}
}
