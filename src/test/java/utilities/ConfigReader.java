package utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    //her seyi okuyacak sekilde bir method olusturmamız gerekiyor, diğer classlardan datalara ulasmak için
    //ortacı gibi,ayakçı :)
  public static Properties properties;
    static { //static block her seyden önce devreye girer
        String dosyaYolu="configuration.properties";

        try {
            FileInputStream fis=new FileInputStream(dosyaYolu);
            //Dosya yolunu tanımladığımız configuration.properties dosyasını okudu
            properties=new Properties(); //yukarıda olusturduğumuza dğer atadık
            properties.load(fis);//fis'in okuduğu bilgileri properties'e yükledi

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
     public static String getProperty(String key){
         //test methodundan yolladığımız string key değerini alıp
         //Properties class'ından getProperty() methodunu kullanarak
         //bu key'e ait value'u bize getirdi
         return properties.getProperty(key);
     }
}
