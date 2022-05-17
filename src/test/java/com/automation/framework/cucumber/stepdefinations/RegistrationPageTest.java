package com.automation.framework.cucumber.stepdefinations;

import com.automation.framework.cucumber.utils.Waits;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

import static com.automation.framework.cucumber.constants.Constants.*;
import static com.automation.framework.cucumber.constants.CredentialsConstants.*;
import static com.automation.framework.cucumber.setup.InitializeDriver.driver;

public class RegistrationPageTest {

    @When("I click the Account tab Registration Page should display")
    public void i_click_the_account_tab_registration_page_should_display() {
        Waits.forLoading(50);
        HOME_PAGE.ClickAccountMenu();
        Waits.implicitWait(15);
    }

    @Then("Click Register button without entering any value")
    public void click_register_button_without_entering_any_value() {
        REGISTRATION_PAGE.clickRegisterButton();
    }


    @Then("Click Register button after entering a sample userName and leaving mail and password empty")
    public void click_register_button_after_entering_a_sample_user_name_and_leaving_mail_and_password_empty() {
        REGISTRATION_PAGE.enterUserName(USER_NAME);
        REGISTRATION_PAGE.clickRegisterButton();
    }
    @Then("Click Register button after entering a sample emailAddress and leaving userName and password empty")
    public void click_register_button_after_entering_a_sample_email_address_and_leaving_user_name_and_password_empty() {
        REGISTRATION_PAGE.enterEmail(EMAIL_ID);
        REGISTRATION_PAGE.clickRegisterButton();
    }

    @Then("Click Register button after entering a sample invalid emailAddress")
    public void click_register_button_after_entering_a_sample_invalid_email_address() {
        REGISTRATION_PAGE.enterEmail(USER_NAME);
        REGISTRATION_PAGE.clickRegisterButton();
    }

    @Then("Click Register button after entering a sample invalid emailAddress by adding @ and excluding .com")
    public void click_register_button_after_entering_a_sample_invalid_email_address_by_adding_and_excluding_com() {
        driver.navigate().refresh();
        REGISTRATION_PAGE.enterEmail(USER_NAME+"@");
        REGISTRATION_PAGE.clickRegisterButton();
    }

    @Then("Click Register button after entering a sample valid emailAddress but ending with @")
    public void click_register_button_after_entering_a_sample_valid_email_address_but_ending_with() {
        driver.navigate().refresh();
        REGISTRATION_PAGE.enterEmail(EMAIL_ID+"@");
        REGISTRATION_PAGE.clickRegisterButton();
    }

    @Then("Click Register button after entering a sample valid emailAddress valid emailAddress and valid userName by leaving the password field empty")
    public void click_register_button_after_entering_a_sample_valid_email_address_valid_email_address_and_valid_user_name_by_leaving_the_password_field_empty() {
        REGISTRATION_PAGE.enterUserName(USER_NAME);
        REGISTRATION_PAGE.enterEmail(EMAIL_ID);
        REGISTRATION_PAGE.clickRegisterButton();
    }

    @Then("Click Register button after entering an already registered user name and unregistered email id")
    public void  click_register_button_after_entering_an_already_registered_user_name_and_unregistered_email_id() {
        // Write code here that turns the phrase above into concrete actions
        REGISTRATION_PAGE.enterUserName(REGISTERED_USER_NAME);
        REGISTRATION_PAGE.enterEmail(EMAIL_ID);
        REGISTRATION_PAGE.clickRegisterButton();
    }

    @Then("Click Register button after entering an already registered email id and new username")
    public void click_register_button_after_entering_an_already_registered_email_id_and_new_username() {
        REGISTRATION_PAGE.enterUserName(USER_NAME);
        REGISTRATION_PAGE.enterEmail(REGISTERED_EMAIL_ADDRESS);
        REGISTRATION_PAGE.clickRegisterButton();
    }
    @Then("Click Register button after entering a new email id and new username")
    public void click_register_button_after_entering_a_new_email_id_and_new_username() {
        REGISTRATION_PAGE.enterUserName(USER_NAME);
        REGISTRATION_PAGE.enterEmail(EMAIL_ID);
        REGISTRATION_PAGE.enterPassword(VALID_PASSWORD);
        REGISTRATION_PAGE.clickRegisterButton();
    }
    @And("An Hello Message should display after successful registration in Account Dashboard page")
    public void an_hello_message_should_display_after_successful_registration_in_account_dashboard_page() {
        Assert.assertTrue(USER_ACCOUNT_PAGE.getUserName());
        USER_ACCOUNT_PAGE.clickLogOutButton();
    }

    @And("UserName Should not display")
    public void userName_Should_not_display() {
        Assert.assertTrue(USER_ACCOUNT_PAGE.userNameNotFound());
    }

    @And("An error message {string} Should display")
    public void an_error_message_should_display(String actualErrorMessage) {
        Assert.assertEquals(actualErrorMessage,REGISTRATION_PAGE.getErrorMessage());
    }
}