package test.selenium.class4;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class NewTabAndWindow {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver= new FirefoxDriver();
        driver.get("https://demoqa.com/browser-windows");
        driver.manage().window().maximize();

//        implicit wait
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
//        explicit wait
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.className("text-center"))));

        System.out.println(driver.findElement(By.className("text-center")).getText());
        //Store the ID of the original window
        String originalWindow = driver.getWindowHandle();

        driver.switchTo().newWindow(WindowType.TAB);
        driver.navigate().to("https://demoqa.com/sample");
        System.out.println("New Tab " + driver.findElement(By.id("sampleHeading")).getText());
        driver.close();
        //Switch back to the old tab or window
        driver.switchTo().window(originalWindow);
        Thread.sleep(2000);



        String originalWindow2 = driver.getWindowHandle();
        // Opens a new window and switches to new window
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.navigate().to("https://demoqa.com/sample");
        Thread.sleep(2000);

        System.out.println("New Window " + driver.findElement(By.id("sampleHeading")).getText());
        Thread.sleep(2000);
        driver.close();

        driver.switchTo().window(originalWindow2);

        Thread.sleep(2000);
        driver.quit();

    }
}
