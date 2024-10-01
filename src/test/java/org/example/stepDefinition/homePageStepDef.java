package org.example.stepDefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.base.BddLibrary;
import org.example.pages.HomePage;
import org.example.pages.LoginPage;
import org.example.pages.OnlineProductsPage;
import org.openqa.selenium.WebDriver;

public class homePageStepDef {

    private HomePage homePage;
    private LoginPage loginPage;
//    private WebDriver driver;
    private OnlineProductsPage onlinePage;

    public homePageStepDef() {
//        this.driver = BddLibrary.getDriver();
        this.homePage = new HomePage();
        this.loginPage = new LoginPage();
        this.onlinePage = new OnlineProductsPage();
    }

    @Given("^user navigates to the login page")
    public void user_navigates_to_the_login_page(String url){

        try {
            homePage.click_hamburger_menu(url);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @When("User successfully enters the login details")
    public void user_successfully_enters_the_login_details() throws InterruptedException {
        try {
            loginPage.click_signIn_link();
            loginPage.enterUsername();
            loginPage.enterPassword();
            loginPage.clickLogin();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
    @Then("User should be able to view the product category page")
    public void user_should_be_able_to_view_the_product_category_page() throws InterruptedException {
        onlinePage.productCategoryFormalShoes();
        onlinePage.productCategorySportsShoes();
        onlinePage.productCategorySneakerShoes();

    }
}
