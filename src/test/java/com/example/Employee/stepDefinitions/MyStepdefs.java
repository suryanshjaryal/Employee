package com.example.Employee.stepDefinitions;

import com.example.Employee.Model.Employee;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.spring.CucumberContextConfiguration;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;
import org.junit.Before;
import org.springframework.beans.factory.annotation.Value;

import java.util.Map;

@CucumberContextConfiguration
public class MyStepdefs {
    private RequestSpecification requestSpecification;

    private Response response;
    private ObjectMapper objectMapper = new ObjectMapper();
    private String baseUrl = "http://localhost:8080";

//    @Before
//    public void setTup(){
//        requestSpecification =RestAssured.given().contentType("application/json");
//    }


    @Given("create the request body with details")
    public void createTheRequestBodyWithDetails(DataTable dataTable) throws JsonProcessingException {
//        Employee employee = new Employee();
//        employee.setName("ere");
//        employee.setEmailId("73@gmail.com");
//        String requestBody = objectMapper.writeValueAsString(employee);
//
//        requestSpecification = RestAssured.given().contentType("application/json").body(requestBody);
        Map<String,String>data =dataTable.asMap(String.class,String.class);
        String name= data.get("name");
 String email=data.get("email");
 Employee employee=new Employee();
 employee.setName(name);
 employee.setEmailId(email);
        String requestBody = objectMapper.writeValueAsString(employee);
        requestSpecification = RestAssured.given().contentType("application/json").body(requestBody);
    }

    @When("the client sends a POST request")
    public void theClientSendsAPOSTRequest() {
        response = requestSpecification.post(baseUrl + "/emp/save");
    }

    @Then("the response status should be {int}")
    public void theResponseStatusShouldBe(int arg0) {
        int actualResponseCode = response.getStatusCode();
        Assert.assertEquals(arg0, actualResponseCode);
    }

    @Given("User wants to get the data")
    public void userWantsToGetTheData() {
        requestSpecification=RestAssured.given().contentType("application/json");

    }

    @When("the client sends a GET request")
    public void theClientSendsAGETRequest() {
        response= requestSpecification.get(baseUrl+ "/emp/get");

    }

    @Then("the response status should be OK with Code {int}")
    public void theResponseStatusShouldBeOKWithCode(int arg0) {
        int actualGetResponseCode= response.getStatusCode();
        Assert.assertEquals(arg0,actualGetResponseCode);
    }



    }
