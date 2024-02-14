package practice05;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import utilities.TestBase;
public class C01_JSE1 extends TestBase {

    @Test
    void test() {

        driver.get("https://opensource-demo.orangehrmlive.com/");

        WebElement usernameTextBox=driver.findElement(By.cssSelector("input[name='username']"));
        usernameTextBox.sendKeys("Admin");

        WebElement passwordTextBox = driver.findElement(By.xpath("//input[@name='password']"));
        passwordTextBox.sendKeys("admin123");

        // Typecasting: Veri türünü başka bir türe dönüştürmek.
        JavascriptExecutor jse = (JavascriptExecutor) driver;

        WebElement button = driver.findElement(By.tagName("button"));
        waitForSecond(5);

        //Extra bilgi!
        jse.executeScript("arguments[0].style.backgroundColor = 'black';" , button);
        waitForSecond(5);

        jse.executeScript("arguments[0].style.backgroundColor = 'red';" , button);
        waitForSecond(5);
        jse.executeScript("arguments[0].click();", button);

    }
}