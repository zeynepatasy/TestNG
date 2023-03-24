package tests.day18_pom;

import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.FaceBookPage;
import utilities.ConfigReader;
import utilities.Driver;

public class C02_ConfigReaderKullanımı {
    FaceBookPage faceBookPage=new FaceBookPage();
    @Test
    public void test01(){
        //facebook ansayfaya gidin
        Driver.getDriver().get(ConfigReader.getProperty("facebookUrl"));
        //kullanıcı mail kutusuna yanlıs bir kullanıcı adı yazdırın
        faceBookPage.emailKutusu.sendKeys(ConfigReader.getProperty("fbWrongUsername"));
        //kullanıcı sifre kutusuna yanlıs bir password yazdırın
        faceBookPage.sifreKutusu.sendKeys(ConfigReader.getProperty("fbWrongPassword"));
        //login butonuna basın
       faceBookPage.loginTusu.click();
        //giriş yapılamadığını test edin
       Assert.assertTrue(faceBookPage.girilemediLYazı.isDisplayed());
        Driver.closeDriver();
    }
}
