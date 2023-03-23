package tests.day17_pom;

import org.testng.annotations.Test;
import utilities.Driver;

public class C01_DriverİlkClass {
    @Test
    public void testO1(){
        Driver.getDriver().get("https://www.amazon.com");
        /*
        Bugune kadar, TestBase class'ına extends ederek kullandığımız driver yerine
        bundan sonra Driver class'ından kullanacığımız getDriver static methodunu kullanacağız
         */
        Driver.getDriver().get("https://www.bestbuy.com");
        Driver.closeDriver();
        Driver.getDriver().get("https://www.facebook.com");
        Driver.closeDriver();
    }
}
