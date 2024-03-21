package test.selenium.class3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class WebElementMethod {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get("https://demoqa.com/automation-practice-form");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        Thread.sleep(2000);


        driver.findElement(By.id("firstName")).sendKeys("sharrif");
//        driver.findElement(By.id("lastName")).clear();
//        driver.findElement(By.id("lastName")).sendKeys("sharrif");


//        these are optiimized  for multiple use

        WebElement webElement = driver.findElement(By.id("lastName"));
        webElement.sendKeys("Sharif");
        Thread.sleep(2000);
        webElement.clear();
        Thread.sleep(2000);
        webElement.sendKeys("afroza");

        driver.findElement(By.cssSelector("label[for='gender-radio-1']")).click();
        Thread.sleep(2000);

        WebElement checkBox = driver.findElement(By.cssSelector("label[for='hobbies-checkbox-1']"));
        System.out.println(checkBox.isDisplayed());
        checkBox.click();
        Thread.sleep(2000);
        System.out.println(checkBox.isSelected());
        System.out.println("getTagName" +checkBox.getTagName());
        System.out.println("getRect" +checkBox.getRect().height);
        System.out.println("font-family" +checkBox.getCssValue("font-family"));
        System.out.println("font-family" +checkBox.getText());

        driver.quit();
    }
}
