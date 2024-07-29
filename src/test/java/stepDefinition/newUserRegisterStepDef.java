package stepDefinition;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.OnlineProductsPage;

import pages.HomePage.*;
import pages.LoginPage.*;
import pages.RegistrationPage;
import pages.RegistrationPage.*;


public class newUserRegisterStepDef {

    @When("User clicks on New Registration button")
    public void user_clicks_on_new_registration_button() throws InterruptedException {
        try {
            RegistrationPage.clickNewUserBtn();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    @Then("User should be able to view the Registration page")
    public void user_should_be_able_to_view_the_registration_page() throws InterruptedException {
        try {
            RegistrationPage.verifyNewUserRegistration();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
