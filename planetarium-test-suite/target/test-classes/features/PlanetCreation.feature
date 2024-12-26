@US4 @SR2
Feature: Planet Creation
    As a user I want to add new planets to the Planetarium so I can update my findings

    Background: Planet Creation Starting Actions
        Given   the user has logined
        And     the user is on the home page

    @PR4 @PR5
    Scenario: Users create a new planet with valid data
        When    the user provides a valid planet name, "<planet_name>"
        And     the user optionally provides a file with a valid filetype "<file_name>"
        And     the user creates the planet
        Then    the table of planets and moon will refresh
        And     the user should see the newly created planet
        And     the user should stay at the home page

    Examples:
    |planet_name        |file_name|
    |landofwindandshade |         |
    |landofwindandshade |lowas.png|

    # these tags will apply to each run of the Scenario Outline determined by the Examples table data
    @PR1 @PR2 @PR3 @PR6
    Scenario Outline: Users can not create a new planet with invalid data
        When    the user provides a planet name, "<planet_name>"
        And     the user optionally provides a file with some filetype "<file_name>"
        And     the user creates the planet
        Then    the user should get a browser alert "<alert_msg_planet_creation>"
        And     the user should stay at the home page

    Examples:
    |planet_name                                        |file_name                   |alert_msg_planet_creation|
    |                                                   |                            |Invalid planet name alert|
    |land-123-456-of-789-heat-123-and-456-clockwork-789 |                            |Invalid planet name alert|
    |(landoflightandchalk)                              |                            |Invalid planet name alert|
    |landoffrogsandsnow413                              |                            |Invalid planet name alert|
    |	                                                |lowas.png                   |Invalid planet name alert|
    |landofwindandshade                                 |lowas.gif                   |Invalid filetype alert   |