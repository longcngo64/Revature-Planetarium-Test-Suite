@US4 @SR2
Feature: Moon Creation
    As a user I want to add new moons to the Planetarium so I can update my findings

    Background: Moon Creation Starting Actions
        Given   the user has logined
        And     the user is on the home page

    @MR4 @MR6
    Scenario: Users create a new moon with valid data
        When    the user provides a valid moon name, "<moon_name>"
        When    the user provides a valid and existing planet name, "<planet_name>"
        And     the user optionally provides a file with a valid filetype "<file_name>"
        And     the user creates the moon
        Then    the table of planets and moon will refresh
        And     the user should see the newly created moon
        And     the user should stay at the home page

    Examples:
    |moon_name    |planet_name        |file_name|
    |prospit      |landofwindandshade |         |
    |prospit      |landofwindandshade |lowas.png|

    @MR1 @MR2 @MR3 @MR7
    Scenario Outline: Users can not create a new moon with invalid data
        When    the user provides a moon name, "<moon_name>"
        And     the user provides a planet name, "<planet_name>"
        And     the user optionally provides a file of some filetype "<file_name>"
        And     the user creates the moon
        Then    the user should get a browser alert "<alert_msg_moon_creation>"
        And     the user should stay at the home page

    Examples:
    |moon_name                      |planet_name       |file_name                   |alert_msg_moon_creation|
    |                               |landofwindandshade|                            |Invalid moon name alert|
    |derse12345678901234567890413612|landofwindandshade|                            |Invalid moon name alert|
    |(skaia)                        |landofwindandshade|                            |Invalid moon name alert|
    |prospit1025                    |landofwindandshade|                            |Invalid moon name alert|
    |prospit                        |	               |prospit.jpeg                |Invalid planet id alert|
    |prospit                        |landofwindandshade|prospit.txt                 |Invalid filetype alert |