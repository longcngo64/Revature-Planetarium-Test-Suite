# Since the feature is being tagged, these tags cascade to the contained Scenario and Scenario Outline
@US1 @SR1
Feature: User Registration
    As a new user I want to open an account with the Planetarium so I can save my celestial findings

    Background: Registration Starting Actions
        Given   the user is on the login page
        And     the user clicks the register link

    Scenario: Users can register a new account with valid credentials
        When    the user provides a username for registration "<username>"
        And     the user provides a password for registration "<password>"
        And     the user submits the credentials
        Then    the user should get a browser alert "<alertString>"
        And     the user should be redirected to the login page

    Examples:
    |username          |password         |alertString                  |
    |ectoBiologist_413 | noarms2009_haha |Account created successfully |

    # these tags will apply to each run of the Scenario Outline determined by the Examples table data
    @UR1 @UR2 @UR3 @UR4 @UR5 @UR6
    Scenario Outline: Users can not register a new account with invalid credentials
        When    the user provides a username for registration "<username>"
        And     the user provides a password for registration "<password>"
        And     the user submits the credentials
        Then    the user should get a browser alert "<alertString>"
        And     the user should stay on the registration page

    Examples:
    |username                                    |password                           |alertString            |
    |turntableGodhead                            |noarms2009_haha                    |Invalid username |
    |john                                        |noarms2009_haha                    |Invalid username |
    |mynamewillneverbezoosmellpooplordorwhatever |noarms2009_haha                    |Invalid username |
    |413skaia	                                 |noarms2009_haha                    |Invalid username |
    |lilcal!!?)                                  |noarms2009_haha                    |Invalid username |
    |ectoBiologist_413	                         |t3nt	                             |Invalid password |
    |ectoBiologist_413	                         |Cassiethesalamanderismybelovedlma0 |Invalid password |
    |ectoBiologist_413	                         |413mybday                          |Invalid password |
    |ectoBiologist_413	                         |C4ss!lethesalamander	             |Invalid password |
    |ectoBiologist_413	                         |egbert1	                         |Invalid password |
    |ectoBiologist_413	                         |EGBERT1	                         |Invalid password |
    |ectoBiologist_413	                         |Strider	                         |Invalid password |
