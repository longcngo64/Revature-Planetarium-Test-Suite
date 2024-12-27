package com.revature.steps;

import org.junit.Assert;

import com.revature.TestRunner;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class MoonCreationSteps
{
    @When("the user selects the moon option")
    public void the_user_selects_the_moon_option()
    {
        TestRunner.homePage.selectCelestialBody("moon");
    }

    @When("the user provides a moon name {string}")
    public void the_user_provides_a_moon_name(String moonName)
    {
        TestRunner.homePage.enterMoonName(moonName);
    }
    
    @When("the user provides a planet id {string}")
    public void the_user_provides_a_planet_id(String planetID)
    {
        TestRunner.homePage.enterPlanetID(planetID);
    }

    @When("the user optionally provides a moon image file with a filetype {string}")
    public void the_user_optionally_provides_a_moon_image_file_with_a_filetype(String filename)
    {
        if (filename != "") {
            TestRunner.homePage.chooseMoonImage(filename);
        }
    }

    @When("the user creates a moon")
    public void the_user_creates_a_moon()
    {
        TestRunner.homePage.submitCelestialBody();
    }

    @Then("the user should see the newly created moon")
    public void the_user_should_see_the_newly_created_moon()
    {
        Assert.assertEquals(3, TestRunner.homePage.getNumberOfMoonRows());
    }
    
}
