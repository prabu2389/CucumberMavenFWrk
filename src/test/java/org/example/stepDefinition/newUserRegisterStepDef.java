package org.example.stepDefinition;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.example.base.BddLibrary;
import org.example.pages.RegistrationPage;
import org.openqa.selenium.WebDriver;


public class newUserRegisterStepDef {

    private WebDriver driver;
    private RegistrationPage registrationPage;

    public newUserRegisterStepDef() {
        this.driver = BddLibrary.getDriver();
        this.registrationPage = new RegistrationPage(driver);
    }

    @When("User clicks on New Registration button")
    public void user_clicks_on_new_registration_button() throws InterruptedException {
        try {
            registrationPage.clickNewUserBtn();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    @Then("User should be able to view the Registration page")
    public void user_should_be_able_to_view_the_registration_page() throws InterruptedException {
        try {
            registrationPage.verifyNewUserRegistration();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
