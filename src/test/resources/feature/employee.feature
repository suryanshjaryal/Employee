@employee
Feature: Employee API Basic Test

  Scenario: Check if Employee API is running
    Given create the request body with details
      | name | email        |
      | ac   | ac@gmail.com |
      | qe   | 1@gmail.com  |
      | xz   | xz@gmail.com |
    When the client sends a POST request
    Then the response status should be 201

  Scenario: Check if Employee API is running
    Given User wants to get the data
    When the client sends a GET request
    Then the response status should be OK with Code 200