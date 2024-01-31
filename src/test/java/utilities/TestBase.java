package utilities;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;


public abstract class TestBase {


    protected WebDriver driver;

    @BeforeEach
    void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        System.out.println("BeforeEach");
    }

    @AfterEach
    void tearDown() {
        driver.quit();
        System.out.println("AfterEach");

    }

    //DDM den visible text ile secim
    public  void  selectVisibleText(WebElement ddm,String option){
        Select select = new Select(ddm);
        select.selectByVisibleText(option);
    }

    //DDM den index ile secim
    public void selectIndex(WebElement ddm,int idx){
        Select select = new Select(ddm);
        select.selectByIndex(idx);
    }

    public void waitForSecond(int second){
        try {
            Thread.sleep(second*1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void orangeHRMlogin(){

        // 1) https://opensource-demo.orangehrmlive.com/ sitesine gidin
        driver.get("https://opensource-demo.orangehrmlive.com/");

        // 2) username: Admin ve password: admin123 girin, Login butonuna tıklayın

        WebElement usernameTextBox=driver.findElement(By.cssSelector("input[name='username']"));
        usernameTextBox.sendKeys("Admin");

        WebElement passwordTextBox = driver.findElement(By.xpath("//input[@name='password']"));
        passwordTextBox.sendKeys("admin123");

        WebElement loginButton = driver.findElement(By.xpath("//button[@type='submit']"));
        loginButton.click();

        // 3) Sayfaya giriş yapıldığını doğrula
        WebElement dashboardText = driver.findElement(By.cssSelector(".oxd-text.oxd-text--h6.oxd-topbar-header-breadcrumb-module"));
        Assertions.assertTrue(dashboardText.isDisplayed(), "Login Test FAILED");
    }

}
