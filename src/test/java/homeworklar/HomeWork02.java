package homeworklar;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class HomeWork02 {

       /*
            homework
       https://www.google.com/ adresine gidin
       cookies uyarisi cikarsa kabul ederek kapatin
       Sayfa basliginin “Google” ifadesi icerdigini test edin
       Arama cubuguna “Selenium” yazip aratin
       Bulunan sonuc sayisini yazdirin
       sonuc sayisinin 10 milyon’dan fazla oldugunu test edin
       Sayfayi kapatin
     */

    WebDriver driver;
    @BeforeEach
    void setUp() throws InterruptedException {
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get(" https://www.google.com/");
        driver.findElement(By.xpath("//div[text()='Accept all']")).click();
        Thread.sleep(5000);

    }

    @AfterEach
    void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }



    @Test
    public void test01() throws InterruptedException{

        String actualGoogleTitle = driver.getTitle();
        String expectedGoogleTitle = "Google";
        Assertions.assertTrue(actualGoogleTitle.contains(expectedGoogleTitle));
    }
    @Test
    void test02() {
        driver.findElement(By.xpath("//div/textarea[@id='APjFqb']")).sendKeys("Selenium" , Keys.ENTER);

        WebElement resultsStatement = driver.findElement(By.id("result-stats"));
        System.out.println(resultsStatement);
        String numberOfResults = resultsStatement.getText().split(" ")[1];
        System.out.println("numberPfResults= " + numberOfResults);

        String cleanedNumber = numberOfResults.replace(",","");
        long result =Long.parseLong(cleanedNumber);
        Assertions.assertTrue(result > 10000000);

    }




}
