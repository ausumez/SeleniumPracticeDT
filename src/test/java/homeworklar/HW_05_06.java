package homeworklar;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import java.util.List;

public class HW_05_06 extends TestBase {

    @Test
    public void uploadTest() {
        // ===========Homework 5==========================
        // https://testpages.herokuapp.com/styled/basic-html-form-test.html adresine gidin
        driver.get("https://testpages.herokuapp.com/styled/basic-html-form-test.html");

        // Username adını, Password ve textArea bolumlerini faker ile doldurun
        Faker faker = new Faker();
        driver.findElement(By.xpath("//*[@name='username']")).sendKeys(faker.name().username(),
                Keys.TAB, faker.internet().password(),Keys.TAB, faker.lorem().paragraph(),Keys.TAB);

        //    Bir dosya seçin ve yükleyin
        WebElement chooseFile =driver.findElement(By.xpath("//input[@name='filename']"));
        String filePath = System.getProperty("user.home")+"\\Downloads\\textfile.txt";
        chooseFile.sendKeys(filePath);
       // Tüm checkbox lari secin
        List<WebElement> checkBoxs = driver.findElements(By.xpath("//input[@name='checkboxes[]']"));
        for (WebElement w : checkBoxs) {
            if(!w.isSelected()){
                w.click();
            }
        }
        //    Radio button da radio 1 i secin
        driver.findElement(By.xpath("//input[@value='rd1']")).click();
        //    Dropdown menü den 2'yi seçin
        WebElement dropDown = driver.findElement(By.xpath("//*[@name='dropdown']"));
        selectIndex(dropDown,1); //method call from TestBase
        // submit'e tıklayın
        driver.findElement(By.xpath("//input[@value='submit']")).click();
        //    Yüklenen dosyanin Form bilgilerinde yer aldığını doğrulayın
        String actualText=driver.findElement(By.xpath("//*[.='textfile.txt']")).getText();
        Assertions.assertEquals("textfile.txt",actualText);
}
    @Test
    void saucedemoTest() {
        //===========Homework 6==========================
        // https://www.saucedemo.com/ adresine gidin
        driver.get(" https://www.saucedemo.com/");
        // Kullanici adini "standard_user" olarak girin
        driver.findElement(By.cssSelector("#user-name")).sendKeys("standard_user");
        // Şifreyi "secret_sauce" olarak girin
        driver.findElement(By.cssSelector("#password")).sendKeys("secret_sauce");
        // Login buttonuna tiklayin
        driver.findElement(By.cssSelector("#login-button")).click();
        // Tum urunleri sepete ekleyin inventory_list
        List<WebElement> addToCard=driver.findElements(By.xpath("//button[text()='Add to cart']"));

        for (WebElement w:addToCard) {
            w.click();

        }

        /*2.yol
        addToCards.forEach(t->t.click());
         */
        //Sepete tiklayarak gidin
        driver.findElement(By.xpath("//a[@class='shopping_cart_link']")).click();
        // Checkout a tiklayin ( Checkout gözükmediği için scrool ile aşağı ineriz)
        Actions actions = new Actions(driver);
        WebElement checkout = driver.findElement(By.cssSelector("#checkout"));
        actions.scrollToElement(checkout).perform();
        checkout.click();
        waitForSecond(5);
        // FirstName-LastName ve posta code unu doldurun
        Faker faker = new Faker();
        driver.findElement(By.id("first-name")).sendKeys(faker.name().firstName(), Keys.TAB, faker.name().lastName(), Keys.TAB, faker.address().zipCode());
        //continue butonuna tiklayin
        driver.findElement(By.id("continue")).click();
        waitForSecond(5);
        // Toplam fiyatın 140,34$ olduğunu dogrulayin
        WebElement total = driver.findElement(By.xpath("//div[@class='summary_info_label summary_total_label']"));

        // Yine toplam fiyat elementi ekranın aşağısında oldugu için scrool yapıyoruz.
        actions.scrollToElement(total).perform();
        String expectedTotal = "Total: $140.34";
        String actualTotal = total.getText();
         Assertions.assertEquals(expectedTotal,actualTotal );

        //finish e tiklayin
        driver.findElement(By.id("finish")).click();

        // Checkout: Complete! yazisinin görüntülendigini doğrulayiniz
        actions.sendKeys(Keys.PAGE_UP).perform();
        waitForSecond(5);
        WebElement actual = driver.findElement(By.xpath("//span[.='Checkout: Complete!']"));
        Assertions.assertTrue(actual.isDisplayed());


    }
}
