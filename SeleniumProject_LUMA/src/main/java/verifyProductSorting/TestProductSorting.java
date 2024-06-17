package verifyProductSorting;

import java.util.List;
import java.util.stream.Collectors;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class TestProductSorting {
WebDriver driver;
@Before
public void setUp() {
	driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("https://magento.softwaretestingboard.com/");
}
@Test
public void testProductSortingByPriceLowToHigh() {
	try {
		driver.findElement(By.linkText("Men")).click();
        driver.findElement(By.linkText("Jackets")).click();
        
        Select sortBy = new Select(driver.findElement(By.id("sorter")));
        sortBy.selectByVisibleText("Price");
        Thread.sleep(2000);
        List<WebElement> productPrices = driver.findElements(By.cssSelector(".price"));
        List<Double> prices = productPrices.stream()
                .map(priceElement -> Double.parseDouble(priceElement.getText().replace("$", "")))
                .collect(Collectors.toList());
        
        for (int i = 0; i < prices.size() - 1; i++) {
            Assert.assertTrue("Prices are not sorted in ascending order", prices.get(i) <= prices.get(i + 1));
        }
	}catch (Exception e) {
        e.printStackTrace();
	}
}
@After
public void tearDown() {
	driver.quit();
}
}
