package org.example.stepDefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.example.pages.HomePage;
import org.example.pages.OnlineProductsPage;


public class generalUserStepDef {

    private HomePage homePage;
    private OnlineProductsPage onlineProductsPage;

    public generalUserStepDef (){
        this.homePage = new HomePage();
        this.onlineProductsPage = new OnlineProductsPage();
    }

    @Given("user navigates to {string} online products page")
    public void userNavigatesToOnlineProductsPage(String url) {
        try {
            homePage.click_hamburger_menu(url);
        } catch (Exception e) {
            throw new RuntimeException("Failed to navigate to online products page: " + e.getMessage(), e);
        }

    }

//    @Given("user navigates to online products page")
//    public void user_navigates_to_online_products_page() {
//    }
    @When("User clicks on formal shoes dropdown")
    public void user_clicks_on_formal_shoes_dropdown() throws InterruptedException {
        homePage.click_onlineProducts_link();
       onlineProductsPage.click_formalshoesdropdown();
    }
    @Then("User should be able to view the products")
    public void user_should_be_able_to_view_the_products() {
        onlineProductsPage.getText_formalShoes_firstValue();
    }



    @When("user click on Online products link")
    public void userClickOnOnlineProductsLink() throws InterruptedException {

        try {
            homePage.click_onlineProducts_link();

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
