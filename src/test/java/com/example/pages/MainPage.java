package com.example.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

import static com.example.context.Context.*;

public class MainPage extends BasePage {

    @FindBy(xpath = "//input[@id='add-task-input']")
    public WebElement newTaskAdditionField;

    @FindBy(xpath = "//button[@id='clear-all-tasks']")
    public WebElement buttonClearAllTask;

    @FindBy(xpath = "//div[@id='remove-modal']//*[@id='remove-button']")
    public WebElement buttonDeleteWindow;

    @FindBy(xpath = "//div[@id='clear-all-tasks-modal']//*[@id='remove-button']")
    public WebElement buttonAllDeleteWindow;

    @FindBy(xpath = "//ul[@id='tasks-list']/li/div/label")
    public List<WebElement> listTasks;

    @FindBy(xpath = "//*[@class ='edit outline icon']")
    public List<WebElement> listButtonsEditTask;

    @FindBy(xpath = "//*[@class ='trash alternate outline remove icon']")
    public List<WebElement> listButtonsDeleteTask;

    @FindBy(xpath = "//ul[@id='tasks-list']/li/div/input")
    public List<WebElement> listButtonsCompletedTask;

    @FindBy(xpath = "//div[text()='You have nothing task today!']")
    public WebElement blockLabeledNoTasks;


    public void addOneTask(String newTask) {
        newTaskAdditionField.sendKeys(newTask);
        newTaskAdditionField.sendKeys(Keys.ENTER);
    }

    public void enterNewTask() {
        newTaskAdditionField.sendKeys(Keys.ENTER);
    }

    public boolean isTextTask(String task) {
        for (WebElement oneTask : listTasks) {
            if (oneTask.getText().equals(task)) {
                return true;
            }
        }
        return false;
    }

    public void deleteOneTaskFromList(String task) {
        for (int i = 0; i < listTasks.size(); i++) {
            if (listTasks.get(i).getText().equals(task)) {
                listButtonsDeleteTask.get(i).click();
                wait.until(ExpectedConditions.visibilityOf(buttonDeleteWindow));
                buttonDeleteWindow.click();
            }
        }
    }

    public void deletingTaskByNumberInTheToDoList(int recordNumber) {
        for (int i = 0; i < listTasks.size(); i++) {
            if (i == (recordNumber - 1)) {
                listButtonsDeleteTask.get(i).click();
                wait.until(ExpectedConditions.visibilityOf(buttonDeleteWindow));
                buttonDeleteWindow.click();
            }
        }
    }

    public boolean isHaveAfter(WebElement element) {
        return (boolean) ((JavascriptExecutor) getDriver()).executeScript(
                "return window.getComputedStyle(arguments[0], '::after').content !== 'none';", element);
    }

    public void markOneTaskFromList(String task) {
        for (int i = 0; i < listTasks.size(); i++) {
            if (listTasks.get(i).getText().equals(task)) {
                listButtonsCompletedTask.get(i).click();
            }
        }
    }

    public boolean isMarkOneTaskFromList(String task) {
        for (WebElement listTask : listTasks) {
            if (listTask.getText().equals(task)) {
                isHaveAfter(listTask);
                return true;
            }
        }
        return false;
    }

    public void unmarkOneTaskFromList(String task) {
        for (int i = 0; i < listTasks.size(); i++) {
            if (listTasks.get(i).getText().equals(task)&isHaveAfter(listTasks.get(i))) {
                listButtonsCompletedTask.get(i).click();
            }
        }
    }


}
