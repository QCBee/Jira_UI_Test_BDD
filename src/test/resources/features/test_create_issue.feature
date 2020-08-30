Feature: Create new issue

  Background: Login into application
    Given I navigate to Login Page
    And I enter user name - "webinar5"
    And I enter password - "webinar5"
    And I click on login button
    Then I am on the Home Page

  Scenario Outline: Create new issue with all required fields
    Given I click on Create button on Home Page
    Then Create Issue Pop Up is shown
    Then Project field is available
    Then Issue Type field is available
    Then Summary field is available
    When I fill Project field with valid data - <project>
    Then Issue Type field is available
    When I fill Issue Type with valid data - <issue type>
    Then Summary field is available
    When I fill Summary field with valid data - <summary>
    When I fill Reporter field with valid data - <reporter>
    And I click on Create button on Create Issue pop-up
    Then Create issue pop-up is closed
    Then Successful notification is shown on Home Page
    Examples:
      |project          |issue type|summary      |reporter|
      |Webinar (WEBINAR)|Task      |Test Summary |webinar5|