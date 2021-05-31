
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotSelectableException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.sql.SQLOutput;
import java.util.concurrent.TimeUnit;


public class GittigidiyorTest {

    public WebDriver driver;

    @Before
    public void Start(){
        System.setProperty("C:\\Users\\AKIN\\Desktop\\finalgittigiddiyor");

        //Chorome Driver oluşturma.

        driver=new ChromeDriver();

        // Website URL
        String url ="https://www.gittigidiyor.com/";
        driver.get(url);


        //ekranın büyütülmesi.

        driver.manage().window().maximize();

        //Control

        String NewUrl;
        NewUrl=driver.getCurrentUrl();
        Assert.assertEquals(url,NewUrl);

        //Bekleme..

        driver.manage().timeouts().implicitlyWait(70,TimeUnit.SECONDS);




    }


    @Test
    public void Test() throws InterruptedException {

        //X path ile Giriş yap a tıklanır.

        WebElement signbtn= driver.findElement(By.xpath("/html/body/div[1]/header/div[3]/div/div/div/div[3]/div/div[1]/div[1]/div[2]"));
        signbtn.click();

        //X path ile Giriş yapın altında ki giriş butonuna tıklanır.

        driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);

        WebElement signbtn1= driver.findElement(By.xpath("/html/body/div[1]/header/div[3]/div/div/div/div[3]/div/div[1]/div[2]/div/div/div/a"));
        signbtn1.click();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        //Login sayfası kontrol

        String LogUrl=driver.getCurrentUrl();

        Assert.assertEquals("https://www.gittigidiyor.com/uye-girisi",LogUrl);


        // username girişi

        WebElement mailbutton= driver.findElement(By.id("L-UserNameField"));
        mailbutton.click();
        mailbutton.sendKeys("akinkazar9@gmail.com");//Your Mail


        // password girişi

        WebElement password = driver.findElement(By.id("L-PasswordField"));
        password.click();
        password.sendKeys("15754266916A");//Your Password
        driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);


        //Login buttonun bulunup tıklanması

        driver.findElement(By.id("gg-login-enter")).click();
        Thread.sleep(3000);
        String Kontroltitle=driver.getTitle();

        //Kontrol

        Assert.assertEquals("GittiGidiyor - Türkiye'nin Öncü Alışveriş Sitesi",Kontroltitle);

        // Search "Bilgisayar " yazılıp tıklanması.


        WebElement box = driver.findElement(By.xpath("/html/body/div[1]/header/div[3]/div/div/div/div[2]/form/div/div[1]/div[2]/input"));
        box.click();
        box.sendKeys("Bilgisayar");

        driver.findElement(By.xpath("/html/body/div[1]/header/div[3]/div/div/div/div[2]/form/div/div[2]/button")).click();
        Thread.sleep(3000);




        //2. Sayfaya geçiş



        Thread.sleep(3000);
        driver.findElement(By.xpath("/html/body/div[5]/div[2]/div/div/a/span")).click();
        WebElement sayfadegis=driver.findElement(By.xpath("/html/body/div[5]/div[1]/div/div[2]/div[5]/ul/li[2]/a"));
        sayfadegis.click();
        WebElement sayfakontrol =driver.findElement(By.cssSelector("a[class='current']"));
        String sayfa2=sayfakontrol.getText();
        Assert.assertEquals("2",sayfa2);
        Thread.sleep(3000);



        //Rastgele ürün seçilimi



        driver.findElement(By.xpath("/html/body/div[5]/div[1]/div/div[2]/div[3]/div[2]/ul/li[32]/a/div")).click();
        driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);



        //Seçilen ürünün Fiyatının tutulması


        WebElement secilenUrun = driver.findElement(By.cssSelector("div[id='sp-price-discountPrice']"));
        String urunFiyat=secilenUrun.getText();
        driver.manage().timeouts().implicitlyWait(45,TimeUnit.SECONDS);


        //Seçilen ürünün Sepete eklenmesi



        driver.findElement(By.cssSelector("button[id='add-to-basket']")).click();
        Thread.sleep(3000);

        //SEPETİM


        driver.findElement(By.cssSelector("a[class='dIB']")).click();



        //Sepetteki ürün fiyati


        WebElement Sepet = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div[1]/form/div/div[2]/div[2]/div[1]/div/div[6]/div[2]/div[2]/div[1]/div[5]/div[1]/div[2]/strong[2]"));
        String SepetFiyat =Sepet.getText();
        driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);



        //Fiyat Kıyaslaması


        Assert.assertEquals(urunFiyat,SepetFiyat);

        //Adet arttırımı...


        Thread.sleep(3000);
        WebElement Deger = driver.findElement(By.cssSelector("option[value='2']"));
        Deger.click();

        //Sepetteki ürün adedi kontrolu


        String deger2=Deger.getText();
        Assert.assertEquals("2",deger2);


        Thread.sleep(3000);

        //Sepetin Boşaltılması...



        driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div[1]/form/div/div[2]/div[2]/div/div/div[6]/div[2]/div[2]/div[1]/div[3]/div/div[2]/div/a/i")).click();
        driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);

        //Kontrol


        Thread.sleep(3000);
        String SepetKontrol=driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div[1]/form/div/div[2]/div[2]/div/div/div[1]/div[1]/div[1]/div/div[2]/h2")).getText();
        Assert.assertEquals("Sepetinizde ürün bulunmamaktadır.",SepetKontrol);
        Thread.sleep(3000);

    }
    @After
    public void Finish(){
        driver.manage().timeouts().implicitlyWait(45,TimeUnit.SECONDS);
        driver.quit();




    }













}
