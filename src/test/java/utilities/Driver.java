package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.time.Duration;

public class Driver {
    /*
    POM da driver için, testBase classına extend etmek yerine
    Driver class'ında static methodlar kullanarak
    driver olusturup , ilgili ayarların yapılması
    ve en sonda driver'ın kapatılması tercih edilmiştir
     */
    static WebDriver driver;

    public static WebDriver getDriver() {

        ChromeOptions ops = new ChromeOptions();
        ops.addArguments("--remote-allow-origins=*");

        if (driver == null) {
            switch (ConfigReader.getProperty("browser")){
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver(ops);
                    break;
                case "safari" :
                    WebDriverManager.safaridriver().setup();
                    driver=new SafariDriver();
                    break;
                case "headless-chrome":
                    WebDriverManager.chromedriver().setup();
                        driver=new ChromeDriver(new ChromeOptions().setHeadless(true));
                        break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver=new FirefoxDriver();
                    break;
                default:
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver(ops);

            }
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver(ops);
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        }
        return driver;
    }

    public static void closeDriver() {
        if (!(driver == null) ){
            driver.close();
            driver=null; //yukarıda null' eşitse dedğimiz için burda kapatıyoruz
        }
    }
}