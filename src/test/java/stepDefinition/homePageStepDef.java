package stepDefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.OnlineProductsPage;

import static pages.HomePage.*;
import static pages.LoginPage.*;

public class homePageStepDef {
    @Given("^user navigates to the login page")
    public void user_navigates_to_the_login_page(){

        try {
            click_hamburger_menu();
            click_signIn_link();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @When("User successfully enters the login details")
    public void user_successfully_enters_the_login_details() throws InterruptedException {
        try {
            enterUsername();
            enterPassword();
            clickLogin();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
    @Then("User should be able to view the product category page")
    public void user_should_be_able_to_view_the_product_category_page() throws InterruptedException {
        OnlineProductsPage.productCategoryFormalShoes();
        OnlineProductsPage.productCategorySportsShoes();
        OnlineProductsPage.productCategorySneakerShoes();

    }
}
