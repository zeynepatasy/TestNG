package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.time.Duration;

public class CrossDriver {
    private CrossDriver(){

    }
    static WebDriver driver;

    public static WebDriver getDriver(String browser) { //driver'ı artık browser olarak gönderecez bu class için


        browser=browser == null ?ConfigReader.getProperty("browser") : browser;

        if (driver == null) {

            switch (browser){
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
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
                    driver = new ChromeDriver();

            }
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();


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
