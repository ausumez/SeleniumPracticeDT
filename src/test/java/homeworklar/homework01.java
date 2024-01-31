package homeworklar;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.net.URL;
import java.time.Duration;

public class homework01 {


    public static void main(String[] args) throws InterruptedException {


        //Yeni bir class olusturalim (Homework)

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        //ChromeDriver kullanarak, facebook sayfasina gidin ve sayfa basliginin (title) “Facebook” icerdigini dogrulayin (verify),
        //degilse dogru basligi yazdirin
        driver.get("https://facebook.com");

        String expectedTitleData ="Facebook";
        String actualTitleData =driver.getTitle();
            if (actualTitleData.contains(expectedTitleData)) {
                System.out.println("TEST PASSED");
            }else System.out.println("Title = " +driver.getTitle() );//test passed

        //Sayfa URL’inin “facebook” kelimesi icerdigini dogrulayin, icermiyorsa “actual” URL’i yazdirin.

        String actualUrlData = driver.getCurrentUrl();
        if (actualUrlData.contains("facebook")){
            System.out.println("TEST PASSED");
        }else System.out.println("Facebook Url = " + actualUrlData );//test passed

        //https://www.walmart.com/ sayfasina gidin.
        driver.get("https://www.walmart.com/");

        //Sayfa basliginin “Walmart.com” icerdigini dogrulayin.
        String actualWalmartTitle = driver.getTitle();
        if (actualWalmartTitle.contains("“Walmart.com")){

            System.out.println("Test Passed");
        }else System.out.println("Test Failed = " + actualWalmartTitle );//Test Failed = Walmart has deals on the most-wanted gifts

        //Tekrar “facebook” sayfasina donun

        driver.navigate().back();

        //Sayfayi yenileyin
        driver.navigate().refresh();

        //sayfayi tam sayfa (maximize) yapin

        driver.manage().window().maximize();
        Thread.sleep(3000);

        //Sayfayi kapatin
        driver.quit();









    }



    }