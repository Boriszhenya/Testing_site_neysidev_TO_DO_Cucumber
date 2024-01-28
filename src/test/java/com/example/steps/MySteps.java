package com.example.steps;

import com.example.pages.MainPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static com.example.context.Context.scenario;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MySteps {

    @Given("user is on the main page")
    public void user_is_home_page() {
        scenario.log("Main page");
    }



    @And("press Enter")
    public void pressEnter() {
        new MainPage().enterNewTask();
    }


    @Then("this entry {string} will appear on the To-Do list")
    public void thisEntryWillAppearOnTheToDoList(String task) {
        assertTrue(new MainPage().isTextTask(task));
    }

    @When("a user adds the new task {string}")
    public void aUserAddsTheNewTask(String task) {
        new MainPage().addOneTask(task);
        {
        }
    }
}
