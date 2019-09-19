package java;

 import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;




    public class Driver {

        private String arguments;

        public enum Browser {
            CHROME,
            FIREFOX,
            OPERA
        }

        ;


        public static WebDriver getDriver(Browser browser, String arguments) {
            WebDriver driver;

            {

                switch (browser) {
                    case CHROME:
                        WebDriverManager.chromedriver().setup();
                        ChromeOptions options = new ChromeOptions();
                        options.addArguments("start-fullscreen");
                        WebDriver driverChrome = new ChromeDriver(options);
                        return driverChrome;

                    case FIREFOX:
                        WebDriverManager.firefoxdriver().setup();
                        WebDriver driverFirefox = new FirefoxDriver();
                        driverFirefox.manage().window().maximize();
                        return driverFirefox;


                    case OPERA:
                        WebDriverManager.operadriver().setup();
                        WebDriver driverOpera = new OperaDriver();
                        return driverOpera;


                }
                ;
            }
            return null;
        };

        public static void main (String[] args) {
            String baseURL = "https://www.ukr.net/ua/";

            for (Browser browser : Browser.values ()) {
                System.out.println (browser.toString ());
                WebDriver driver = Driver.getDriver (browser, "full-screen");
                driver.get (baseURL);
                driver.quit ();
            }
        }


    };

