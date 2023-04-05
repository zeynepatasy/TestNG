package tests.day22_crossBrowser;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.AmazonPage;
import utilities.ConfigReader;
import utilities.Driver;

public class C03_DataProvider {


    @Test
    public void test01() {
        AmazonPage amazonPage=new AmazonPage();
        //amazon anasayfaya gidelim
        Driver.getDriver().get(ConfigReader.getProperty("amazonUrl"));
        //nutella için arama yapalım
        amazonPage.aramaKutusu.sendKeys("Nutella" + Keys.ENTER);
        //sonucların nutella içerdiğini test edelim
        String expectedKelime="Nutella";
        String actualSonucYazısı=amazonPage.sonucYazısı.getText();
        Assert.assertTrue(actualSonucYazısı.contains(expectedKelime));
        Driver.closeDriver();
    }
    @DataProvider
    public static Object[][] AranacakKelimeler() {
        Object[][]arananKelimeArrayi={{"Nutella"}, {"Java"}, {"Cigdem"}, {"Netherlands"}};
        return arananKelimeArrayi;
    }
    @Test(dataProvider = "AranacakKelimeler") //liste
    //Arayacağımız kelimeleri bir liste gibi tutup
    //bana yollayacak bir veri saglayıcısı olusturacagız
    public void dataProviderTesti(String arananKelime) { //gönderdiği tek bir tane
        AmazonPage amazonPage=new AmazonPage();
        //amazon anasayfaya gidelim
        Driver.getDriver().get(ConfigReader.getProperty("amazonUrl"));
        //Nutella, Java , Cigdem ve Netherlands için arama yapalım
        amazonPage.aramaKutusu.sendKeys(arananKelime + Keys.ENTER);
        //sonucların aradığımız kelime icerdiğini test edelim
        String expectedKelime=arananKelime;
        String actualSonucYazısı=amazonPage.sonucYazısı.getText();
        Assert.assertTrue(actualSonucYazısı.contains(expectedKelime));
        //sayfayı kapatalım
        Driver.closeDriver();
    }
}
