package com.revature.steps;

import com.revature.TestRunner;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MoonDeletionSteps {
    @Given("the user has logged in")
    public void the_user_has_logged_in()
    {
        TestRunner.loginPage.setUpLoggedInUser();
    } 

    @Given("the user is on the home page")
    public void the_user_is_on_the_home_page()
    {
        TestRunner.homePage.getHomePageGreeting();
    }

    @When("the user provides a valid moon name")
    public void the_user_provides_a_valid_moon_name() {
        TestRunner.homePage.enterMoonName("Pr0spit_ 1025");
    }

    @When("the user deletes a moon")
    public void the_user_deletes_a_moon()
    {
        TestRunner.homePage.deleteCelestialBody();
    }
}
