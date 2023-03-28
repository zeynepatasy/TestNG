package tests.day17_pom;

import org.testng.annotations.Test;
import utilities.ConfigReader;
import utilities.Driver;

public class C04_PositiveTest {
    @Test
    public void positiveLoginTest(){
        Driver.getDriver().get(ConfigReader.getProperty("hotelUrl"));
    }
}
