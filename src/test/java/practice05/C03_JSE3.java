package practice05;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C03_JSE3 extends TestBase {

    @Test
    public  void test() {
        //Bu sayfada ki searcBox'a ait dom gorunuyor fakat locate almak istedigimizde "Shadow-root" sebebiyle locate
        //alamiyoruz. Bunu asmak icin; Dom uzerine sag click/copy/copy js path yapiyoruz
        //Sonra; JavascriptExecutor objesinin executeScript methodu ile locate alabiliriz.
       //yapistirdigimiz path onune return ifadesini eklemeyi unutmayalim

        driver.get("https://shop.polymer-project.org/");

        JavascriptExecutor jse = (JavascriptExecutor) driver;

        WebElement loginButton = (WebElement) jse
                .executeScript("return document.querySelector(\"body > shop-app\")" +
                        ".shadowRoot.querySelector(\"iron-pages > shop-home\")" +
                        ".shadowRoot.querySelector(\"div:nth-child(2) > shop-button > a\")");
        loginButton.click();




    }
}