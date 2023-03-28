package tests.day19_smokeTest;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BlueRentalCars;
import pages.HotelMyCampPages;
import utilities.ConfigReader;
import utilities.Driver;

public class PositiveLoginTest {
    BlueRentalCars brcPages=new BlueRentalCars();
    @Test
            public void test01(){
        //https://www.bluerentalcars.com adrsine gidin
            Driver.getDriver().get(ConfigReader.getProperty("brcUrl"));
            //login butonuna basın
            brcPages.FirstloginButonu.click();
            //test data user email: customer@bluerentalcars.com
            brcPages.emailButon.sendKeys(ConfigReader.getProperty("brcValidEmail"));
            //test data password: 12345
            brcPages.passwordTextBox.sendKeys(ConfigReader.getProperty("brcValidPassword"));
            //login butonuna tıklayın
            brcPages.twoLoginButton.click();
            //Değerleri girildiğinde sayfya girilemediğini test et.
            String actualUsername=brcPages.kullanıcıProfilİsmi.getText();
            String expectedUsername=ConfigReader.getProperty("brcValidUsername");
            Assert.assertEquals(actualUsername,expectedUsername);
            Driver.closeDriver();
    /*Thread.sleep(2000);
    System.out.println("girilemedi yazısı" + brcPages.girilemediYazısı.getText());
    Assert.assertTrue(brcPages.girilemediYazısı.getText().contains("Bad credentials"));
    Assert.assertTrue(brcPages.FirstloginButonu.isDisplayed());*/

            //burda negative login yaptım giriş yapamadağım için



}


}
