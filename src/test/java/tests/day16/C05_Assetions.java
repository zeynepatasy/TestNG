package tests.day16;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

public class C05_Assetions extends TestBase {
    @Test
    public void test01(){
        //amazon' a gidin
       driver.get("https://www.amazon.com");
        //title'ın amazon içerdiğini test edin
       String baslıkElementi= driver.getTitle();
        Assert.assertTrue(baslıkElementi.contains("Amazon"));
        //arama kutusunun erişilebilir oldugunu test edin
     WebElement aramaKutusu= driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
     Assert.assertTrue(aramaKutusu.isEnabled());
        //Arama kutusuna Nutella yazıp aratın
        aramaKutusu.sendKeys("Nutella" + Keys.ENTER);
        //Arama yapıldıgını test edin
        WebElement sonucYazıElementi= driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
        Assert.assertTrue(sonucYazıElementi.isDisplayed());
        //Arama sonucunun Nutella içerdiğini test edin
        Assert.assertTrue(sonucYazıElementi.getText().contains("Nutella"));
    }

}
