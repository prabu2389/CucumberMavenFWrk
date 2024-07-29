package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.BrowserDriver;

import java.time.Duration;

public class LoginPage extends BrowserDriver {
    public static String userName = "//*[@id='usr']";
    public static String password = "//*[@id='pwd']";
    public static String newUserButton = "//*[@id='NewRegistration']";
    public static String loginButton = "//*[@id='second_form']/input";

//    static Wait wait = new WebDriverWait(WebDriver driver, Duration 5);

    public static void enterUsername() throws InterruptedException {
        Thread.sleep(2000);
        driver.findElement(By.xpath(userName)).sendKeys("scott.gale@gmail.com");
    }

    public static void enterPassword() throws InterruptedException {
        Thread.sleep(2000);
        driver.findElement(By.xpath(password)).sendKeys("P@sword!");
    }

    public static void clickLogin() throws InterruptedException {
        Thread.sleep(2000);
        driver.findElement(By.xpath(loginButton)).click();
    }


}
