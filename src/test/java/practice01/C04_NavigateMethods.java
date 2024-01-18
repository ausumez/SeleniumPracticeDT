package practice01;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C04_NavigateMethods {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://www.youtube.com");
        Thread.sleep(3000);

        driver.navigate().to("https://www.techproeducation.com");

        Thread.sleep(3000);
        driver.navigate().back();

        Thread.sleep(3000);

        driver.navigate().refresh();
        Thread.sleep(3000);

        driver.navigate().forward();
        driver.quit();
    }
    }

