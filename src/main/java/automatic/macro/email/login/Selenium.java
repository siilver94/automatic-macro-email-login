import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
 
public class SeleniumTest {
 
    public static void main(String[] args) {
 
        SeleniumTest selTest = new SeleniumTest();
        selTest.crawl();
        
    }
 
    
    private WebDriver driver;
    
    private WebElement webElement;
    
    public static final String WEB_DRIVER_ID = "webdriver.chrome.driver";
    public static final String WEB_DRIVER_PATH = "D:\\selenium\\chromedriver.exe";
    
    private String base_url;
    
    public SeleniumTest() {
        super();
 
        System.setProperty(WEB_DRIVER_ID, WEB_DRIVER_PATH);
        
                
         ChromeOptions options = new ChromeOptions();
         options.setCapability("ignoreProtectedModeSettings", true);
         driver = new ChromeDriver(options);
        
        base_url = "https://logins.daum.net/accounts/signinform.do?url=https%3A%2F%2Fwww.daum.net%2F";
        
        
        
    }
 
    public void crawl() {
 
        try {
            driver.get(base_url);
	 
            
            webElement = driver.findElement(By.id("id"));
            String website_id =" ";
            webElement.sendKeys(website_id);
            Thread.sleep(1000);
            
            webElement = driver.findElement(By.id("inputPwd"));
            String website_pw =" ";
            webElement.sendKeys(website_pw);
            Thread.sleep(1000);

         
            webElement = driver.findElement(By.id("loginBtn"));
            webElement.submit();
            Thread.sleep(1000);

            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            
            webElement = driver.findElement(By.xpath("//*[@id=\"mArticle\"]/div[1]/div[2]/ul/li[1]/em/a"));
            String mailCnt = webElement.getText();
            
            System.out.println("메일의 갯수 : " + mailCnt);
            
    
        } catch (Exception e) {
            
            e.printStackTrace();
        
        } finally {
 
            //driver.close();
        }
 
    }
 
}
