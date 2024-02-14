package practice05;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C05_FileUpload extends TestBase {

    @Test
    void loginTest() {

        // https://opensource-demo.orangehrmlive.com/ Sayfaya git
        orangeHRMlogin();

        // PIM Butonu tikla
        driver.findElement(By.partialLinkText("PIM")).click();

        // Add butonuna tikla
        driver.findElement(By.cssSelector(".oxd-icon.bi-plus.oxd-button-icon")).click();

        // Resim Ekle
        WebElement addPhoto = driver.findElement(By.cssSelector(".oxd-icon.bi-plus"));
        addPhoto.click();

        waitForSecond(4);

        String dosyaYolu = "C:\\Users\\aycan\\IdeaProjects\\SeleniumPracticeDT\\src\\test\\resources\\resim.png";

        uploadFilePath(dosyaYolu);

        /*
        Resim eklenmeden once
        src="/web/images/default-photo.png"

        Resim eklendikten sonra
        src ="data:image/png"
         */
        WebElement resimEkleme = driver.findElement(By.cssSelector(".employee-image"));

        // Resim Eklendiğini Dogrula
        Assertions.assertTrue(resimEkleme.getAttribute("src").contains("data:image/png"), "RESiM EKLENMEDİ");


        // First Name
        WebElement employeeFirstNameTextBox = driver.findElement(By.cssSelector("input[name=\"firstName\"]"));
        employeeFirstNameTextBox.sendKeys("Ali");

        // Middle Name
        WebElement employeeMiddleNameTextBox = driver.findElement(By.cssSelector("input[name=\"middleName\"]"));
        employeeMiddleNameTextBox.sendKeys("Can");

        // Last Name
        WebElement employeeLastNameTextBox = driver.findElement(By.cssSelector("input[name=\"lastName\"]"));
        employeeLastNameTextBox.sendKeys("Efe");

        // Employee ID
        WebElement eplyeeIdTextBox = driver.findElement(By.xpath("(//input[@class=\"oxd-input oxd-input--active\"])[2]"));
        eplyeeIdTextBox.sendKeys("3");

        // Save Butonu
        WebElement saveButtonPIM = driver.findElement(By.xpath("//button[@type=\"submit\"]"));
        saveButtonPIM.click();

        // Kayıt yapildigini dogrula
        WebElement kayitMesaji = driver.findElement(By.xpath("//*[text()='Success']"));

        System.out.println(kayitMesaji.getText());

        Assertions.assertEquals("Success", kayitMesaji.getText(), "HATA");





    }


}
