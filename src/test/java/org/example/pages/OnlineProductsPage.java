package org.example.pages;

import org.example.base.BddLibrary;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;


public class OnlineProductsPage {

    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy (xpath = "//*[@id='ShoeType'][contains(text(), 'Formal Shoes')]")
    public WebElement formalshoes;

    @FindBy (xpath = "//*[@id='ShoeType'][contains(text(), 'Sports')]")
    public WebElement sportsShoes;

    @FindBy (xpath = "//*[@id='ShoeType'][contains(text(), 'Sneakers')]")
    public WebElement sneakerShoes;

    @FindBy(className = "formalshoedropdown")
    public WebElement formalShoesDropdown;

    @FindBy (xpath = "/html/body/div[2]/table/tbody/tr[1]/td[1]")
    public WebElement formalShoesWebtable_tr;
//    public static String loginButton = "//*[@id='second_form']/input";


//    static Wait wait = new WebDriverWait(WebDriver driver, Duration 5);

    public OnlineProductsPage () {
        this.driver = BddLibrary.getDriver();
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        PageFactory.initElements(driver,this);
    }

    public void productCategoryFormalShoes() throws InterruptedException {
        String productCategoryFormalShoes = formalshoes.getText();
        Assert.assertEquals (productCategoryFormalShoes,"Formal Shoes");
        wait.until(ExpectedConditions.visibilityOf(formalshoes));
    }

    public void productCategorySportsShoes() throws InterruptedException {
        Thread.sleep(2000);
        String productCategorySportsShoes = sportsShoes.getText();
        Assert.assertEquals (productCategorySportsShoes,"Sports");
    }

    public void productCategorySneakerShoes() throws InterruptedException {
        Thread.sleep(2000);
        String productCategorySneakers = sneakerShoes.getText();
        Assert.assertEquals (productCategorySneakers,"Sneakers");
    }

    public void click_formalshoesdropdown() {
        formalShoesDropdown.click();
    }

    public void getText_formalShoes_firstValue() {
        String firstValue = formalShoesWebtable_tr.getText();
        Assert.assertEquals (firstValue,"   Classic Cheltenham");
    }

}
