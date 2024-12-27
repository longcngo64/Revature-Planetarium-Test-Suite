@UR2 @SR1 @SR3
Feature: User login
    As a user I want to securely access my account so I can interact with the Planetarium in a secure environment

    Scenario: Users can login with valid credentials
        Given the user is on the login page
        When  the user provides a username, "<username>"
        And   the user provides a password, "<password>"
        And   the user submits the credentials to login
        Then  the user should be go to the home page on successful login
        And   the user should see a greeting for them with their name, "<username>"
        
    Examples:
    |username             |password     |
    |turntableGodhead_612 |bArkB3rkBark |

    Scenario: Users can not login with invalid credentials
        Given the user is on the login page
        When  the user provides a username, "<username>"
        And   the user provides a password, "<password>"
        And   the user submits the credentials to login
        Then  the user should get a browser alert, "<alertString>"
        And   the user should stay at the login page 

    Examples:
    |username              |password     |alertString         |
    |TT                    |bArkB3rkBark |Invalid credentials |
    |turntableGodhead_612  |t3nt         |Invalid credentials |
    |TT                    |t3nt         |Invalid credentials |

    Scenario: Users that are logined can logout on the homepage
        Given the user is on the home page
        When  the user logout
        Then  the user should be redirected back to the login page