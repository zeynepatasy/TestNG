package tests.day21_reusableMethods_htmlReports;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BlueRentalCars;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

public class C03_PositiveLoginTestiRaporlu extends TestBaseRapor {
    BlueRentalCars brcPages = new BlueRentalCars();

    @Test
    public void test01() {
        extentTest=extentReports.createTest("pozitif Login","geçerli username ve sifre ile giriş yapabilmeli");
        //burda değer atadık extentTeste

        //https://www.bluerentalcars.com adrsine gidin
        Driver.getDriver().get(ConfigReader.getProperty("brcUrl"));
        extentTest.info("Brc anasayfaya gidildi");
        //login butonuna basın
        brcPages.FirstloginButonu.click();
       extentTest.info("login butonuna tıklandı");
        //test data user email: customer@bluerentalcars.com
        brcPages.emailButon.sendKeys(ConfigReader.getProperty("brcValidEmail"));
        extentTest.info("gecerli email yazıldı");
        //test data password: 12345
        brcPages.passwordTextBox.sendKeys(ConfigReader.getProperty("brcValidPassword"));
        extentTest.info("gecerli sifre girildi");
        //login butonuna tıklayın
        brcPages.twoLoginButton.click();
        extentTest.info("login butonuna basıldı");
        //Değerleri girildiğinde sayfya girilemediğini test et.
        String actualUsername = brcPages.kullanıcıProfilİsmi.getText();
        String expectedUsername = ConfigReader.getProperty("brcValidUsername");
        Assert.assertEquals(actualUsername, expectedUsername);
        extentTest.pass("kullanıcı basarılı sekilde giriş yaptı");
        Driver.closeDriver();
    }
}