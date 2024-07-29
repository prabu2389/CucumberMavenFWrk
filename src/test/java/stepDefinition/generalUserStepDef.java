package stepDefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import pages.HomePage;
import pages.OnlineProductsPage;


public class generalUserStepDef {
    @Given("user navigates to online products page")
    public void user_navigates_to_online_products_page() {
        try {
            HomePage.click_hamburger_menu();
            HomePage.click_onlineProducts_link();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    @When("User clicks on formal shoes dropdown")
    public void user_clicks_on_formal_shoes_dropdown() {
       OnlineProductsPage.click_formalshoesdropdown();
    }
    @Then("User should be able to view the products")
    public void user_should_be_able_to_view_the_products() {
        OnlineProductsPage.getText_formalShoes_firstValue();
    }
}
