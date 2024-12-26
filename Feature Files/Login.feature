@UR2 @SR1 @SR3
Feature: User login
    As a user I want to securely access my account so I can interact with the Planetarium in a secure environment

    Scenario: Users can login with valid credentials
        Given the user is on the login page
        When  the user provides a valid username, "<username>"
        And   the user provides a valid password, "<password>"
        And   the user submits the credentials
        Then  the user should be go to the home page on sucessful login
        And   the user should see moon creation inputs
        And   the user should see a greeting for them

    Examples:
    |username             |password     |
    |turntableGodhead_612 |bArkB3rkBark |

    Scenario: Users can not login with invalid credentials
        Given the user is on the login page
        When  the user provides a username, "<username>"
        And   the user provides a password, "<password>"
        And   the user submits the credentials
        Then  the user should get a browser alert, "<alert>" saying "Invalid Credentials"
        And   the user should stay at the login page 

    Examples:
    |username              |password     |alert               |
    |TT                    |bArkB3rkBark |Invalid Credentials |
    |turntableGodhead_612  |t3nt         |Invalid Credentials |
    |TT                    |t3nt         |Invalid Credentials |

    Scenario: Users that are logined can logout on the homepage
        Given the user is on the home page
        When  the user logout
        Then  the user should be redirected back to the login page

    Examples:
    ||