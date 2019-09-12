package seedu;

import java.io.IOException;
import java.text.ParseException;
import java.util.*;

/**
 * This class is the main Duke class
 */
public class Duke {

    protected static List<todo> todoList;

    public static void main(String[] args) throws dukeException {
        Storage DataHandler = new Storage();
        TaskList taskList = new TaskList();
        Ui userInterface = new Ui();
        userInterface.welcomeUser();
        // Read in
        try {
            todoList = DataHandler.loader();
        } catch (IOException Io) {
            todoList = new ArrayList<>();
        } catch (ClassNotFoundException Ex) {
            todoList = new ArrayList<>();
        }

        Scanner sc = new Scanner(System.in);

        while (true) {
            String line = sc.nextLine();
            Parser parser = new Parser(line);
            String Command = parser.getTypeOfTask();
            try {
                if (Command.equals("bye")) {
                    userInterface.byeUser();
                    break;
                } else if (Command.equals("list")) {
                    taskList.listTasks(todoList);
                } else if (Command.equals("done")) {
                    taskList.taskDone(todoList, parser.getIndex());
                } else if (Command.equals("delete")) {
                    taskList.deleteTask(todoList, parser.getIndex());
                } else if (Command.equals("find")) {
                    taskList.findTask(todoList, parser.getSearchTaskDescription());
                } else if (Command.equals("todo")) {
                    taskList.addTodo(todoList, parser.getTaskDescription());
                } else if (Command.equals("deadline")) {
                    taskList.addDeadline(todoList, parser.getTaskDescription(), parser.getBy());
                } else if (Command.equals("event")) {
                    taskList.addEvent(todoList, parser.getTaskDescription(), parser.getAt(), parser.getDuration());
                } else {
                    throw new dukeException(userInterface.getUNKNOWN_INPUT());
                }
                // Save the current list
                try {
                    DataHandler.writer(todoList);
                } catch (IOException Io) {
                    System.out.println(Io.getMessage());
                }
            } catch (dukeException | ParseException EX) {
                System.out.println(EX.getMessage());
            }
        }
        sc.close();
    }
}


// doneLine refers to the user input which is something like  done 2
// Call the parser here
// check based on typeOfTask
// Inside the Ui  && taskList--> do the changes

//Array List of to-do
//List<todo> todoList = new ArrayList<>();

//Managing the inputs
// Store the List of tasks as a linked list --> easy access and remove
// Store the input of user as a array --> split using  " "
// convert to a linked list
// remove the first word (type of todo )  --> join the rest of it as a todo
// again split the remaining words based on "/at" or "/by"

//try{
//whole block of code --> in between have if statements for different error and throw the messages needed
//catch ( initialise ex object ){
//print the message }
