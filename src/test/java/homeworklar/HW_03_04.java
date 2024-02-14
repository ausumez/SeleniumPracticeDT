package homeworklar;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBase;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Duration;

public class HW_03_04 extends TestBase {
   /*
    @Test
    void test01() {
        // ===========Homework 3========================== //

        // https://testpages.herokuapp.com/ adresine gidiniz
        driver.get(" https://testpages.herokuapp.com/");

        // File Downloads a tiklayiniz
        Actions actions = new Actions(driver);
        WebElement fileDownload = driver.findElement(By.cssSelector("#download"));
        actions.scrollToElement(fileDownload);
        fileDownload.click();
        // Acilan sayfada Server Download a tiklayiniz
        String filePath =System.getProperty("user.home")+"\\Download\\textfile.txt";

        Path path = Paths.get(filePath);
        try {
            Files.delete(path);
            System.out.println("Download öncesi aynı dosya varsa silindi");
        } catch (IOException e) {

            System.err.println("Download öncesinde dosya bulunamadı");
        }

        WebElement serverDownload = driver.findElement(By.cssSelector("#server-download"));
        actions.scrollToElement(serverDownload);
        serverDownload.click();
        waitForFileExists(filePath, 60);// Max 60sn icinde, 50ms araliklarla check edecegiz
        // Dosyanin basariyla indirildigini test ediniz
        Assertions.assertTrue(Files.exists(path));

}

    //Download isleminde dinamik bekleme suresi icin kullaniyoruz
    public void waitForFileExists(String Filepath, long maxSec) {
        long ms = maxSec * 1000;

        do {
            try {
                Thread.sleep(50);
                ms -= 50;
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            if (ms <= 0) {
                System.out.println("Tanimlanan sure yetersiz kaldi");
            }
        } while (!Files.exists(Paths.get(Filepath)) && ms > 0);

        System.out.println("Islem suresi : " + (maxSec * 1000 - ms) + "ms");
    }

    */

    @Test
    public void name() {
        //         ===========Homework 3==========================
        //
        // https://testpages.herokuapp.com/ adresine gidiniz
        driver.get("https://testpages.herokuapp.com/");
        // File Downloads a tiklayiniz
        Actions actions =new Actions(driver);
        WebElement fileDowload = driver.findElement(By.cssSelector("#download"));
        actions.scrollToElement(fileDowload);
        fileDowload.click();
        // Acilan sayfada Server Download a tiklayiniz
        String dosyaYolu = System.getProperty("user.home")+"\\Downloads\\textfile.txt";
        try {
            Files.delete(Paths.get(dosyaYolu));
            System.out.println("Indirme öncesi aynı isimde olan dosya silindi..");
        } catch (IOException e) {
            System.out.println("Indirme öncesinde dosya yoktu..");
        }
        WebElement serverDowload = driver.findElement(By.cssSelector("#server-download"));
        actions.scrollToElement(serverDowload);
        serverDowload.click();
        waitForSecond(2);
        // Dosyanin basariyla indirildigini test ediniz
        Assertions.assertTrue(Files.exists(Paths.get(dosyaYolu)));
    }

    //===========Homework 4==========================

    @Test
    void ExplicitWait() {
      //https://testpages.herokuapp.com/styled/challenges/growing-clickable.html adresine gidiniz
       driver.get("https://testpages.herokuapp.com/styled/challenges/growing-clickable.html");
       waitForSecond(4);


        //click me buttonu na tiklayiniz
        WebDriverWait driverWait = new WebDriverWait(driver, Duration.ofSeconds(15));
        driverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='styled-click-button showgrow grown']"))).click();

        waitForSecond(2);
        //"Event Triggered" yazisinin görüntülendigini dogrulayiniz
        WebElement actualtext=driver.findElement(By.xpath("//p[@id='growbuttonstatus']"));
        String expectedtext ="Event Triggered";

        waitForSecond(2);
      // Assertions.assertTrue(actualtext.isDisplayed());
      //  Assertions.assertEquals(expectedtext,actualtext.getText());

    }


}

