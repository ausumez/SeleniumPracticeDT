package practica02;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02 {



    @Test
    void test01() {
        // https://testpages.herokuapp.com/styled/calculator
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://testpages.herokuapp.com/styled/calculator");

        // ilk kutucuga 30 gir
        driver.findElement(By.id("number1")).sendKeys("30");

        // ikinci kutucuga 15 gir
        driver.findElement(By.id("number2")).sendKeys("15");

        // calculate'e tıkla
        driver.findElement(By.id("calculate")).click();

        // sonucu yazdır
        String sonuc = driver.findElement(By.id("answer")).getText();
        System.out.println("Sonuc: " + sonuc);
        // sayfayı kapat
        driver.quit();
    }

    @Test
    void test02() {
        // https://testpages.herokuapp.com/styled/calculator
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://testpages.herokuapp.com/styled/calculator");

        // ilk kutucuga 30 gir
        driver.findElement(By.cssSelector("#number1")).sendKeys("30");

        // ikinci kutucuga 15 gir
        driver.findElement(By.cssSelector("#number2")).sendKeys("15");

        // calculate'e tıkla
        driver.findElement(By.cssSelector("#calculate")).click();

        // sonucu yazdır
        String sonuc = driver.findElement(By.cssSelector("#answer")).getText();
        System.out.println("Sonuc: " + sonuc);
        // sayfayı kapat
        driver.quit();
    }
}
