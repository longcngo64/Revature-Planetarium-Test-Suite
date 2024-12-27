package com.revature.steps;

import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.revature.TestRunner;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class PlanetCreationSteps {
    @Given("the user has logged in")
    public void the_user_has_logged_in()
    {
        TestRunner.loginPage.setUpLoggedInUser();
    } 

    @When("the user selects the planet option")
    public void the_user_selects_the_planet_option()
    {
        TestRunner.homePage.selectCelestialBody("planet");
    }
    
    @When("the user provides a planet name, {string}")
    public void the_user_provides_a_planet_name(String planetName) {
        TestRunner.homePage.enterPlanetName(planetName);
    }

    @When("the user optionally provides a planet image file with a filetype {string}")
    public void the_user_optionally_provides_a_planet_image_file_with_a_filetype(String filename) {

        if (filename != "") {
            TestRunner.homePage.choosePlanetImage(filename);
        }
    }

    @When("the user creates a planet")
    public void the_user_creates_a_planet(String planetName)
    {
        TestRunner.homePage.submitCelestialBody();
    }

    @Then("the table of planets and moons will refresh")
    public void the_table_of_planets_and_moons_will_refresh() throws InterruptedException
    {
        TestRunner.wait.until(ExpectedConditions.visibilityOf(
            TestRunner.driver.findElement(By.id("celestialTable"))));
    }

    @Then("the user should see the newly created planet")
    public void the_user_should_see_the_newly_created_planet(String planetName)
    {
        Assert.assertEquals(2, TestRunner.homePage.getNumberOfPlanetRows());
    }

}
