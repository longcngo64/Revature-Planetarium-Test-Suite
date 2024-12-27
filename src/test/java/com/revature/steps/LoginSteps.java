package com.revature.steps;

import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.revature.TestRunner;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps {

    @Given("the user is on the login page")
    public void the_user_is_on_the_login_page() {
        TestRunner.loginPage.openLoginPage();
    }

    @When("the user provides a username, {string}")
    public void the_user_provides_a_username(String username) {
        TestRunner.loginPage.enterUsername(username);
    }
    @When("the user provides a password, {string}")
    public void the_user_provides_a_password(String password) {
        TestRunner.loginPage.enterPassword(password);
    }
    @When("the user submits the credentials to login")
    public void the_user_submits_the_credentials_to_login() {
        TestRunner.loginPage.submitCredentials();
    }

    @When("the user logout")
    public void the_user_logout()
    {
        TestRunner.homePage.logout();
    }

    @Then("the user should be go to the home page on successful login")
    public void the_user_should_be_go_to_the_home_page_on_successful_login() 
    {
        TestRunner.wait.until(ExpectedConditions.not(ExpectedConditions.titleIs("Planetarium Login")));
        Assert.assertEquals("Home", TestRunner.driver.getTitle());
    }

    @Then("the user should get a browser alert {string}")
    public void the_user_should_get_a_browser_alert(String alertString) 
    {
        TestRunner.wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = TestRunner.driver.switchTo().alert();
        Assert.assertEquals(alertString, alert.getText());
        alert.accept();
    }

    @Then("the user should be redirected back to the login page")
    public void the_user_should_be_redirected_to_the_login_page() 
    {
        TestRunner.wait.until(ExpectedConditions.not(ExpectedConditions.titleIs("Account Creation")));
        Assert.assertEquals("Planetarium Login", TestRunner.driver.getTitle());
    }

    @Then("the user should see a greeting for them with their name, {string}")
    public void the_user_should_see_a_greeting_for_them_with_their_name(String username)
    {
        Assert.assertEquals(String.format("Welcome to the Home Page %s", username), 
        TestRunner.homePage.getHomePageGreeting());
    }

    @Then("the user should stay at the login page")
    public void the_user_should_stay_at_the_login_page() {
        Assert.assertEquals("Planetarium Login", TestRunner.driver.getTitle());
    }

}

