package tests.day16;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


import java.time.Duration;

public class C04_DependsOnMethods  {
    WebDriver driver;
  @BeforeClass
 //BeforeClass ve AfterClass notasyonu bir classtaki bütün testler için bir kez çalısır
  //BeforeAfterMethod olsaydı her test için ayrı ayrı çalışacaktı ve amazona gidemeycekti kapancağı için
  public void setUp(){
      ChromeOptions ops = new ChromeOptions();
      ops.addArguments("--remote-allow-origins=*");

      WebDriverManager.chromedriver().setup();
      driver=new ChromeDriver(ops);
      driver.manage().window().maximize();
      driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

  }

  @AfterClass
  public void tearDown(){
      driver.close();

  }
    //bu classta bütün testler bağımsız 1. çalısmazsa diğerleri çalışmaya devam eder.
    //dependsOnMethod testlerin çalışma sıralamasına karışmaz.Priority önce siz belirlemelisiniz, yoksa isme göre çalışır
    //dependsOnMethod testleri birbirine bağlar birisi çalışmazsa diğerleri hiç çalıştırmaz
    //Bağlı oldugu testin sonucuna bakar, bağlandıgı test pass olmazsa bağlanan test hiç çalışmaz.İgnor olur.


    @Test
    public void test01(){

      driver.get("https://www.amazon.com");
    }
    @Test(dependsOnMethods = "test01" ,priority = 0)
    public void test02(){
        WebElement aramaKutusu= driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("Nutella" + Keys.ENTER);
        //Test ignored.
    }
    @Test(dependsOnMethods = "test02")
    public void test03(){
        //sonuc elementinin Nutella içerdiğini test edelim
        WebElement sonucYazıElementi= driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
        Assert.assertTrue(sonucYazıElementi.getText().contains("Nutella"));
        //Test ignored.
    }
    @Test(groups = {"grup1","grup2"}) //bu test hem grup 1'e hem grup 2'ye dahil
    public void test04(){
        System.out.println("Bak bu çalıştı");

    }
}

