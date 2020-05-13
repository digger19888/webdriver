import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.List;

public class BillCloudTest {
    @Test
    public void compareResults() {
        WebDriver driver = new ChromeDriver();
        driver.get(" https://cloud.google.com/");

        List<WebElement> allproductBtn = driver.findElements(By.xpath("//*[@class='devsite-footer-linkbox-link gc-analytics-event']"));
        allproductBtn.get(10).click();

        List<WebElement> priceBtn = driver.findElements(By.xpath("//*[@class='cloud-button cloud-button--secondary']"));
        priceBtn.get(0).click();

//        WebElement calcBtn = driver.findElement(By.cssSelector("//*[@track-name='pricingNav/calculators']"));
//        calcBtn.click();

        List<WebElement> pricingBtn = driver.findElements(By.xpath("//*[@class='gc-analytics-event ']"));
        pricingBtn.get(3).click();

        List<WebElement> calcBtn = driver.findElements(By.xpath("//*[@class='devsite-nav-item-title']"));
        calcBtn.get(261).click();

//        List<WebElement> computeBtn = driver.findElements(By.xpath("//*[@class='name ng-binding']"));
//        computeBtn.get(0).click();

//        new WebDriverWait(driver, 50)
//                .until(ExpectedConditions
//                        .presenceOfAllElementsLocatedBy(By.xpath("//*[@class='md-ripple-container']")) );


        WebElement numberInput = driver.findElement(By.id("input_58"));
        numberInput.sendKeys("4");

        driver.quit();
    }
}
