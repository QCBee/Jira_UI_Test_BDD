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
  Scenario Outline: Unsuccessful login to Jira
    Given I navigate to Login Page
    And I enter <userName> and <userPass>
    And I click on login button
    Then I stay at Login Page
      Examples:
      | userName | userPass |
      | webinar5 | test     |
      | test     | webinar5 |
      |          | webinar5 |
      | webinar5 |          |
      |          |          |