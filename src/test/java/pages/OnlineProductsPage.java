package pages;

import org.openqa.selenium.By;
import utilities.BrowserDriver;

import static junit.framework.Assert.assertEquals;

public class OnlineProductsPage extends BrowserDriver {

    public static String formalshoes= "//*[@id='ShoeType'][contains(text(), 'Formal Shoes')]";
    public static String sportsShoes = "//*[@id='ShoeType'][contains(text(), 'Sports')]";
    public static String sneakerShoes = "//*[@id='ShoeType'][contains(text(), 'Sneakers')]";
    public static String loginButton = "//*[@id='second_form']/input";

    public static String formalShoesDropdown = "formalshoedropdown";
    public static String formalShoesWebtable = "/html/body/div[2]/table";
    public static String formalShoesWebtable_tr = "/html/body/div[2]/table/tbody/tr[1]/td[1]";
//    static Wait wait = new WebDriverWait(WebDriver driver, Duration 5);

    public static void productCategoryFormalShoes() throws InterruptedException {
        String productCategoryFormalShoes = driver.findElement(By.xpath(formalshoes)).getText();
        assertEquals (productCategoryFormalShoes,"Formal Shoes");
        Thread.sleep(2000);

    }

    public static void productCategorySportsShoes() throws InterruptedException {
        Thread.sleep(2000);
        String productCategorySportsShoes = driver.findElement(By.xpath(sportsShoes)).getText();
        assertEquals (productCategorySportsShoes,"Sports");
    }

    public static void productCategorySneakerShoes() throws InterruptedException {
        Thread.sleep(2000);
        String productCategorySneakers = driver.findElement(By.xpath(sneakerShoes)).getText();
        assertEquals (productCategorySneakers,"Sneakers");
    }

    public static void click_formalshoesdropdown() {
        driver.findElement(By.className(formalShoesDropdown)).click();
    }

    public static void getText_formalShoes_firstValue() {
        String firstValue = driver.findElement(By.xpath(formalShoesWebtable_tr)).getText();
        assertEquals (firstValue,"   Classic Cheltenham");
    }

}
