package org.example.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.example.base.BddLibrary;

import java.time.Duration;

public class HomePage {

    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(xpath = "//*[@id=\"menuToggle\"]/input")
    private WebElement hamburger_menu;

    @FindBy(linkText = "Sign In Portal")
    private static WebElement sign_In_LinkText;

    @FindBy(linkText = "Online Products")
    private WebElement online_prodPageLinkText;

    public HomePage() {
        this.driver = BddLibrary.getDriver();
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        PageFactory.initElements(driver,this);
    }

    public void click_hamburger_menu() throws InterruptedException {
//        WebDriverManager.chromedriver().setup();
//        BrowserDriver.driver = new ChromeDriver();
        driver.get("https://anupdamoda.github.io/AceOnlineShoePortal/index.html");
        hamburger_menu.click();

    }

    public void click_signIn_link() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOf(sign_In_LinkText));
        sign_In_LinkText.click();
    }

    public void click_onlineProducts_link() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOf(online_prodPageLinkText));
        online_prodPageLinkText.click();
    }
}
