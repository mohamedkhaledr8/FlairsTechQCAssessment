Feature: view system user functionality

  Background: important steps before scenario execution
    Given Admin navigate to url
    Given Admin user login with valid email and password
    And Admin open view system users page

  Scenario: Verify admin is able to add and delete any system user

    When  Admin click on add user button
    And Admin fill all required data
    And  Admin click save button
    Then  User records should be increased by one
    When Admin searched for added user
    And  Admin delete added user
    Then  User records should be Decreased by one


