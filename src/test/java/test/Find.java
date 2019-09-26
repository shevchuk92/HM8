package test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Find {
    private final Object lock = new Object();
    static WebDriver driver;

    @BeforeClass
    public static void setup () {
        WebDriverManager.chromedriver ().setup ();
        driver = new ChromeDriver ();
    }

    @AfterClass
    public static void cleanup () {
        driver.quit ();
    }

    @Test
    public void one () throws InterruptedException {
        driver.navigate ().to ("https://accounts.ukr.net");
        driver.findElement (By.id ("id-l")).sendKeys ("yevgeniy.shevchuk" + Keys.ENTER);
        Thread.sleep (2000);
        driver.findElement (By.cssSelector ("body > div > div > main > form > div.checkbox.form__checkbox"));
        driver.findElement (By.linkText ("(044) 235-85-55"));
        driver.findElement (By.xpath ("/html/body/div/div/footer/div[1]/div/h4"));
        driver.findElement (By.tagName ("div"));
    }
}