package homeworklar;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;


public class homeWork03 {

            /*
            ÖDEV:
            https://the-internet.herokuapp.com/add_remove_elements/ adresine gidin
            Add Element butonuna basin 100 kez basınız
            Delete butonuna 90 kez basınız
            Ve 90 kez basıldığını doğrulayınız
            */
    WebDriver driver;

    @BeforeEach
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @Test
    public void test01() {
        //https://the-internet.herokuapp.com/add_remove_elements/ adresine gidin
        driver.get("https://the-internet.herokuapp.com/add_remove_elements/");


        //Add Element butonuna 100 kez basınız

        WebElement addElementButton = driver.findElement(By.xpath("//button [@onclick='addElement()']"));

        for (int i = 1; i <= 100; i++) {
            addElementButton.click();
        }
        //Delete butonuna 90 kez basınız
        List<WebElement> deleteButtonElements = driver.findElements(By.xpath("//button [@onclick='deleteElement()']"));
        for (int i = 1; i <= 90; i++) {
            deleteButtonElements.get(i).click();
        }
        //Ve 90 kez basıldığını doğrulayınız
        List<WebElement> deleteButtonElements2 = driver.findElements(By.xpath("//button[@onclick='deleteElement()']"));
        Assertions.assertEquals(10, deleteButtonElements2.size());
    }

    @AfterEach
    public void tearDown() throws InterruptedException {
        //Sayfayi kapatin
        Thread.sleep(3000);
        driver.quit();
    }


}
