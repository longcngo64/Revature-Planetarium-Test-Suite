@US5 @SR2
Feature: Moon Deletion
    As a user I want to delete moons to the Planetarium so I can correct my findings

    Background: Moon Deletion Starting Actions
        Given   the user has logged in
        And     the user is on the home page

    @MR4 @MR5
    Scenario: Users delete a moon that they created
        When    the user provides a moon name, "<moon_name>"
        And     the user deletes the moon
        Then    the table of planets and moon will refresh
        And     the user should see the moon does not exist
        And     the user should stay at the home page

    Examples:
    |moon_name          |
    |Pr0spit_ 1025      |

    @MR1 @MR2 @MR3 @MR4
    Scenario Outline: Users can not delete a nonexistant moon 
        When    the user provides a moon name, "<moon_name>"
        And     the user deletes the moon
        Then    the user should get a browser alert "<alert>"
        And     the user should stay at the home page

    Examples:
    |moon_name  |alert                  |
    |derse      |Invalid moon name      |