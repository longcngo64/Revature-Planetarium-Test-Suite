package com.revature.steps;

import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.revature.TestRunner;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class MoonDeletionSteps {
    @When("the user provides a moon name, {string} to delete")
    public void the_user_provides_a_moon_name_to_delete(String moonName) {
        TestRunner.homePage.enterDeletionInput(moonName);
    }

    @When("the user deletes a moon")
    public void the_user_deletes_a_moon(String moonName)
    {
        TestRunner.homePage.selectCelestialBody("moon");
        TestRunner.homePage.deleteCelestialBody();
    }

    @Then("the user should see the moon does not exist")
    public void the_user_should_see_the_moon_does_not_exist(String moonName)
    {
        Assert.assertEquals(1, TestRunner.homePage.getNumberOfMoonRows());
    }
}
