@US3 @SR2 @SR3
Feature: View User Planets and Moons
    As a user I want to see my planets and moons added to the Planetarium so I can track my findings

    @PR4 @MR4
    Scenario: Login should be allowed for viewing owned resources
        Given the user is logged in 
        And   the user is on the home page
        Then  the user should see all of the planets and moons that they have created and they created only

    Scenario: Users that are not logged in cannot go into the home page
        Given the user is on the login page
        When  the user tries to go to the home page directly
        Then  the user should not access the home page