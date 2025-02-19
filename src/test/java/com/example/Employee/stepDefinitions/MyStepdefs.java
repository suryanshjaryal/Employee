package com.example.Employee.stepDefinitions;

import com.example.Employee.Model.Employee;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.it.Ma;
import io.cucumber.spring.CucumberContextConfiguration;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;
import org.junit.Before;
import org.springframework.beans.factory.annotation.Value;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CucumberContextConfiguration
public class MyStepdefs {
    private RequestSpecification requestSpecification;

    private Response response;
    private ObjectMapper objectMapper = new ObjectMapper();
    private int employeeIdToDelete;
    //  private String baseUrl = "http://localhost:8080";


//    @Before
//    public void setTup(){
//        requestSpecification =RestAssured.given().contentType("application/json");
//    }


    @Given("create the request body with details")
    public void createTheRequestBodyWithDetails(DataTable dataTable) throws JsonProcessingException {
        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
        for (Map<String, String> entry : data) {
            Employee employee = new Employee();
            employee.setName(entry.get("name"));
            employee.setEmailId(entry.get("email"));
            String requestBody = objectMapper.writeValueAsString(employee);
            requestSpecification = RestAssured.given().contentType("application/json").body(requestBody);
        }
    }

    @When("the client sends a POST request")
    public void theClientSendsAPOSTRequest() throws IOException {
        String url = UtilityClass.getProperty("url");
        response = requestSpecification.post(url + "/emp/save");
    }

    @Then("the response status should be {int}")
    public void theResponseStatusShouldBe(int expectedStatus) {
        Assert.assertEquals(expectedStatus, response.getStatusCode());
    }

    @Given("User wants to get the data with details")
    public void userWantsToGetTheData(DataTable dataTable) {
        requestSpecification = RestAssured.given().contentType("application/json");
    }

    @When("the client sends a request")
    public void theClientSendsAGETRequest() throws IOException {
        String url = UtilityClass.getProperty("url");
        response = requestSpecification.get(url + "/emp/get");
    }

    @Then("the response status should be OK with Code {int}")
    public void theResponseStatusShouldBeOKWithCode(int expectedStatus) {
        Assert.assertEquals(expectedStatus, response.getStatusCode());

    }
    @Given("the client wants to update an employee with details")
    public void theClientWantsToUpdateAnEmployeeWithDetails(DataTable dataTable) {
        requestSpecification = RestAssured.given().contentType("application/json");
    }
//    @When("the client sends an UPDATE request with the details")
//    public void theClientSendsAnUPDATERequestWithTheDetails(DataTable dataTable) throws JsonProcessingException, IOException {
//        String url = UtilityClass.getProperty("url");
//        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
//        for (Map<String, String> entry : data) {
//            Employee employee = new Employee();
//            employee.setName(entry.get("Name"));
//            employee.setEmailId(entry.get("Email"));
//            String requestBody = objectMapper.writeValueAsString(employee);
//            response = requestSpecification.body(requestBody).put(url + "/emp/update/" + entry.get("ID")); // Include ID in URL
//        }


    @When("the client sends an UPDATE request with the details")
    public void theClientSendsAnUPDATERequestWithTheDetails(DataTable dataTable) throws IOException {
        String url = UtilityClass.getProperty("url");
        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
        for (Map<String, String> entry : data) {
            Employee employee = new Employee();
            employee.setName(entry.get("Name"));
            employee.setEmailId(entry.get("Email"));
            String requestBody = objectMapper.writeValueAsString(employee);
            requestSpecification = RestAssured.given().contentType("application/json").body(requestBody);

    }
}

    @Then("the response status should  {int}")
    public void theResponseStatusShould(int arg0) {
    }

    @Given("the client wants to delete an employee with ID {int}")
    public void theClientWantsToDeleteAnEmployeeWithID(int employeeId) {
        requestSpecification = RestAssured.given().contentType("application/json");
        this.employeeIdToDelete = employeeId; // Store ID for later use
    }

    @When("the client sends a DELETE request")
    public void theClientSendsADELETERequest() throws IOException {
        String url = UtilityClass.getProperty("url") + "/emp/delete/" + employeeIdToDelete;
        response = requestSpecification.delete(url);
    }

    @Then("the response status should b {int}")
    public void theResponseStatusShouldB(int expectedStatus) {
        Assert.assertEquals(expectedStatus, response.getStatusCode());
    }



}

