package org.example.base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.example.utilities.ConfigReader;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

public class BddLibrary {
    private static final Logger LOGGER = Logger.getLogger(BddLibrary.class.getName());
    private static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();
//    private static WebDriver driver;

    private BddLibrary() {}

    public static WebDriver getDriver() {
        if (tlDriver.get() == null) {
            initializeDriver();
        }
        return tlDriver.get();
    }

    public static void initializeDriver () {
        String browser = ConfigReader.getProperty("browser");
        boolean headless = Boolean.parseBoolean(ConfigReader.getProperty("headless"));
        WebDriver driver;
        try {
            switch (browser.toLowerCase()) {
                case "chrome":
//                    System.setProperty("webdriver.chrome.driver",
//                            "src/main/java/org/example/utilities/drivers/chromedriver.exe");
                    WebDriverManager.chromedriver().setup();
                    ChromeOptions chromeOptions = new ChromeOptions();
                    if (headless) chromeOptions.addArguments("--headless");
                    driver = new ChromeDriver(chromeOptions);
                    break;
                case "firefox":
//                    System.setProperty("webdriver.gecko.driver", "path/to/geckodriver");
                    WebDriverManager.firefoxdriver().setup();
                    FirefoxOptions firefoxOptions = new FirefoxOptions();
                    if (headless) firefoxOptions.addArguments("--headless");
                    driver = new FirefoxDriver(firefoxOptions);
                    break;
                default:
                    throw new RuntimeException("Unsupported browser: " + browser);
            }
            driver.manage().window().maximize();
            driver.manage().deleteAllCookies();
            driver.manage().timeouts().implicitlyWait(Long.parseLong(ConfigReader.getProperty("implicit.wait")), TimeUnit.SECONDS);
            tlDriver.set(driver);
        LOGGER.info("Driver initialized successfully: " + browser);
    } catch (Exception e) {
        LOGGER.severe("Failed to initialize driver: " + e.getMessage());
        throw new RuntimeException("Failed to initialize driver", e);
    }
    }

    public static void quitDriver() {
        WebDriver driver = tlDriver.get();
        if (driver != null) {
            driver.quit();
            tlDriver.remove();
            LOGGER.info("Driver quit successfully");
        }
    }

    public static void navigateToUrl(String url) {
        getDriver().get(url);
        LOGGER.info("Navigated to URL: " + url);
    }

    public static String takeScreenshot(String screenshotName) {
        String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        TakesScreenshot ts = (TakesScreenshot) getDriver();
        File source = ts.getScreenshotAs(OutputType.FILE);
        String destination = System.getProperty("user.dir") + "/Screenshots/" + screenshotName + dateName + ".png";
        File finalDestination = new File(destination);
        try {
            FileUtils.copyFile(source, finalDestination);
            LOGGER.info("Screenshot taken: " + destination);
        } catch (IOException e) {
            LOGGER.warning("Failed to take screenshot: " + e.getMessage());
        }
        return destination;
    }
}
