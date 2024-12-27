package com.revature.steps;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.revature.TestRunner;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ViewSteps {

    @Given("the user is logged in")
    public void the_user_is_logged_in() {
        TestRunner.loginPage.setUpLoggedInUser();
    }

    @Given("the user is on the home page")
    public void the_user_is_on_the_home_page()
    {
        Assert.assertEquals("Home", TestRunner.driver.getTitle());
    }

    @Given("the user is on the login page")
    public void the_user_is_on_the_login_page()
    {
        TestRunner.loginPage.openLoginPage();
    }

    @When("the user tries to go to the home page directly")
    public void the_user_tries_to_go_to_the_home_page_directly() 
    {
        TestRunner.homePage.tryToAccessHomePageDirectly();
    }

    @Then("the user should see all of the planets and moons that they have created and they created only")
    public void the_user_should_see_all_of_the_planets_and_moons_that_they_have_created_and_they_created_only()
    {
        TestRunner.wait.until(ExpectedConditions.titleIs("Home"));
        Assert.assertEquals(
            String.format(
                    "Expected 'Welcome to the Home Page Batman, but got %s",
                    TestRunner.homePage.getHomePageGreeting()
            ),
            "Welcome to the Home Page Batman",
            TestRunner.homePage.getHomePageGreeting());
        Assert.assertEquals(4, TestRunner.homePage.getNumberOfCelestialRows());
       
    }

    @Then("the user should not access the home page")
    public void the_user_should_not_access_the_home_page()
    {
        Assert.assertNotEquals("Please log in first",
         TestRunner.driver.findElement(By.cssSelector("pre")));
    }

}