package tests.day21_reusableMethods_htmlReports;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;
import utilities.ConfigReader;

public class Deneme {

    @Test
    public void test01(){


        System.out.println("First test is running : " + Thread.currentThread().getId()) ;

    }

    @Test
    public void test02() {

        System.out.println("Second test is running : " + Thread.currentThread().getId()) ;
    }
}
