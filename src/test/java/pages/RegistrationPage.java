package pages;

import org.openqa.selenium.By;
import utilities.BrowserDriver;

import static junit.framework.Assert.assertEquals;

public class RegistrationPage extends BrowserDriver {
    public static String newUserRegisterBtn = "//*[@id='NewRegistration']";
    public static String newUserFirstName = "//*[@id='firstname']";
    public static String newUserLastName = "//*[@id='lastname']";
    public static String newUserEmailID = "//*[@id='emailId']";
    public static String newUserContactNum = "//*[@id='contactNumber']";
    public static String newUserUserName = "//*[@id='usr']";
    public static String newUserPassword = "//*[@id='pwd']";
    public static String newUserButton = "btn btn-primary";
    public static String newUserRegisterTitle = "/html/body/center/h1";

    public static void clickNewUserBtn() throws InterruptedException {
        driver.findElement(By.xpath(newUserRegisterBtn)).click();
        Thread.sleep(2000);
    }

    public static void verifyNewUserRegistration () throws InterruptedException {

        String actualTitle = driver.findElement(By.xpath(newUserRegisterTitle)).getText();
        assertEquals(actualTitle, "User Registration Page");
        Thread.sleep(2000);
    }
}
