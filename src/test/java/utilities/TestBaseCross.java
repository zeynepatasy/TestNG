package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.time.Duration;

public class TestBaseCross {
    protected WebDriver driver;
    //Artık cross browser olarak test yapmak istersek bu class'ı extends yapacaz
    @Parameters("browser") //buraya gönderdiğimiz parametreyi beforemethod alacak kendi aralarında.


    @BeforeMethod
    public void setUp(@Optional String browser){

        driver=CrossDriver.getDriver(browser); //***** burası önemli
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    @AfterMethod
    public void tearDown(){

        CrossDriver.closeDriver();
    }
}
