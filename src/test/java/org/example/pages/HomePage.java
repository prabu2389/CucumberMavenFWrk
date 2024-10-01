package org.example.pages;

import org.example.pageLocators.HomePageLocators;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.example.base.BddLibrary;

import java.time.Duration;
import java.util.logging.Logger;

public class HomePage {

    private static final Logger LOGGER = Logger.getLogger(HomePage.class.getName());
    private WebDriver driver;
    private WebDriverWait wait;

    private HomePageLocators homePageLocators;


    public HomePage() {
        this.driver = BddLibrary.getDriver();
        homePageLocators = new HomePageLocators();
        this.wait = new WebDriverWait(this.driver, Duration.ofSeconds(10));
        PageFactory.initElements(this.driver,this.homePageLocators);
    }

    public void click_hamburger_menu(String url) throws InterruptedException {

        try {
            this.driver.get(url);
//            wait.until(ExpectedConditions.visibilityOf(hamburger_menu));
            homePageLocators.hamburger_menu.click();
            /* hamburger_menu.click(); */
            LOGGER.info("Clicked hamburger menu successfully");
        } catch (Exception e) {
            LOGGER.severe("Failed to click hamburger menu: " + e.getMessage());
            throw e;
        }
    }

    public void click_onlineProducts_link() throws InterruptedException {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(homePageLocators.online_prodPageLinkText)).click();
            LOGGER.info("Clicked online products link successfully");
        } catch (Exception e) {
            LOGGER.severe("Failed to click online products link: " + e.getMessage());
            throw e;
        }
    }
}
