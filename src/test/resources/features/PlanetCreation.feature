@US4 @SR2
Feature: Planet Creation
    As a user I want to add new planets to the Planetarium so I can update my findings

    Background: Planet Creation Starting Actions
        Given   the user has logged in
        And     the user is on the home page

    @PR4 @PR5
    Scenario: Users create a new planet with valid data
        When    the user selects the planet option
        And     the user provides a planet name, "<planet_name>"
        And     the user optionally provides a planet image file with a filetype "<file_name>"
        And     the user creates the planet
        Then    the table of planets and moons will refresh
        And     the user should see the newly created planet
        And     the user should stay at the home page

    Examples:
    |planet_name                |file_name|
    |Land of Wind and Shade_413 |         |
    |Land of Wind and Shade_413 |lowas.png|

    # these tags will apply to each run of the Scenario Outline determined by the Examples table data
    @PR1 @PR2 @PR3 @PR6
    Scenario Outline: Users can not create a new planet with invalid data
        When    the user provides a planet name, "<planetName>"
        And     the user optionally provides a planet image file with a filetype "<fileName>"
        And     the user creates the planet
        Then    the user should get a browser alert "<alertString>"
        And     the user should stay at the home page

    Examples:
    |planet_name                                        |file_name                   |alert                    |
    |a                                                  |                            |Invalid planet name alert|
    |land-123-456-of-789-heat-123-and-456-clockwork-789 |                            |Invalid planet name alert|
    |(landoflightandchalk)                              |                            |Invalid planet name alert|
    |landoffrogsandsnow413                              |                            |Invalid planet name alert|
    |a                                                  |lowas.png                   |Invalid planet name alert|
    |Land of Wind and Shade_413                         |lowas.gif                   |Invalid filetype alert   |