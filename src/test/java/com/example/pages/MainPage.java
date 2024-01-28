package com.example.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class MainPage extends BasePage {

    @FindBy(xpath = "//input[@id='add-task-input']")
    public WebElement newTaskAdditionField;

    @FindBy(xpath = "//button[@id='clear-all-tasks']")
    public WebElement buttonClearAllTask;

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
            System.out.println(oneTask.getText());
            if (oneTask.getText().equals(task)) {
                return true;
            }
        }
        return false;
    }
}
