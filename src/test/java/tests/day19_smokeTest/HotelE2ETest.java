package tests.day19_smokeTest;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HotelMyCampPages;
import utilities.ConfigReader;
import utilities.Driver;

public class HotelE2ETest {
    HotelMyCampPages hotelMyCampPages=new HotelMyCampPages();
    @Test
    public void createHotel() throws InterruptedException {
        Driver.getDriver().get(ConfigReader.getProperty("hotelUrl"));
        hotelMyCampPages.gelişmişButon.click();
        hotelMyCampPages.güvenliDeğil.click();
        hotelMyCampPages.loginButon.click();
        hotelMyCampPages.username.sendKeys(ConfigReader.getProperty("hotelusername"));
        hotelMyCampPages.password.sendKeys(ConfigReader.getProperty("hotelpassword"));
        hotelMyCampPages.ikinciLoginButon.click();
        hotelMyCampPages.managementButon.click();
        hotelMyCampPages.hotelList.click();
        hotelMyCampPages.addHotel.click();
        Actions actions=new Actions(Driver.getDriver());
        actions.click(hotelMyCampPages.codeButon).sendKeys(ConfigReader.getProperty("hotelcode")).
                sendKeys(Keys.TAB).
                sendKeys(ConfigReader.getProperty("hotelName")).
                sendKeys(Keys.TAB).
                sendKeys(ConfigReader.getProperty("hotelAddress")).
                sendKeys(Keys.TAB).sendKeys(ConfigReader.getProperty("hotelPhone")).
                sendKeys(Keys.TAB).sendKeys(ConfigReader.getProperty("hotelEmail")).perform();
        Select options=new Select(hotelMyCampPages.ddm);
        options.selectByIndex(1);
        Thread.sleep(2000);

        hotelMyCampPages.saveButon.click();
        String expectedYazı="Hotel was inserted successfully";
        System.out.println(hotelMyCampPages.kayıtBasarılı.getText());

    Assert.assertTrue(hotelMyCampPages.kayıtBasarılı.getText().contains(expectedYazı));
    }
}
