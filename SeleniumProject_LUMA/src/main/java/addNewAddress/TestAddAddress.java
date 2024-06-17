package addNewAddress;



import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.cucumber.java.After;

public class TestAddAddress {
WebDriver driver;
	
	@Before
	public void startUp() {
		
		 driver = new ChromeDriver();
		 driver.manage().window().maximize();
		driver.get("https://magento.softwaretestingboard.com/");
		login();
		}
	@Test
    public void testAddAddress() throws Exception {
        // Navigate to the address book
        navigateToAddressBook();

        // Add a new address
        addNewAddress();

        
    }
	
	private void login() {
        // Click on the Sign In link
        WebElement signInLink = driver.findElement(By.linkText("Sign In"));
        signInLink.click();
        WebElement emailField = driver.findElement(By.id("email"));
        WebElement passwordField = driver.findElement(By.id("pass"));
        WebElement signInButton = driver.findElement(By.id("send2"));

        emailField.sendKeys("rupalimishra25121991@gmail.com");
        passwordField.sendKeys("India@123");
        signInButton.click();
	}
	 private void navigateToAddressBook() {
	        // Click on the account dropdown and select My Account
	        WebElement accountDropdown = driver.findElement(By.cssSelector(".customer-name"));
	        accountDropdown.click();

	        WebElement myAccountLink = driver.findElement(By.linkText("My Account"));
	        myAccountLink.click();
	        WebElement addressBookLink = driver.findElement(By.linkText("Address Book"));
	        addressBookLink.click();
	 }
	 private void addNewAddress() throws InterruptedException {
	        
	        driver.findElement(By.id("telephone")).sendKeys("9786543098");
	        driver.findElement(By.id("street_1")).sendKeys("123 Main St");
	        driver.findElement(By.id("city")).sendKeys("Bangalore");
	       
	        WebElement countryDropdown = driver.findElement(By.id("country"));
	        Thread.sleep(2000);
			
			Select select = new Select(countryDropdown);
			select.selectByVisibleText("India");
	        
	        WebElement stateDropdown = driver.findElement(By.id("region_id"));
	        
	        Select select1 = new Select(stateDropdown);
	        select1.selectByVisibleText("Karnataka");
	        
	        driver.findElement(By.id("zip")).sendKeys("561100");

	       // Save the address
	        WebElement saveAddressButton = driver.findElement(By.cssSelector("button.action.save.primary"));
	        saveAddressButton.click();
	 }
	 @After
	 public void tearDown() {
		 driver.quit();
	 }
	
}
