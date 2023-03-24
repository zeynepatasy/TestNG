package tests.day17_pom;

import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.FaceBookPage;
import utilities.Driver;

public class C03_PageClassKullanımı {
    FaceBookPage facebookPage=new FaceBookPage();
    @Test
    public void test01(){
        //facebook ansayfaya gidin
        Driver.getDriver().get("https://www.facebook.com");
        //kullanıcı mail kutusuna rastgele bir isim yazdırın
        Faker fake=new Faker();
   facebookPage.emailKutusu.sendKeys(fake.internet().emailAddress());
   //kullanıcı sifre kutusuna rastgele bir password0 yazdırın
        facebookPage.sifreKutusu.sendKeys(fake.internet().password());
        //login butonuna basın
        facebookPage.loginTusu.click();
        //giriş yapılamadığını test edin
        Assert.assertTrue(facebookPage.girilemediLYazı.isDisplayed());
        Driver.closeDriver();
    }
}
