package Base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BaseClass {
    public static WebDriver driver;
    public static WebDriverWait wait;

    public static void initializeBrowser(String browser){
        if(browser.equalsIgnoreCase("Chrome")){
            WebDriverManager.chromedriver().setup();
            driver=new ChromeDriver();
        }
        else if(browser.equalsIgnoreCase("firefox")){
            WebDriverManager.firefoxdriver().setup();
            driver=new FirefoxDriver();
        }
        else if(browser.equalsIgnoreCase("edge")){
            WebDriverManager.edgedriver().setup();
            driver=new EdgeDriver();
        }
        else{
            throw new IllegalArgumentException("Browser not found");
        }
    }
    public static void launchBrowser(String url){
        driver.get(url);
    }
    public static void windowMax(){
        driver.manage().window().maximize();
    }
    public static void waitImplicitly(){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
    public static void jsClick(WebElement element, WebDriver driver ){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click():",element);
    }
    public static void log(String text){
        System.out.println(text);
    }
    public static void quit(){
        driver.quit();
    }
}
