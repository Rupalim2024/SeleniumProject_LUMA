package gridAndListView;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ViewTest {
WebDriver driver;
@Before
public void setUp() {
	driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("https://magento.softwaretestingboard.com/");
}

@Test
public void testGridViewAndListView() {
    // Navigate to a product category page
    navigateToCategoryPage();

    // Switch to list view and verify
    switchToListView();
    

    // Switch to grid view and verify
    switchToGridView();
    
}
private void navigateToCategoryPage() {
    // Click on the 'Women' category
    WebElement womenCategory = driver.findElement(By.linkText("Women"));
    womenCategory.click();
    WebElement topsCategory = driver.findElement(By.linkText("Tops"));
    topsCategory.click();
}
private void switchToListView() {
    // Locate and click on the list view icon
    WebElement listViewIcon = driver.findElement(By.id("mode-list"));
    listViewIcon.click();
}

    
private void switchToGridView() {
    // Locate and click on the grid view icon
    WebElement gridViewIcon = driver.findElement(By.id("mode-grid"));
    gridViewIcon.click();
}
@After
public void tearDown() {
	driver.quit();
}
}