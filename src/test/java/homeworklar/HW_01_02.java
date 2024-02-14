package homeworklar;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

import java.util.List;

public class HW_01_02 extends TestBase {


    @Test
    void test01() {

    //==========Homework 1===========================

    //- http://szimek.github.io/signature_pad/ sayfasına gidiniz
    driver.get("http://szimek.github.io/signature_pad/");
    //- Çıkan ekrana istediğiniz çizgi yada şekli çiziniz
        WebElement canvas = driver.findElement(By.cssSelector("#signature-pad"));
        Actions actions = new Actions(driver);
        actions.clickAndHold(canvas).
                moveByOffset(200,0)
                .moveByOffset(0,200)
                .moveByOffset(-200,0)
                .moveByOffset(0,-200)
                .release().perform();
        waitForSecond(2);

    //- Çizimden sonra clear butonuna basınız
        WebElement clear = driver.findElement(By.xpath("//button[@class='button clear']"));
        clear.click();
    //- Sayfayi kapatiniz/TestBase de kapandı
    }
    @Test
    public void dropdownMenu() {
        //===========Homework 2==========================
        //
        //    https://the-internet.herokuapp.com/dropdown adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dropdown");
        // 1.Index kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
        WebElement dropdown = driver.findElement(By.cssSelector("#dropdown"));
        WebElement secenek1 =driver.findElement(By.xpath("//option[.='Option 1']"));
        selectIndex(dropdown,1);
        System.out.println(secenek1.getText());
        waitForSecond(1);

        // 2.Value kullanarak Seçenek 2'yi (Option 2) seçin ve yazdırın
        WebElement secenek2 =driver.findElement(By.xpath("//option[.='Option 2']"));
        selectByValue(dropdown,"2");
        waitForSecond(2);
        // 3.Visible Text(Görünen metin) kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
        selectVisibleText(dropdown,"Option 1");
        System.out.println(secenek1.getText());
        waitForSecond(2);
        // 4.Tüm dropdown değerleri(value) yazdırın
        Select select = new Select(dropdown);
        List<WebElement> allOptions = select.getOptions();
        allOptions.forEach(t-> System.out.println(t.getText()));
        waitForSecond(1);
        //  5.Dropdown’un boyutunu bulun, Dropdown’da 4 öğe varsa konsolda True , degilse
        //    False yazdırın.
        int dropdownBoyut = allOptions.size();
        if (dropdownBoyut==4){
            System.out.println("True");
        }else {
            System.out.println("False");
        }


    }
    }



