package verifyAddToWishList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AddToWishListTest {
WebDriver driver;
@Before
public void setUp() {
	driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("https://magento.softwaretestingboard.com/");
}
@Test
public void testAddToWishlist() {
    // Log in to the website
    logIn();

    // Add a product to the wishlist
    addProductToWishlist();

    
}
private void logIn() {
    // Locate and click on the Sign In link
    WebElement signInLink = driver.findElement(By.linkText("Sign In"));
    signInLink.click();
    WebElement emailField = driver.findElement(By.id("email"));
    WebElement passwordField = driver.findElement(By.id("pass"));
    WebElement loginButton = driver.findElement(By.id("send2"));

    emailField.sendKeys("rupalimishra25121991@gmail.com");
    passwordField.sendKeys("India@123");
    loginButton.click();
}
private void addProductToWishlist() {
    // Locate and click on a product to add to wishlist
    WebElement product = driver.findElement(By.cssSelector("li.product-item a.product-item-link"));
    product.click();
    WebElement addToWishlistButton = driver.findElement(By.cssSelector(".action.towishlist"));
    addToWishlistButton.click();
}

@After
public void tearDown() {
    // Close the browser
    if (driver != null) {
        driver.quit();
    }
}   
    
}

	


