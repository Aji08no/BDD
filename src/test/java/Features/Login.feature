Feature:
Scenario:Successful login with valid credentials
    Given user is on the login page
    When user enters valid username and password
    And user clicks on the login button
    Then user should be redirected to the home page
    Then the user should be able to see the Practice List




