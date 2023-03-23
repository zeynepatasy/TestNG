package tests.day16;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utilities.TestBase;

public class C06_SoftAssert extends TestBase {
  @Test
    public void test01(){
      /*
      Soft Assertion baslangıc ve bitiş satırları arasındaki bütün assertionları yapıp,
      bitiş satırında bize buldugu tüm hataları rapar eder
       */


      // Baslangıcı Softassert baslangıc objesı olusturmaktır
      SoftAssert softAssert=new SoftAssert();

      //amazon' a gidin
      driver.get("https://www.amazon.com");
      //title'ın amazon içerdiğini test edin
      String baslıkElementi= driver.getTitle();
      //Asset yaparken Assert classının ismiyle test yaptık, simdide softassert objesiyle yapacaz
    //SoftAssert classının methodları static değil çünkü.
     softAssert.assertTrue(baslıkElementi.contains("Amazon"),"Title Amazon içermiyor");
      //arama kutusunun erişilebilir oldugunu test edin
      WebElement aramaKutusu= driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
      softAssert.assertTrue(aramaKutusu.isEnabled(),"arama kutusuna erişilemiyor");
      //Arama kutusuna Nutella yazıp aratın
      aramaKutusu.sendKeys("Nutella" + Keys.ENTER);
      //Arama yapıldıgını test edin
      WebElement sonucYazıElementi= driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
      softAssert.assertTrue(sonucYazıElementi.isDisplayed(),"arama yapılamadı"); //test fail olursa mesajı aşağıda raporlar
      //Arama sonucunun Nutella içerdiğini test edin
      softAssert.assertTrue(sonucYazıElementi.getText().contains("Nutella"),"sonuc yazısı kutella içermiyor");

      //softAssert'e bitiş saturını söylemek için  assertAll kullanıllır.
      //bu satır yazılmazsa assertion görevi yapılmamıs olur.
    softAssert.assertAll();

    /*Softassert'in hata bulsa bile çalışmaya devam etme özellliği assertAll'a kadardır
     Eğer assertAll'da failed rapor edilirse, çalışma durur ve class'ın kalan kısmı çalışırılmaz
     (Yani assertAll hardAssertteki her bir assert gibidir, hayatı yakalarsa çalışma durur)
      */
      System.out.println("assertion'lardan fail olan varsa, burası çalışmaz");
  }
}
