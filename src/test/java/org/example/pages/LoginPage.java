package org.example.pages;

import org.example.base.BddLibrary;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class LoginPage {



    @FindBy (xpath = "//*[@id='usr']")
    public WebElement userName;

    @FindBy (xpath = "//*[@id='pwd']")
    public WebElement password;

    @FindBy (xpath = "//*[@id='second_form']/input")
    public WebElement loginButton;

    @FindBy(linkText = "Sign In Portal")
    private static WebElement sign_In_LinkText;

    private WebDriver driver;
    private WebDriverWait wait;

    public LoginPage() {
        this.driver= BddLibrary.getDriver();
        this.wait = new WebDriverWait(this.driver, Duration.ofSeconds(5));
        PageFactory.initElements(this.driver,this);
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

    public boolean isSignInLinkVisible() {
        int attempts = 0;
        int maxAttempts = 5;
        while (attempts < maxAttempts) {
            try {
//                WebDriverWait wait = new WebDriverWait(this.driver, Duration.ofSeconds(2));
                wait.until(ExpectedConditions.visibilityOf(sign_In_LinkText));
                return true;
            } catch (Exception e) {
                attempts++;
                System.out.println("Attempt " + attempts + " to find Sign In link failed.");
            }
        }
        return false;
    }

    public void click_signIn_link() throws InterruptedException {
        System.out.println("Trying to click sign in link");
        if (isSignInLinkVisible()) {
            sign_In_LinkText.click();
            System.out.println("Sign in link clicked");
        } else {
            throw new RuntimeException("Sign In link not visible after multiple attempts");
        }
    }


}
