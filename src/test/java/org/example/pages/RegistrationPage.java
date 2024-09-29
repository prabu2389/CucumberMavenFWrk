package org.example.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import java.time.Duration;

public class RegistrationPage {
//
//    public static String newUserFirstName = "//*[@id='firstname']";
//    public static String newUserLastName = "//*[@id='lastname']";
//    public static String newUserEmailID = "//*[@id='emailId']";
//    public static String newUserContactNum = "//*[@id='contactNumber']";
//    public static String newUserUserName = "//*[@id='usr']";
//    public static String newUserPassword = "//*[@id='pwd']";
//    public static String newUserButton = "btn btn-primary";
//

    @FindBy(xpath = "//*[@id='NewRegistration']")
    public WebElement newUserRegisterBtn;

    @FindBy(xpath = "/html/body/center/h1")
    public WebElement newUserRegisterTitle;

    private WebDriver driver;
    private WebDriverWait wait;

    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        PageFactory.initElements(driver,this);
    }

    public void clickNewUserBtn() throws InterruptedException {
        newUserRegisterBtn.click();
        Thread.sleep(2000);
    }

    public void verifyNewUserRegistration () throws InterruptedException {

        String actualTitle = newUserRegisterTitle.getText();
        Assert.assertEquals(actualTitle, "User Registration Page");
        Thread.sleep(2000);
    }
}
