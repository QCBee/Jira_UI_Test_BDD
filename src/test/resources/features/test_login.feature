Feature: Login to Jira

  @Regression
  Scenario: Successful login to Jira
    Given I navigate to Login Page
    And I enter user name - "webinar5"
    And I enter password - "webinar5"
    And I click on login button
    And I debug
    Then I am on the Home Page

  @Regression
  Scenario: Unsuccessful login to Jira
    Given I navigate to Login Page
    And I enter user name - "webinar5"
    And I enter password - "wrongPass"
    And I click on login button
    Then I stay at Login Page
