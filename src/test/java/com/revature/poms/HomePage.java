package com.revature.poms;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class HomePage {
    private WebDriver driver;

    @FindBy(id = "greeting")
    private WebElement greetingHeader;

    @FindBy(id = "logoutButton")
    private WebElement logoutButton;

    @FindBy(id = "locationSelect")
    private WebElement locationSelect;

    @FindBy(id = "planetNameInput")
    private WebElement planetNameInput;

    @FindBy(id = "planetImageInput")
    private WebElement planetImageInput;

    @FindBy(id = "moonNameInput")
    private WebElement moonNameInput;

    @FindBy(id = "moonImageInput")
    private WebElement moonImageInput;

    @FindBy(id = "orbitedPlanetInput")
    private WebElement orbitedPlanetInput;

    @FindBy(className = "submitButton")
    private WebElement submitButton;

    @FindBy(id = "deleteInput")
    private WebElement deleteInput;

    @FindBy(id = "deleteButton")
    private WebElement deleteButton;

    @FindBy(tagName = "tr")
    private List<WebElement> tableRows;

    public HomePage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getHomePageGreeting()
    {
        return greetingHeader.getText();
    }

    public int getNumberOfCelestialRows()
    {
        return tableRows.size()-1;
    }
    
    public int getNumberOfPlanetRows()
    {
        int planetCount = 0;
        for (WebElement row : tableRows)
        {
            System.out.println(row.getText());
        }
        return planetCount;
    }
    
    public int getNumberOfMoonRows()
    {
        int moonCount = 0;
        for (WebElement row : tableRows)
        {
            
        }
        return moonCount;
    }

    public void tryToAccessHomePageDirectly(){
        driver.get("http://localhost:8080/planetarium");
    }

    public void logout(){
        logoutButton.click();
    }

    public void selectCelestialBody(String body)
    {
        Select selectBody = new Select(locationSelect);
        selectBody.selectByValue(body);
    }

    public void enterPlanetName(String string) 
    {
        planetNameInput.sendKeys(string);
    }

    public void choosePlanetImage(String filepath)
    {
        planetImageInput.sendKeys(filepath);
    }

    public void enterMoonName(String string) 
    {
        moonNameInput.sendKeys(string);
    }

    public void chooseMoonImage(String filepath)
    {
        moonImageInput.sendKeys(filepath);
    }

    public void enterPlanetID(String string) 
    {
        orbitedPlanetInput.sendKeys(string);
    }

    public void submitCelestialBody()
    {
        submitButton.click();
    }

    public void addPlanet(String planetName, String filepath)
    {
        enterPlanetName(planetName);
        if (filepath != "") 
        {
            choosePlanetImage(filepath);
        }
        submitCelestialBody();
    }

    public void addMoon(String moonName, String filepath)
    {
        enterPlanetName(moonName);
        if (filepath != "") 
        {
            choosePlanetImage(filepath);
        }
        submitCelestialBody();
    }

    public void enterDeletionInput(String string) 
    {
        deleteInput.sendKeys(string);
    }

    public void deleteCelestialBody() 
    {
        deleteButton.click();
    }

}
