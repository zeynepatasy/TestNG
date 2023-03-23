package tests.day17_pom;

import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import pages.AmazonPage;
import utilities.Driver;

public class C02_PageClassKullanımı {
    AmazonPage amazonPage=new AmazonPage();
    //amazonPages den obje olusturduk,Parametresiz contructordan..
    // ordaki bilgileri ve driver'ı kullanmak için
    @Test
    public void test01(){
        Driver.getDriver().get("https://www.amazon.com");
        amazonPage.aramaKutusu.sendKeys("Nutella" + Keys.ENTER);
          Driver.closeDriver();
    }
}
