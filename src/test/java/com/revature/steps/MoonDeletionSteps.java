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

    @When("the user provides a moon name {string}")
    public void the_user_provides_a_moon_name(String moonName) {
        TestRunner.homePage.enterDeletionInput(moonName);
    }

    @When("the user deletes a moon")
    public void the_user_deletes_a_moon(String moonName)
    {
        TestRunner.homePage.selectCelestialBody("moon");
        TestRunner.homePage.deleteCelestialBody();
    }

    @Then("the table of planets and moon will refresh")
    public void the_table_of_planets_and_moon_will_refresh() throws InterruptedException
    {
        TestRunner.wait.until(ExpectedConditions.visibilityOf(
            TestRunner.driver.findElement(By.id("celestialTable"))));
    }

    @Then("the user should see the moon does not exist")
    public void the_user_should_see_the_moon_does_not_exist(String moonName)
    {
        Assert.assertEquals(1, TestRunner.homePage.getNumberOfMoonRows());
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
