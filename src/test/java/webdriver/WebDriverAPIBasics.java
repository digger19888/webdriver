package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class WebDriverAPIBasics {
    public static void main (String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("http://seleniumhq.org");
        WebElement searchInput = driver.findElement(By.id("gsc-i-id1"));
        searchInput.sendKeys("selenium java");
        List<WebElement> searchBtn = driver.findElements(By.xpath("//*[@class='search-icon']"));
        searchBtn.get(0).click();
        Thread.sleep(2000);
        driver.quit();
    }

}
