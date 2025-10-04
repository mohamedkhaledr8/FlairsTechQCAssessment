Feature: adding deleting Candidate requests

  Background: important steps before scenario execution
    Given Admin navigate to url
    And Admin user login with valid email and password


    Scenario: admin adding Candidate
      When Admin adding Candidate
      Then Candidate should be added


  Scenario: admin delete Candidate
    When Admin deletes Candidate
    Then Candidate should be deleted



