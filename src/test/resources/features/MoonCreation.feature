@US4 @SR2
Feature: Moon Creation
    As a user I want to add new moons to the Planetarium so I can update my findings

    Background: Moon Creation Starting Actions
        Given   the user has logged in
        And     the user is on the home page

    @MR4 @MR6
    Scenario: Users create a new moon with valid data
        When    the user provides a moon name, "<moon_name>"
        When    the user provides a planet name, "<planet_name>"
        And     the user optionally provides a file with a filetype "<file_name>"
        And     the user creates the moon
        Then    the table of planets and moons will refresh
        And     the user should see the newly created moon
        And     the user should stay at the home page

    Examples:
    |moon_name         |planet_name                |file_name   |
    |Pr0spit_ 413      |Land of Wind and Shade_413 |            |
    |Pr0spit_ 413      |Land of Wind and Shade_413 |prospit.jpeg|

    @MR1 @MR2 @MR3 @MR7
    Scenario Outline: Users can not create a new moon with invalid data
        When    the user provides a moon name, "<moon_name>"
        And     the user provides a planet name, "<planet_name>"
        And     the user optionally provides a file with a filetype "<file_name>"
        And     the user creates the moon
        Then    the user should get a browser alert "<alert>"
        And     the user should stay at the home page

    Examples:
    |moon_name                      |planet_name                |file_name    |alert             |
    |                               |Land of Wind and Shade_413 |             |Invalid moon name |
    |derse12345678901234567890413612|Land of Wind and Shade_413 |             |Invalid moon name |
    |(skaia)                        |Land of Wind and Shade_413 |             |Invalid moon name |
    |prospit1025                    |Land of Wind and Shade_413 |             |Invalid moon name |
    |Pr0spit_ 413                   |	                        |prospit.jpeg |Invalid planet id |
    |Pr0spit_ 413                   |Land of Wind and Shade_413 |prospit.txt  |Invalid filetype  |