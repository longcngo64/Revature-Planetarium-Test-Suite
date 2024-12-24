@US5 @SR2
Feature: Planet Deletion
    As a user I want to delete planets to the Planetarium so I can correct my findings

    Scenerio Background: Planet Deletion Actions
        Given   the user has logined
        And     the user is on the home page

    @PR4 @MR5
    Scenario: Users delete a planet that they created
        When    the user provides a valid planet name, "<planet_name>"
        And     the user delete the planet
        Then    the table of planets and moon will refresh
        And     the user should not see the deleted planet
        And     the user should not see any moons associated with the deleted planet
        And     the user should stay at the home page

    Examples:
    |planet_name           |moon_name   |
    |landofwindandshade    |            |
    |landoffrogsandsnow413 |prospit1025 |

    @PR4
    Scenario Outline: Users can not delete a planet that is non-existent
        When    the user provides a planet name, "<planet_name>"
        And     the user delete the planet
        Then    the user should get a browser alert "<alert_msg_planet_creation>"
        And     the user should stay at the home page

    Examples:
    |planet_name        |
    |landoffrogsandsnow |