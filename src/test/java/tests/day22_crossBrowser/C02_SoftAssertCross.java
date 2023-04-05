package tests.day22_crossBrowser;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utilities.TestBaseCross;

public class C02_SoftAssertCross extends TestBaseCross {
    @Test()
    public void test01(){

        SoftAssert softAssert=new SoftAssert();


        driver.get("https://www.amazon.com");

        String baslıkElementi= driver.getTitle();

        softAssert.assertTrue(baslıkElementi.contains("Amazon"),"Title Amazon içermiyor");

        WebElement aramaKutusu= driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));

        softAssert.assertTrue(aramaKutusu.isEnabled(),"arama kutusuna erişilemiyor");
        aramaKutusu.sendKeys("Nutella" + Keys.ENTER);
        WebElement sonucYazıElementi= driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));

        softAssert.assertTrue(sonucYazıElementi.isDisplayed(),"arama yapılamadı"); //test fail olursa mesajı aşağıda raporlar

        softAssert.assertTrue(sonucYazıElementi.getText().contains("Nutella"),"sonuc yazısı kutella içermiyor");

        softAssert.assertAll();

        System.out.println("assertion'lardan fail olan varsa, burası çalışmaz");
    }
}
