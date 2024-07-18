import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumDemo {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\prabh\\OneDrive\\Documents\\BDD Files\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://www.google.com");
        System.out.println(driver.getTitle());
        driver.quit();

        driver.findElement(By.xpath("")).sendKeys("arab");

        //Dynamic xpaths

        // tagname[@attribute-name=’value1’]

        //tagname[@attribute1='value1'][@attribute2='value2']

        //Using Contains Method
        //tagname[contains(@attribute,'value')]

        //Using Starts with Method

        //tagname[starts-with(@id, '')]

        
    }
}
