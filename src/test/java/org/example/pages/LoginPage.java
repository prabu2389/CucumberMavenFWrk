package org.example.pages;

import org.example.base.BddLibrary;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v85.page.Page;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class LoginPage {


    @FindBy (xpath = "//*[@id='usr']")
    public WebElement userName;

    @FindBy (xpath = "//*[@id='pwd']")
    public WebElement password;

    @FindBy (xpath = "//*[@id='second_form']/input")
    public WebElement loginButton;

    private WebDriver driver;
    private WebDriverWait wait;

    public LoginPage() {
        this.driver= BddLibrary.getDriver();
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        PageFactory.initElements(driver,this);
    }

//    static Wait wait = new WebDriverWait(WebDriver driver, Duration 5);

    public void enterUsername() throws InterruptedException {
        Thread.sleep(2000);
        userName.sendKeys("scott.gale@gmail.com");
    }

    public void enterPassword() throws InterruptedException {
        Thread.sleep(2000);
        password.sendKeys("P@sword!");
    }

    public void clickLogin() throws InterruptedException {
        Thread.sleep(2000);
        loginButton.click();
    }


}
