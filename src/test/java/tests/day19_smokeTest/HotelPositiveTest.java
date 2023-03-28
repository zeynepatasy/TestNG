package tests.day19_smokeTest;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BlueRentalCars;
import pages.HotelPages;
import utilities.ConfigReader;
import utilities.Driver;

public class HotelPositiveTest {

HotelPages hotelPages=new HotelPages();
@Test
public void test01() throws InterruptedException {
Driver.getDriver().get(ConfigReader.getProperty("hotelUrl"));
hotelPages.gelişmişButon.click();
}
}
