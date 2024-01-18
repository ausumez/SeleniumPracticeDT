package practice01;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class C02_HelloSeleniumFirefox {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new FirefoxDriver();
        driver.get("https://selenium.dev");
        Thread.sleep(3000);
        driver.quit();

        WebDriver driver1= new ChromeDriver();
        driver.get("https://selenium.dev");
        Thread.sleep(3000);
        driver.quit();

        WebDriver driver2 = new EdgeDriver();
        driver.navigate().to("https://selenium.dev");
        Thread.sleep(3000);
        driver.quit();


    }

}
