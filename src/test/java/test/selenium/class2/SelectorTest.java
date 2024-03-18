package test.selenium.class2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;
import java.util.List;

public class SelectorTest {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("https://parabank.parasoft.com/parabank/index.htm");
        driver.manage().timeouts().implicitlyWait(Duration.ofDays(30));
        //Relative xpath
        driver.findElement(By.xpath("//input[@type='text']")).sendKeys("efehfheihgei");
        Thread.sleep(2000);
        //name
        driver.findElement(By.name("password")).sendKeys("efehfdgfheihgei");

        //linktest
        driver.findElement(By.linkText("Register")).click();
        Thread.sleep(2000);

        //partiallinkTest
        driver.findElement(By.partialLinkText("n info?")).click();
        Thread.sleep(2000);

        //CssSelector
        driver.findElement(By.cssSelector("input[id='firstName']")).sendKeys("dfbdjbj");
        driver.findElement(By.id("lastName")).sendKeys("dfbdjjhhbj");

        //anchorTag
        List<WebElement> webElements = driver.findElements(By.tagName("a"));
        for (WebElement webElement:webElements){
            System.out.println(webElement.getText() +" " +webElement.getAttribute("href"));
        }
        driver.quit();



    }
}
