package practica02;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;
import org.openqa.selenium.interactions.Actions;

public class C05 extends TestBase {


    @Test
    void test01() throws InterruptedException {
        // https://demo.guru99.com/test/radio.html
        driver.get("https://demo.guru99.com/test/radio.html");


        Actions actions = new Actions(driver);
        Thread.sleep(3000);
        actions.sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.ENTER)
                .perform();

        WebElement checkBox1 = driver.findElement(By.id("vfb-6-0"));
        WebElement checkBox2 = driver.findElement(By.id("vfb-6-1"));
        WebElement checkBox3 = driver.findElement(By.id("vfb-6-2"));

        // checkbox1 ve checkbox3 seçili değilse seçin
        if (!checkBox1.isSelected()) {
            checkBox1.click();
        }

        if (!checkBox3.isSelected()) {
            checkBox3.click();
        }

        // checkbox1 ve checkbox3 seçili olduğunu test edin
        Assertions.assertTrue(checkBox1.isSelected(), "CheckBox 1'e Secili Degil.");
        Assertions.assertTrue(checkBox3.isSelected(), "CheckBox 3'e Secili Degil.");
        // checkbox2 elementinin seçili olmadığını test edin
        Assertions.assertFalse(checkBox2.isSelected());

    }
}
