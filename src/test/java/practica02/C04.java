package practica02;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

public class C04 extends TestBase {

    @Test
    void test01() {
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
    }

    @Test
    void test02() {
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
    }
}
