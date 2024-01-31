package practice03;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C04_SignUPTest extends TestBase {
    // 1) 'http://automationexercise.com' adresine gidin
    // 2) Sayfaya girildigini dogrulayin
    // 3) "Signup / Login" butonuna TIKLAYIN
    // 4) "Signup / Login" sayfasina girildigini dogrulayin
    // 5) "New User Signup!" Name ve Email Address gir
    // 6) "Signup" buttonuna TIKLA
    // 7) "ENTER ACCOUNT INFORMATION" bilgilerini gir
    // 8) "Sign up for our newsletter!" onay kutusunu seçin.
    // 9) "Receive special offers from our partners!" onay kutusunu seçin.
    // 10) "ADDRESS INFORMATION" bilgilerini gir
    // 11) Hesap olusturuldugunu dogrula

    @Test
    void test01() {

        Faker faker = new Faker();

        // 1) 'http://automationexercise.com' adresine gidin
        driver.get("http://automationexercise.com");

        // 2) Sayfaya girildigini dogrulayin
        Assertions.assertEquals("Automation Exercise", driver.getTitle());
        Assertions.assertEquals("https://automationexercise.com/", driver.getCurrentUrl());
        Assertions.assertTrue(driver.getTitle().contains("Automation Exercise"), "Homepage Test FAILED");

        // 3) "Signup / Login" butonuna TIKLAYIN
        WebElement signUpbutton= driver.findElement(By.xpath("//a[@href='/login']"));
        signUpbutton.click();

        // 4) "Signup / Login" sayfasina girildigini dogrulayin
        Assertions.assertTrue(driver.getTitle()
                .contains("Automation Exercise - Signup / Login"), "Login Test FAILED");

        // 5) "New User Signup!" Name ve Email Address gir
        WebElement nameTextBox = driver.findElement(By.xpath("//input[@name='name']"));
        WebElement emailTextBox = driver.findElement(By.xpath("//input[@data-qa='signup-email']"));
        WebElement loginButton = driver.findElement(By.xpath("//button[@data-qa='signup-button']"));

        nameTextBox.sendKeys("Ay Can");
        emailTextBox.sendKeys("aycan@aycan.com");


        // 6) "Signup" buttonuna TIKLA
        loginButton.click();

        // 7) "ENTER ACCOUNT INFORMATION" bilgilerini gir
        // Mr
        driver.findElement(By.cssSelector("#id_gender1")).click();

        // Password
        WebElement passwordTextBox = driver.findElement(By.cssSelector("#password"));
        passwordTextBox.sendKeys("123456");

        // Date of Birth ( 15 April 2000)
        WebElement days = driver.findElement(By.cssSelector("#days"));
        WebElement months = driver.findElement(By.cssSelector("#months"));
        WebElement years = driver.findElement(By.cssSelector("#years"));

        selectVisibleText(days, "15");
        selectVisibleText(months, "April");
        selectVisibleText(years, "2000");

        // 8) "Sign up for our newsletter!" onay kutusunu seçin.
        driver.findElement(By.cssSelector("#newsletter")).click();
          waitForSecond(2);
        // 9) "Receive special offers from our partners!" onay kutusunu seçin.
        driver.findElement(By.cssSelector("#optin")).click();
        // 10) "ADDRESS INFORMATION" bilgilerini gir

        WebElement firstNameTextBox = driver.findElement(By.cssSelector("#first_name"));
        firstNameTextBox.sendKeys(faker.name().firstName());

        WebElement lastNameTextBox = driver.findElement(By.cssSelector("#last_name"));
        lastNameTextBox.sendKeys(faker.name().lastName());

        WebElement addressTextBox = driver.findElement(By.cssSelector("#address1"));
        addressTextBox.sendKeys(faker.address().fullAddress());

        WebElement countryTextBox = driver.findElement(By.cssSelector("#country"));
        selectIndex(countryTextBox, 2);

        WebElement stateTextBox = driver.findElement(By.cssSelector("#state"));
        stateTextBox.sendKeys(faker.address().state());

        WebElement cityTextBox = driver.findElement(By.cssSelector("#city"));
        cityTextBox.sendKeys(faker.address().city());

        WebElement zipCodeTextBox = driver.findElement(By.cssSelector("#zipcode"));
        zipCodeTextBox.sendKeys(faker.address().zipCode());

        WebElement mobileNumberTextBox = driver.findElement(By.cssSelector("#mobile_number"));
        mobileNumberTextBox.sendKeys(faker.phoneNumber().cellPhone());

        driver.findElement(By.cssSelector(".btn.btn-default")).click();

        // 11) Hesap olusturuldugunu dogrula
    }

}
