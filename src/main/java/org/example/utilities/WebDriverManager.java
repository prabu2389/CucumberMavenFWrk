package org.example.utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverManager {
    private static WebDriver driver;

    public static WebDriver getDriver () {
        if (driver==null){
            String browser = ConfigReader.getProperty("browser");
            switch (browser.toLowerCase()){
                case "chrome" :
                    System.setProperty("webdriver.chrome.driver","");
                    driver = new ChromeDriver();
                    break;

                case "firefox" :
                    System.setProperty("webdriver.gecko.driver","");
                    driver = new FirefoxDriver();
                    break;

                default:
                    throw new RuntimeException("Unsupported Browser: " +browser);
            }
        }
        return driver;
    }

    public static void quitDriver () {
        if (driver!= null){
            driver.quit();
            driver = null;
        }
    }
}
