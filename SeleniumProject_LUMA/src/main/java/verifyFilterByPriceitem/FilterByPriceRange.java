package verifyFilterByPriceitem;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class FilterByPriceRange {
	WebDriver driver;
	@BeforeClass
	public void SetUp() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://magento.softwaretestingboard.com/");
	}
	@Test
	public void testFilterByPriceRange() {
		try {
			driver.findElement(By.linkText("Men")).click();
            driver.findElement(By.linkText("Jackets")).click();
            
            
            WebElement priceRangeFilter = driver.findElement(By.xpath("//a[@href='https://magento.softwaretestingboard.com/men/tops-men/jackets-men.html?price=50-60']"));
            priceRangeFilter.click();
            Thread.sleep(2000);
            List<WebElement> productPrices = driver.findElements(By.cssSelector(".price"));
            for (WebElement priceElement : productPrices) {
                String priceText = priceElement.getText().replace("$", "").replace(",", "");
                double price = Double.parseDouble(priceText);
                Assert.assertTrue(price >= 50.00 && price < 59.99, "Product price is out of the selected range: $" + price);
            }
        } catch (Exception e) {
            e.printStackTrace();
            
            
        }
    
		}
	}

