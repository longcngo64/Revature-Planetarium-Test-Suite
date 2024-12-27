package com.revature.steps;

import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.revature.TestRunner;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class PlanetDeletionSteps {
    @When("the user provides a planet name, {string} to delete")
    public void the_user_provides_a_planet_name_to_delete(String planetName) {
        TestRunner.homePage.enterDeletionInput(planetName);
    }

    @When("the user deletes a planet")
    public void the_user_deletes_a_moon()
    {
        TestRunner.homePage.selectCelestialBody("planet");
        TestRunner.homePage.deleteCelestialBody();
    }

    @Then("the user should not see the deleted planet")
    public void the_user_should_see_the_moon_does_not_exist()
    {
        Assert.assertEquals(1, TestRunner.homePage.getNumberOfPlanetRows());
    }

    @Then("the user should not see any moons associated with the deleted planet")
    public void the_user_should_not_see_any_moons_associated_with_the_deleted_planet()
    {
        Assert.assertEquals(1, TestRunner.homePage.getNumberOfMoonRows());
    }

}
