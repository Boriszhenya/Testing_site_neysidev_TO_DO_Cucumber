Feature: а test of the TO-DO List App

  @negative

  Scenario: check whether it is possible to add a task without text to the to-do list
    Given user is on the main page
    When user does not enter text and adds a new task
    Then the to-do list is empty and it says, "You have nothing task today!"

  Scenario: very long task input
    Given user is on the main page
    When the user enters a task longer than 256 characters.
    Then this task is added to the to-do list
