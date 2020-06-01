package webdriver;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.*;
import java.util.List;
import java.util.concurrent.locks.Condition;

public class BillCloudTest {

    private WebDriver driver;

    @BeforeMethod(alwaysRun = true)
    public void browserSetup() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");

        driver = new ChromeDriver(options);
    }


    @Test(description = "Hurt Me Plently")
    public void compareResults() throws InterruptedException {
        driver.get(" https://cloud.google.com/");

        List<WebElement> allproductBtn = driver.findElements(By.xpath("//*[@class='devsite-footer-linkbox-link gc-analytics-event']"));
        allproductBtn.get(10).click();

        new WebDriverWait(driver, 5).until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//*[@class='devsite-footer-linkbox-link gc-analytics-event']")));

        List<WebElement> priceBtn = driver.findElements(By.xpath("//*[@class='cloud-button cloud-button--secondary']"));
        priceBtn.get(0).click();

        new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//*[@class='cloud-button cloud-button--secondary']")));

        List<WebElement> pricingBtn = driver.findElements(By.xpath("//*[@class='gc-analytics-event ']"));
        pricingBtn.get(3).click();

        new WebDriverWait(driver, 5).until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//*[@class='gc-analytics-event ']")));

        List<WebElement> envBtn = driver.findElements(By.xpath("//*[@href='/products/calculator']"));
        envBtn.get(0).click();

        new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//*[@href='/products/calculator']")));
//        List<WebElement> ele = driver.findElements(By.tagName("iframe"));
//        for (WebElement frame:iframes) {
//            for (WebElement innerFrame:frame.findElements(By.tagName("iframe"))) {
//                if (innerFrame.getAttribute("id").equals("myFrame")) {
//                    List<WebElement> envInput = driver.findElements(By.xpath("//*[@id='input_58']"));
//                    envInput.get(0).sendKeys("4");
//                }
//            }
//        }

//      driver.switchTo().frame(0).switchTo().frame("myFrame");


//        driver.switchTo().frame(0);
//        driver.switchTo().frame("myFrame");

        WebElement envInput = switchToFrameWithWebElement(driver, By.xpath("//*[@id='input_58']/.."));
        envInput.sendKeys("4");

        new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//*[@id='input_58']")));


        List<WebElement> machineTypeBtn = driver.findElements(By.xpath("//*[@class='md-select-icon']"));
        machineTypeBtn.get(4).click();

        new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//*[@class='md-select-icon']")));

        WebElement typeBtn = driver.findElement(By.id("select_option_212']"));
        typeBtn.click();

        new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.id("select_option_212']")));
//        new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("///*[@class='layout-row']")));

//        List<WebElement> envInput = driver.findElements(By.className("layout-row"));
//        envInput.get(0).sendKeys("4");
//        numberInput.get(0).click();
//        numberInput.get(0).sendKeys("4");

    }

    public WebElement switchToFrameWithWebElement(WebDriver driver, By xpathWebElem) //xpathWebElem is xpath of element you want to click
    {
        By byFrameXPath = By.tagName("iframe"); // or By.tagName("iframe")

        // Get all frames by xpath.
        List<WebElement> iframeList = driver.findElements(byFrameXPath);

        if (iframeList.size() > 0) {
            for (WebElement frameWebElem : iframeList) {
                try {
                    driver.switchTo().frame(frameWebElem);
                    WebElement searchingWebElem = driver.findElement(xpathWebElem);
                    return searchingWebElem;
                } catch (Exception e) {
                    driver.switchTo().defaultContent();
                }

            }

        } else {
            System.out.println("Do not find any frame");
        }
        return null;
    }

    @AfterMethod(alwaysRun = true)
    public void browserTearDown() {
        driver.quit();
        driver = null;
    }
}

