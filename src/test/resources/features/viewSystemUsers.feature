Feature: view system user functionality

  Background: important steps before scenario execution
    Given the admin user login
    And the admin open view system users page

  Scenario: Verify admin is able to add and delete any system user

    When the admin click on add user button
    And the admin fill all required data
    And the admin click save button
    Then the user records should be increased by one
    When the admin searched for added user
    And the admin delete added user
    Then the user records should be Decreased by one


