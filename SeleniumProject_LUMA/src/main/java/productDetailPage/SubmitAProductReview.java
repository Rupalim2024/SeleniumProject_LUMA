package productDetailPage;

import static org.testng.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SubmitAProductReview {
WebDriver driver;
@Before
public void setUp() {
	driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("https://magento.softwaretestingboard.com/");
}
@Test
public void testSubmitReview() {
	WebElement product = driver.findElement(By.cssSelector("li.product-item a.product-item-link"));
    product.click();
    
    WebElement reviewTab = driver.findElement(By.id("tab-label-reviews-title"));
    reviewTab.click();
    
    WebElement rating = driver.findElement(By.id("Rating_3_label"));
    rating.click();
    assertTrue(rating.isSelected());
    
    WebElement nickname = driver.findElement(By.id("nickname_field"));
    WebElement summary = driver.findElement(By.id("summary_field"));
    WebElement review = driver.findElement(By.id("review_field"));

    nickname.sendKeys("Rupali");
    summary.sendKeys("Great product");
    review.sendKeys("This is a detailed review of the product. It works wonderfully!");
    
    WebElement submitReviewButton = driver.findElement(By.cssSelector("button.review-actions-submit"));
    submitReviewButton.click();
    
    WebElement successMessage = driver.findElement(By.cssSelector(".message-success.success.message"));
    String expectedMessage = "You submitted your review for moderation.";
    String actualMessage = successMessage.getText();
    assertTrue(actualMessage.contains(expectedMessage));
}
}
