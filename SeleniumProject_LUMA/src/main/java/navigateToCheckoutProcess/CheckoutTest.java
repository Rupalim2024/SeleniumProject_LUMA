package navigateToCheckoutProcess;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CheckoutTest {
	 private WebDriver driver;
	 
	 @Before
	 public void setUp() {
		// Initialize WebDriver
	        driver = new ChromeDriver();
	        
	        
	     // Navigate to the Magento website
	        driver.get("https://magento.softwaretestingboard.com/");
	        driver.manage().window().maximize();
	 }
	 @Test
	 public void testCheckoutProcess() {
		    
		 // Log in to the website
	        logIn();

	        // Add a product to the cart
	        addProductToCart();

	        // Proceed to checkout
	        proceedToCheckout();

	        
	 }
	 private void logIn() {
	        // Locate and click on the Sign In link
	        WebElement signInLink = driver.findElement(By.linkText("Sign In"));
	        signInLink.click();

	        
	        

	        // Enter login credentials
	        WebElement emailField = driver.findElement(By.id("email"));
	        WebElement passwordField = driver.findElement(By.id("pass"));
	        WebElement loginButton = driver.findElement(By.id("send2"));

	        emailField.sendKeys("rupalimishra25121991@gmail.com");
	        passwordField.sendKeys("India@123");
	        loginButton.click();

	      
	        
	    }

	    private void addProductToCart() {
	        // Locate and click on a product to add to cart
	        WebElement product = driver.findElement(By.cssSelector("li.product-item a.product-item-link"));
	        product.click();

	       
	       

	        // Click on Add to Cart button
	        WebElement addToCartButton = driver.findElement(By.id("product-addtocart-button"));
	        addToCartButton.click();

	        
	    }

	    private void proceedToCheckout() {
	        // Navigate to the shopping cart page
	        WebElement cartLink = driver.findElement(By.cssSelector("a.action.showcart"));
	        cartLink.click();

	       
	        WebElement proceedToCheckoutButton = driver.findElement(By.cssSelector("button.action.primary.checkout"));
	        proceedToCheckoutButton.click();
	    }

	     @After
	    public void tearDown() {
	        // Close the browser
	        if (driver != null) {
	            driver.quit();
	        }
	    }
}
