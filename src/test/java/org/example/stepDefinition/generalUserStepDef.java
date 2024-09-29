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

    @Given("user navigates to online products page")
    public void user_navigates_to_online_products_page() {
        try {
            homePage.click_hamburger_menu();
            homePage.click_onlineProducts_link();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    @When("User clicks on formal shoes dropdown")
    public void user_clicks_on_formal_shoes_dropdown() {
       onlineProductsPage.click_formalshoesdropdown();
    }
    @Then("User should be able to view the products")
    public void user_should_be_able_to_view_the_products() {
        onlineProductsPage.getText_formalShoes_firstValue();
    }
}
