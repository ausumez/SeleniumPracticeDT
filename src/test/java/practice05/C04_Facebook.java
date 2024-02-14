package practice05;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.JavascriptExecutor;
import utilities.TestBase;

public class C04_Facebook extends TestBase {
    @Test
    void test(){
        driver.get("https://www.facebook.com");
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("document.getElementById('email').value='deneme@abc.com';");
        jse.executeScript("document.getElementById('pass').value='123456';");

        waitForSecond(5);
    }
    }
