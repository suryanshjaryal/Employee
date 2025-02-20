@employee
Feature: Employee API Basic Test

  Scenario: Create a new employee
    Given create the request body with details
      | name | email         |
      | a    | a@gmail.com   |
      | qess | 1s@gmail.com  |
      | szd  | xsz@gmail.com |
    When the client sends a POST request
    Then the response status should be 201

  Scenario: Retrieve Employee Data
    Given User wants to get the data with details
      | name |
      | a    |
    When the client sends a request
    Then the response status should be 200

  Scenario: Update an existing employee
    Given the client wants to update an employee with details
      | ID | Name | Email          |
      | 1  | John | john@email.com |
    When the client sends an UPDATE request with the details
      | Name | Email          |
      | John | john@email.com |
    Then the response status should  200
#  Scenario: Delete an employee
#    Given the client wants to delete an employee with ID 1
#    When the client sends a DELETE request
#    Then the response status should be 204
#  Scenario: Delete an employee
#    Given the client wants to delete an employee with ID 1
#    When the client sends a DELETE request
#    Then the response status should b 204

  Scenario: Delete an employee
    Given the client wants to delete the following employee:
      | Employee ID |
      | 1          |
    When the client sends a DELETE request
    Then the response status should e 204
