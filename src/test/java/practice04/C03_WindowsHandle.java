package practice04;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import utilities.TestBase;

public class C03_WindowsHandle extends TestBase {

    @Test
    void test() {
        // ANA SAYFAYA GiT
        driver.get("https://allovercommerce.com/");

        // SAYFAYA GiDiLDiGiNi DOGRULA
        Assertions.assertEquals("https://allovercommerce.com/", driver.getCurrentUrl());
        Assertions.assertEquals("Allover Commerce", driver.getTitle());

        // Register butonu
        driver.findElement(By.cssSelector(".register.inline-type")).click();

        // Become a vendor
        driver.findElement(By.partialLinkText("Become a Vendor")).click();

        // Sayfanın Windows Handle değeri
        String allOverCommerceHandle = driver.getWindowHandle();
        System.out.println(allOverCommerceHandle);

        // https://www.fakemail.net/ Adresine git
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://www.fakemail.net/");
        String fakeMailHandle = driver.getWindowHandle();
        System.out.println(fakeMailHandle);

        // e-mail adresini al
        String eMailAdres = driver.findElement(By.cssSelector("span#email")).getText();
        System.out.println(eMailAdres);

        waitForSecond(2);

        // https://allovercommerce.com/ git
        driver.switchTo().window(allOverCommerceHandle);

        waitForSecond(2);

        //mail adresini gir
        driver.findElement(By.cssSelector("#user_email")).sendKeys(eMailAdres, Keys.TAB);

        waitForSecond(5);

        WebElement mailDogrulamaMetni = driver.findElement(By.cssSelector(".wcfm-message.email_verification_message.wcfm-success"));
        System.out.println(mailDogrulamaMetni.getText());

        Assertions.assertTrue(mailDogrulamaMetni.getText().contains(eMailAdres));

        // https://allovercommerce.com/ git
        driver.switchTo().window(fakeMailHandle);
        driver.navigate().refresh();
        waitForSecond(5);

        // Gelen maile tıkla
        driver.findElement(By.cssSelector(".from")).click();
        waitForSecond(1);
        // iframe geçme
        driver.switchTo().frame(1);
        String verificationCode = driver.findElement(By.tagName("b")).getText();
        System.out.println(verificationCode);

        // https://allovercommerce.com/ git
        driver.switchTo().window(allOverCommerceHandle);


        driver.findElement(By.cssSelector("input[name='wcfm_email_verified_input']")).sendKeys(verificationCode);



    }
    }

