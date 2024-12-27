package com.revature.steps;

import org.junit.Assert;
import org.openqa.selenium.Alert;
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

    @Given("the user is on the home page")
    public void the_user_is_on_the_home_page()
    {
        Assert.assertEquals("Home", TestRunner.driver.getTitle());
    }
    
    @When("the user provides a planet name {string}")
    public void the_user_provides_a_planet_name(String planetName) {
        TestRunner.homePage.enterPlanetName(planetName);
    }

    @When("the user optionally provides a file with a filetype {string}")
    public void the_user_optionally_provides_a_file_with_a_filetype(String filename) {
        TestRunner.homePage.choosePlanetImage(filename);
    }

    @When("the user creates a planet")
    public void the_user_creates_a_planet(String planetName)
    {
        TestRunner.homePage.selectCelestialBody("planet");
        TestRunner.homePage.submitCelestialBody();
    }

    @Then("the table of planets and moons will refresh")
    public void the_table_of_planets_and_moons_will_refresh() throws InterruptedException
    {
        //TestRunner.wait.until(ExpectedConditions.refreshed(
        //    TestRunner.driver.findElement(By.id("celestialTable"))));
    }

    @Then("the user should see the newly created planet")
    public void the_user_should_see_the_newly_created_planet(String planetName)
    {
        Assert.assertEquals(2, TestRunner.homePage.getNumberOfPlanetRows());
    }

    @Then("the user should get a browser alert {string}")
    public void the_user_should_get_a_browser_alert(String alertString) 
    {
        TestRunner.wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = TestRunner.driver.switchTo().alert();
        Assert.assertEquals(alertString, alert.getText());
        alert.accept();
    }

    @Then("the user should stay at the home page")
    public void the_user_should_stay_at_the_home_page()
    {
        Assert.assertEquals("Home", TestRunner.driver.getTitle());
    }
}
