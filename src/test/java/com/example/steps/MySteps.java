package com.example.steps;

import com.example.pages.MainPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

import static com.example.context.Context.scenario;
import static com.example.context.Context.wait;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MySteps {

    String longString = "Системное тестирование означает тестирование всей " +
            "системы в целом, оно выполняется после интеграционного тестирования, " +
            "чтобы проверить, работает ли вся система целиком должным образом. " +
            "В основном это тестирование типа «черный ящик», которое оценивает работу " +
            "системы с точки зрения пользователя с помощью документа спецификации и оно " +
            "не требует каких-либо внутренних знаний о системе, таких как дизайн или структура кода.";

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
    }

    @And("added {string} to the to-do list")
    public void addedToTheToDoList(String task) {
        new MainPage().addOneTask(task);
     }

    @When("the user deletes the task {string}")
    public void theUserDeletesTheTask(String task) {
        new MainPage().deleteOneTaskFromList(task);
    }

    @Then("the to-do list will be empty")
    public void theToDoListWillBeEmpty() {
        MainPage m = new MainPage();
        assertTrue(m.listTasks.isEmpty());
    }

    @When("a user adds a task list to the to-do list")
    public void aUserAddsATaskListToTheToDoList(List<String> tasks) {
        for (String task : tasks) {
            new MainPage().addOneTask(task);
        }
    }

    @Then("are {int} tasks on the to-do list")
    public void areTasksOnTheToDoList(int size) {
        assertEquals(size, new MainPage().listTasks.size());
    }

    @When("the user enters a task longer task")
    public void theUserEntersATaskLongerTask() {
        new MainPage().addOneTask(longString);
    }

    @Then("this task is added to the to-do list")
    public void thisTaskIsAddedToTheToDoList() {
        assertEquals(longString, new MainPage().listTasks.getFirst().getText());
    }

    @When("the user using the delete all tasks button deletes them all")
    public void theUserUsingTheDeleteAllTasksButtonDeletesThemAll() {
        MainPage m = new MainPage();
        m.buttonClearAllTask.click();
        wait.until(ExpectedConditions.visibilityOf(m.buttonAllDeleteWindow));
        m.buttonAllDeleteWindow.click();
    }

    @And("user the user removes the {int}nd task from the to-do list")
    public void userRemovesTheNdTaskFromTheToDoList(int recordNumber) {
        new MainPage().deletingTaskByNumberInTheToDoList(recordNumber);
    }

    @Then("{int} tasks remain in the to-do list")
    public void tasksRemainInTheToDoList(int numberOfRecords) {
        assertEquals(numberOfRecords, new MainPage().listTasks.size());
    }
}
