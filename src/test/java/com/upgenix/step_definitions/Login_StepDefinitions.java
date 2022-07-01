package com.upgenix.step_definitions;

import com.upgenix.pages.LoginPage;
import com.upgenix.utilities.ConfigurationReader;
import com.upgenix.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Login_StepDefinitions {

    LoginPage loginPage = new LoginPage();

    @Given("User is on the upgenix login page")
    public void user_is_on_the_upgenix_login_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("upgenix.url"));
    }

    @When("Salesmanager enters valid email {string} and password {string}")
    public void salesmanager_enters_valid_email_and_password(String email, String password) {
        loginPage.email.sendKeys(email);
        loginPage.password.sendKeys(password);

    }
    @When("Salesmanager-Posmanager clicks the login button")
    public void salesmanager_posmanager_clicks_the_login_button() {
        loginPage.loginButton.click();
    }
    @Then("Salesmanager login successfully verify that title contains {string}")
    public void salesmanager_login_successfully_verify_that_title_contains(String string) {
        Assert.assertTrue(Driver.getDriver().getTitle().contains(string));
    }

    @When("Posmanager enters valid email {string} and password {string}")
    public void posmanager_enters_valid_email_and_password(String email, String password) {
        loginPage.email.sendKeys(email);
        loginPage.password.sendKeys(password);
    }
    @Then("Posmanager login successfully verify that title contains {string}")
    public void posmanager_login_successfully_verify_that_title_contains(String string) {
        Assert.assertTrue(Driver.getDriver().getTitle().contains(string));
    }

    @Given("Posmanager enters valid email {string} and invalid password {string}")
    public void posmanager_enters_valid_email_and_invalid_password(String email, String password) {
        loginPage.email.sendKeys(email);
        loginPage.password.sendKeys(password);
    }
    @Then("Salesmanager-Posmanager sees {string} text above the {string} button")
    public void salesmanager_posmanager_sees_text_above_the_button(String email, String password) {
        Assert.assertTrue(loginPage.errorMessage.isDisplayed());
    }

    @Given("Salesmanager enters invalid email {string} and valid password {string}")
    public void salesmanager_enters_invalid_email_and_valid_password(String email, String password) {
        loginPage.email.sendKeys(email);
        loginPage.password.sendKeys(password);
    }

    @Given("Posmanager enters invalid email {string} and valid password {string}")
    public void posmanager_enters_invalid_email_and_valid_password(String email, String password) {
        loginPage.email.sendKeys(email);
        loginPage.password.sendKeys(password);
    }

    @Given("Salesmanager enters valid email {string} and invalid password {string}")
    public void salesmanager_enters_valid_email_and_invalid_password(String email, String password) {
        loginPage.email.sendKeys(email);
        loginPage.password.sendKeys(password);
    }

    @Then("Please fill out this field message should be displayed")
    public void please_fill_out_this_field_message_should_be_displayed() {

        Assert.assertTrue(loginPage.email.getAttribute("validationMessage").equalsIgnoreCase("Please fill out this field."));

    }

    @Given("Salesmanager-Posmanager clicks on the reset password link")
    public void salesmanager_posmanager_clicks_on_the_reset_password_link() {
        loginPage.resetPassword.click();
    }
    @Then("Salesmanager-posmanager sees {string} in the title")
    public void salesmanager_posmanager_sees_in_the_title(String string) {
        Assert.assertTrue(Driver.getDriver().getTitle().contains(string));
    }

    @When("Posmanager enters valid email {string} - password {string} and hits enter")
    public void posmanager_enters_valid_email_password_and_hits_enter(String email, String password) {
        loginPage.email.sendKeys(email);
        loginPage.password.sendKeys(password+ Keys.ENTER);
    }

    @Then("Salesmanager-Posmanager sees the bullet signs while writing the password")
    public void salesmanager_posmanager_sees_the_bullet_signs_while_writing_the_password() {
        Assert.assertTrue(loginPage.password.getAttribute("type").equals("password"));
    }





}
