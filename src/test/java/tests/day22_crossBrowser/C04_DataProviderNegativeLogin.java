package tests.day22_crossBrowser;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.BlueRentalCars;
import utilities.ConfigReader;
import utilities.Driver;

public class C04_DataProviderNegativeLogin {
    BlueRentalCars brcPages;

    @DataProvider
    public static Object[][] kullanıcıListesi() {
        Object[][]kullaniciBilgileri={{"firuze@nehaber.com","54678"},{"murat@benbuisibilirim.com","12345"},{"ilyas@hollandadanselam.com", "45632"},{"zeynep@birdahadeniyorum.com","2586"}};
        return kullaniciBilgileri;
    }

    @Test(dataProvider = "kullanıcıListesi")
    public void yanlisSifre(String userMail, String password){
        brcPages=new BlueRentalCars();
        //https://www.bluerentalcars.com adrsine gidin
        Driver.getDriver().get(ConfigReader.getProperty("brcUrl"));
        //login butonuna basın
        brcPages.FirstloginButonu.click();
        //test data user email: dataprovider'dan alalım
        brcPages.emailButon.sendKeys(userMail);
        //test data password: dataprovider'dan alalım
        brcPages.passwordTextBox.sendKeys(password);
        //login butonuna tıklayın
        brcPages.twoLoginButton.click();
        //Değerleri girildiğinde sayfya girilemediğini test et.


        Assert.assertTrue(brcPages.twoLoginButton.isDisplayed());
        Driver.closeDriver();
    }
}
