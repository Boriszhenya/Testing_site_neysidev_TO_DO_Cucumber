Feature: а test of the TO-DO List App

  @positive

  Scenario: adding an entry to the To-Do List
    Given user is on the main page
    When a user adds the new task "Hello world!"
    Then this entry "Hello world!" will appear on the To-Do list

  Scenario: deleting a task from the To-Do List
    Given user is on the main page
    And  added "Hello World" to the to-do list
    When the user deletes the task "Hello world!"
    Then the to-do list will be empty

  Scenario: Adding 3 tasks at a time to the to-do list
    Given user is on the main page
    When a user adds a task list to the to-do list
      | read a chapter of a programming book |
      | do two tasks in Java                 |
      | walk the dog                         |
    Then are 3 tasks on the to-do list

  Scenario: deleting 1 out of 3 tasks in the to-do list
    Given user is on the main page
    When a user adds a task list to the to-do list
      | read a chapter of a programming book |
      | do two tasks in Java                 |
      | walk the dog                         |
    And user the user removes the 2nd task from the to-do list
    Then 2 tasks remain in the to-do list

  Scenario: deleting all tasks from the to-do list
    Given user is on the main page
    When a user adds a task list to the to-do list
      | read a chapter of a programming book |
      | do two tasks in Java                 |
      | walk the dog                         |
      | to watch a horror movie tonight      |
    When  the user using the delete all tasks button deletes them all
    Then the to-do list will be empty

  Scenario: changing the status of an uncompleted task to "completed" in the to-do list
    Given user is on the main page
    And a user adds the new task "Hello world!"
    When the user marks the "Hello World!" task as completed
    Then the "Hello world!" task has a status of completed

  Scenario: changing the status of a completed task to " not completed" in the to-do list
    Given user is on the main page
    And a user adds the new task "Hello world!"
    When a user marks a completed task "Hello World!" as not completed
    Then the task "Hello world!" has a status of not completed


  Scenario: changing the status of 2 tasks as execution from the to-do list
    Given user is on the main page
    When a user adds a task list to the to-do list
      | read a chapter of a programming book |
      | do two tasks in Java                 |
      | walk the dog                         |
      | to watch a horror movie tonight      |
    When user changes the status of the 1st and 3rd tasks as completed
    Then 2 tasks remain in the to-do list
