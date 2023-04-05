package tests.day21_reusableMethods_htmlReports;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;
import utilities.ConfigReader;

public class FarklıBrowserdaÇalıstırma {
    WebDriver driver=null;
    @Test
    public void test01(){

        ChromeOptions ops = new ChromeOptions();
        ops.addArguments("--remote-allow-origins=*");

        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver(ops);
        driver.get(ConfigReader.getProperty("amazonUrl"));


    }

    @Test
    public void test02() {
        ChromeOptions ops = new ChromeOptions();
        ops.addArguments("--remote-allow-origins=*");

        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver(ops);
        driver.get(ConfigReader.getProperty("facebookUrl"));

    }
}
