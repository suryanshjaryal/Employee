@employee
Feature: Employee API Basic Test

  Scenario: Check if Employee API is running
    Given create the request body with details
      | name | email         |
      | a    | a@gmail.com   |
      | qess | 1s@gmail.com  |
      | szd  | xsz@gmail.com |
    When the client sends a POST request
    Then the response status should be 201

  Scenario: Check if Employee API is running
    Given User wants to get the data
    When the client sends a GET request
    Then the response status should be OK with Code 200

  Scenario: Delete an employee
    Given the client wants to delete an employee with ID 1
    When the client sends a DELETE request to remove the employee with ID 1
    Then the response status should b 200


  Scenario: Update an existing employee
    Given the client wants to update an employee with ID 1
    When the client sends an UPDATE request for employee with ID 1
    Then the response status should 200
