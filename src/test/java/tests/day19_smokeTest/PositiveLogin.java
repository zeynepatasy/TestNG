package tests.day19_smokeTest;

import org.testng.annotations.Test;
import pages.HotelMyCampPages;
import utilities.ConfigReader;
import utilities.Driver;

public class PositiveLogin {
HotelMyCampPages hotelMyCampPages=new HotelMyCampPages();

    @Test
    public void test01(){
        Driver.getDriver().get(ConfigReader.getProperty("hotelUrl"));
        hotelMyCampPages.gelişmişButon.click();

    }
}
