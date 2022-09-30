package seleniumWebOtomation;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Random;


public class networkTest {

public static void main(String[] args) {

System.setProperty("webdriver.chrome.driver", "C:\\Users\\hatic\\Downloads\\chromedriver_win32\\chromedriver.exe");

WebDriver driver=new ChromeDriver();
JavascriptExecutor js = (JavascriptExecutor) driver;
driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
driver.manage().window().maximize();

driver.get("https://www.network.com.tr/");
//search 
WebElement searchBox = driver.findElement(By.id("search"));
searchBox.sendKeys("ceket");
driver.findElement(By.xpath("//*[@id=\"search\"]")).submit();
//scroll
WebElement Element = driver.findElement(By.xpath("//*[@id=\"pagedListContainer\"]/div[2]/div[2]/button"));
js.executeScript("arguments[0].scrollIntoView();", Element);
//hover the element
Actions action = new Actions(driver);
WebElement elementX = driver.findElement(By.xpath("//*[@id=\"product-135973\"]"));
action.moveToElement(elementX).build().perform();
driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

WebElement element2 = new WebDriverWait(driver, 1).until(ExpectedConditions.elementToBeClickable(By.id("size_46/6N")));
((JavascriptExecutor) driver).executeScript("arguments[0].checked = true;", element2);

}
}