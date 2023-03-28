package tests.day19_smokeTest;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BlueRentalCars;
import utilities.ConfigReader;
import utilities.Driver;

public class NegativeLoginTest {

    BlueRentalCars brcPages=new BlueRentalCars();
    @Test
    public void test01(){
        //https://www.bluerentalcars.com adrsine gidin
        Driver.getDriver().get(ConfigReader.getProperty("brcUrl"));
        //login butonuna basın
        brcPages.FirstloginButonu.click();
        //test data user email: customer@bluerentalcars.com
        brcPages.emailButon.sendKeys(ConfigReader.getProperty("brcWrongEmail"));
        //test data password: 12345
        brcPages.passwordTextBox.sendKeys(ConfigReader.getProperty("brWrongPassword"));
        //login butonuna tıklayın
        brcPages.twoLoginButton.click();
        //Değerleri girildiğinde sayfya girilemediğini test et.
        System.out.println("girilemedi yazısı" + brcPages.girilemediYazısı.getText());
        Assert.assertTrue(brcPages.girilemediYazısı.getText().contains("Bad credentials"));
        Assert.assertTrue(brcPages.twoLoginButton.isDisplayed());
        Driver.closeDriver();
    }
}
