@US5 @SR2
Feature: Planet Deletion
    As a user I want to delete planets to the Planetarium so I can correct my findings

    Background: Planet Deletion Starting Actions
        Given   the user has logged in
        And     the user is on the home page

    @PR4 @MR5
    Scenario: Users delete a planet that they created
        When    the user provides a planet name, "<planetName>" to delete
        And     the user delete the planet
        Then    the table of planets and moon will refresh
        And     the user should not see the deleted planet
        And     the user should not see any moons associated with the deleted planet
        And     the user should stay at the home page

    Examples:
    |planetName                     |moonName      |
    |Land of Snow and Frogs_1025    |              |
    |Land of Snow and Frogs_1025    |Pr0spit_ 1025 |

    @PR4
    Scenario Outline: Users can not delete a planet that is non-existent
        When    the user provides a planet name, "<planetName>"
        And     the user delete the planet
        Then    the user should get a browser alert "<alertString>"
        And     the user should stay at the home page

    Examples:
    |planetName         |alertString         |
    |landoffrogsandsnow |Invalid planet name |