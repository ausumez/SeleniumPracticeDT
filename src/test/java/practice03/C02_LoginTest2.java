package practice03;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import utilities.TestBase;

import java.time.Duration;

public class C02_LoginTest2 extends TestBase {

    @Test
    void test01(){

        orangeHRMlogin();

        // 4) Admin butonunun görüdüğünü doğrula
        Assertions.assertTrue(driver.findElement(By.xpath("(//*[.='Admin'])[3]")).isDisplayed());

//        WebElement adminButton = driver.findElement(By.partialLinkText("Admin"));
//
//        Assertions.assertTrue(adminButton.isDisplayed());

        // 5) Sayfadan çıkıç yap
        WebElement logout1 = driver.findElement(By.cssSelector(".oxd-icon.bi-caret-down-fill.oxd-userdropdown-icon"));
        logout1.click();

        WebElement logout2 = driver.findElement(By.xpath("//a[@href='/web/index.php/auth/logout']"));
        logout2.click();

        // 6) Sayfadan Çıkış Yapıldığını Doğrula
        Assertions.assertTrue(driver.findElement(By.xpath("//button[@type='submit']")).isDisplayed());
}
}
