
package test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Enter {

    private final Object lock = new Object ();
    static WebDriver driver;
    static Cookie cookie1, cookie2, cookie3;




    @BeforeClass
    public static void setup () {
        WebDriverManager.chromedriver ().setup ();
        driver = new ChromeDriver ();
    }

//    @AfterClass
//    public static void cleanup () {
//        driver.quit ();
//    }

    @Test
    public void login () throws InterruptedException {
        driver.navigate ().to ("https://accounts.ukr.net/");
        driver.findElement (By.id ("id-l")).sendKeys ("yevgeniy.shevchuk" + Keys.ENTER);
        Thread.sleep (1000);
        driver.findElement (By.id ("id-p")).sendKeys ("vasilkov" + Keys.ENTER);
        driver.findElement (By.cssSelector (".button")).click ();
        cookie1 = (Cookie) driver.manage ().getCookieNamed ("freemail");
        cookie2 = (Cookie) driver.manage ().getCookieNamed ("sid");
        cookie3 = (Cookie) driver.manage ().getCookieNamed ("as");
        System.out.println("Cookie as " + driver.manage ().getCookieNamed ("freemail"));
        System.out.println("Cookie sid " + cookie2.toString ());
//        System.out.println("Cookie freemail " + cookie3.toString ());

        driver.manage ().deleteAllCookies ();

        driver.navigate ().to ("https://mail.ukr.net/");
        driver.manage ().deleteAllCookies ();

        Thread.sleep (1000);
        driver.navigate ().refresh ();
        driver.quit ();
        Thread.sleep (4000);
        driver = new ChromeDriver ();
        driver.navigate ().to ("https://mail.ukr.net/");


        driver.manage().addCookie(new Cookie("freemail", cookie1.toString ()));
        driver.manage().addCookie(new Cookie("sid", cookie2.toString ()));
        //driver.manage().addCookie(new Cookie("as", cookie3.toString ()));

        Thread.sleep (6000);
    }

    ;
};
