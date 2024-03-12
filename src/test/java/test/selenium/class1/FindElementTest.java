package test.selenium.class1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;

public class FindElementTest {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.selenium.dev/documentation/webdriver/");
        driver.manage().window().maximize();
        driver.findElement(By.id("user.name")).sendKeys("standard_user");
        List<WebElement> webElements= driver.findElements(By.tagName("a"));
        System.out.println("total linkks: " +webElements.size());
        Thread.sleep(3000);
        driver.quit();


    }
}
