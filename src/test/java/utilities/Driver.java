package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class Driver {
    /*
    POM da driver için, testBase classına exrend etmek yerine
    Driver class'ında static methodlar kullanarak
    driver olusturup , ilgili ayarların yapılması
    ve en sonda driver'ın kapatılması tercih edilmiştir
     */
    static WebDriver driver;

    public static WebDriver getDriver() {

        ChromeOptions ops = new ChromeOptions();
        ops.addArguments("--remote-allow-origins=*");

        if (driver == null) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver(ops);
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        }
        return driver;
    }

    public static void closeDriver() {
        if (!(driver == null)) {
            driver.close();
            driver=null; //yukarıda null' eşitse dedğimiz için burda kapatıyoruz
        }
    }
}