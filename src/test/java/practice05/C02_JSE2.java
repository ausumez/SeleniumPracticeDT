package practice05;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C02_JSE2 extends TestBase {

    @Test
    void test() {

        driver.get("https://books-pwakit.appspot.com/");

        JavascriptExecutor jse = (JavascriptExecutor) driver;

        //shadow-root-open:Normal methodlar ile web elemente ulaşmamız çok zordur.JSE kullanacagız
        WebElement searchTextBox = (WebElement) jse
                .executeScript("return document.querySelector(\"body > book-app\").shadowRoot.querySelector(\"#input\")");

        waitForSecond(4);

        searchTextBox.sendKeys("BU KADAR");


    }

}
