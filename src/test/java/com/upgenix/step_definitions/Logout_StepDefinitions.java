package com.upgenix.step_definitions;

import com.upgenix.pages.LogoutPage;
import com.upgenix.utilities.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class Logout_StepDefinitions {

    LogoutPage logoutPage = new LogoutPage();

    @When("User click on the profile icon")
    public void user_click_on_the_profile_icon() {
        logoutPage.profileIcon.click();
    }
    @When("User verify that Log out link is visible")
    public void user_verify_that_log_out_link_is_visible() {
        Assert.assertTrue(logoutPage.logoutLink.isDisplayed());
    }
    @When("User clicks on the Log out link")
    public void user_clicks_on_the_log_out_link() {
        logoutPage.logoutLink.click();
    }
    @Then("User verify that Log out is successful and the title contains {string}")
    public void user_verify_that_log_out_is_successful_and_the_title_contains(String string) {
        Assert.assertTrue(Driver.getDriver().getTitle().contains(string));
    }

    @Then("User clicks to step back button and sees the {string} message")
    public void user_clicks_to_step_back_button_and_sees_the_message(String string) {
        Driver.getDriver().navigate().back();
        Assert.assertTrue(logoutPage.expiredMessage.isDisplayed());
    }

}
