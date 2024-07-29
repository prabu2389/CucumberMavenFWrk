package pages;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import utilities.BrowserDriver;

public class HomePage extends BrowserDriver {
    //
    public static String hamburger_menu = "//*[@id=\"menuToggle\"]/input";
    public static String sign_In_LinkText = "Sign In Portal";
    public static String online_prodPageLinkText = "Online Products";

    public static void click_hamburger_menu() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://anupdamoda.github.io/AceOnlineShoePortal/index.html");
        driver.manage().window().maximize();
        Thread.sleep(2000);
        driver.findElement(By.xpath(hamburger_menu)).click();
    }

    public static void click_signIn_link() throws InterruptedException {
        Thread.sleep(2000);
        driver.findElement(By.linkText(sign_In_LinkText)).click();
    }

    public static void click_onlineProducts_link() throws InterruptedException {
        Thread.sleep(2000);
        driver.findElement(By.linkText(online_prodPageLinkText)).click();
    }
}
