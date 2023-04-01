package tests.day21_reusableMethods_htmlReports;

import org.testng.annotations.Test;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.io.IOException;

public class C02_ScreenshotReusableMethod {
    @Test
    public void test01() throws IOException {
        Driver.getDriver().get(ConfigReader.getProperty("amazonUrl"));
        ReusableMethods.getScreenshot("amazon screenshot");
        Driver.closeDriver();
    }
}
