package day16_notations;

import org.testng.annotations.Test;
import utilities.TestBase;

public class C03_Priority extends TestBase {
    /*
         TestNG test methodlarını isim sıralamasına göre çalıştırır
         Eğer isim sıralamasının dısında bir sıralama ile çalışmasını istersenız
         o zaman test methodlarına öncelik (priority) tanımlayabiliriz

         Priority küçükten büyüğe göre çalışır
         eğer bir test methoduna priority atanmadıysa default =0 olarak kabul edilir

          */
    @Test(priority = -5) //en küçük
    public void test01(){

        driver.get("https://www.amazon.com");
        System.out.println(driver.getCurrentUrl());

    }
    @Test(priority = -2)
    public void test02(){
        driver.get("https://www.bestbuy.com");
        System.out.println(driver.getCurrentUrl());
    }
    @Test
    public void techproedTesti(){
        driver.get("https://www.techproeducation.com");
        System.out.println(driver.getCurrentUrl());
    }

}
