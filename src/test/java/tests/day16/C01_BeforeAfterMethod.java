package tests.day16;

import org.testng.annotations.Test;
import utilities.TestBase;

public class C01_BeforeAfterMethod extends TestBase {

    //@BeforeMethod ve @AfterMethod notasyonları
    //JUnitteki @Before ve @After gibidir
    //her testten önce ve sonra çalışırlar
    @Test
    public void test01(){
        driver.get("https://www.amazon.com");

    }
    @Test
    public void test02(){
        driver.get("https://www.bestbuy.com");
    }
    @Test
    public void techproedTesti(){
        driver.get("https://www.techproeducation.com");
    }
}
