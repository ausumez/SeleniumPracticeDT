package practice03;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C01_LoginTest1 extends TestBase {

    // 1) https://opensource-demo.orangehrmlive.com/ sitesine gidin
    // 2) username: Admin ve password: admin123 girin, Login butonuna tıklayın
    // 3) Sayfaya giriş yapıldığını doğrula
    // 4) Admin butonunun görüdüğünü doğrula
    // 5) Sayfadan çıkıç yap
    // 6) Sayfadan Çıkış Yapıldığını Doğrula
    @Test
    void test01() {

        // 1) https://opensource-demo.orangehrmlive.com/ sitesine gidin
        driver.get("https://opensource-demo.orangehrmlive.com/");

        // 2) username: Admin ve password: admin123 girin, Login butonuna tıklayın
        //WebElement usernameTextBox=driver.findElement(By.name("username"));
        WebElement usernameTextBox=driver.findElement(By.cssSelector("input[name='username']"));
        usernameTextBox.sendKeys("Admin");

        WebElement passwordTextBox = driver.findElement(By.xpath("//input[@name='password']"));
        passwordTextBox.sendKeys("admin123");

        WebElement loginButton = driver.findElement(By.xpath("//button[@type='submit']"));
        loginButton.click();

        //userNameTextBox.sendKeys("Admin" + Keys.TAB + "admin123" + Keys.ENTER);

        // 3) Sayfaya giriş yapıldığını doğrula
        WebElement dashboardText = driver.findElement(By.cssSelector(".oxd-text.oxd-text--h6.oxd-topbar-header-breadcrumb-module"));
        Assertions.assertTrue(dashboardText.isDisplayed(), "Login Test FAILED");

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

