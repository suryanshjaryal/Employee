Feature: Employee API Basic Test

  Scenario: Check if Employee API is running
    When the client sends a GET request to "/emp/get"
    Then the response status should be 200
