package com.example.pages;

import com.example.context.Context;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.Set;

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

                Set<String> windowHandles = Context.getDriver().getWindowHandles();
                for (String windowHandle : windowHandles) {
                    if (!windowHandle.equals(Context.getDriver().getWindowHandle())) {
                        Context.getDriver().switchTo().window(windowHandle);
                        break;
                    }
                }
                buttonDeleteWindow.click();
                Context.getDriver().switchTo().defaultContent();
            }
        }
    }

    public void deletingTaskByNumberInTheToDoList(int recordNumber) {
        for (int i = 0; i < listTasks.size(); i++) {
            if (i == (recordNumber - 1)) {
                listButtonsDeleteTask.get(i).click();
                Set<String> windowHandles = Context.getDriver().getWindowHandles();
                for (String windowHandle : windowHandles) {
                    if (!windowHandle.equals(Context.getDriver().getWindowHandle())) {
                        Context.getDriver().switchTo().window(windowHandle);
                        break;
                    }
                }
                buttonDeleteWindow.click();
                Context.getDriver().switchTo().defaultContent();
            }
        }
    }
}
