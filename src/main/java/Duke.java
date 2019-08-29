import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.text.ParseException;
import java.util.*;

public class Duke {
    protected static String straightLine = "____________________________________________________________ \n";
    protected static List<task> todoList = new ArrayList<>();
    protected static String UNKNOWN_INPUT = " ☹ OOPS!!! I'm sorry, but I don't know what that means :-(\n";
    protected static String EMPTY_EVENT_DESC ="☹ OOPS!!! The description of an event cannot be empty.\n";
    protected static String EMPTY_TODO_DESC = "☹ OOPS!!! The description of a todo cannot be empty.\n" ;
    protected static String EMPTY_DEAD_DESC = "☹ OOPS!!! The description of a deadline cannot be empty.\n";
    protected static dateAndTime dateAndTimeHandler = new dateAndTime();

    public static void main(String[] args) throws dukeException {
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";

        System.out.println(logo + "\n" + "Hello! I'm Duke\n" +
                "     What can I do for you?\n");

        dataHandler DataHandler = new dataHandler();

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
            // doneLine refers to the user input which is something like  done 2
            String[] doneLine = line.split(" "); // delimiter --> so for every " " breaks up and adds to the array of strings

            try {
                if (line.toLowerCase().equals("bye")) {
                    System.out.println(" Bye. Hope to see you again soon!\n");
                    todoList.clear();
                    break;

                } else if (line.toLowerCase().equals("list")) {
                    System.out.println(straightLine);
                    System.out.println("  Here are the tasks in your list: \n");
                    for (int i = 0; i < todoList.size(); ++i) {
                        System.out.println(
                                (i + 1) + ". " + todoList.get(i).toString());
                    }
                    System.out.println(straightLine);

                } else if (doneLine[0].equals("done")) {
                    int index = Integer.parseInt(doneLine[1]) - 1;
                    todoList.get(index).markAsDone();
                    System.out.println(straightLine);
                    System.out.println("Nice! I've marked this task as done: \n"
                            + todoList.get(index).toString());
                    System.out.println(straightLine);
                } else {
                    // String Parsing
                    String typeOfTask = doneLine[0];
                    List<String> fullDetailOfTask = new LinkedList<>(Arrays.asList(doneLine));
                    fullDetailOfTask.remove(0);
                    String temp = String.join(" ", fullDetailOfTask);

                    if (typeOfTask.toLowerCase().equals("todo")) {

                        task TODO = new task(temp);
                        if (temp.length() == 0) {
                            throw new dukeException(EMPTY_TODO_DESC);
                        }
                        todoList.add(TODO);
                        System.out.println(straightLine +
                                "  Got it. I've added this task: \n " +
                                "   " + TODO.toString()+ " \n" +
                                "  Now you have " + todoList.size() + " " + "tasks in the list.\n" +
                                straightLine + "\n");

                    } else if (typeOfTask.toLowerCase().equals("deadline")) {

                        if (temp.length() == 0) {
                            throw new dukeException(EMPTY_DEAD_DESC);
                        }
                        String[] actualTask = temp.split("/by");
                        deadline DEADLINE = new deadline(actualTask[0], actualTask[1]);
                        DEADLINE.setDateAndTime(dateAndTimeHandler.getDateAndTime(actualTask[1]));
                        todoList.add(DEADLINE);

                        System.out.println(straightLine +
                                "  Got it. I've added this task: \n " +
                                "   " + DEADLINE.toString() + " \n" +
                                "  Now you have " + todoList.size() + " " + "tasks in the list.\n" +
                                straightLine + "\n");

                    } else if (typeOfTask.toLowerCase().equals("event")) {

                        if (temp.length() == 0) {
                            throw new dukeException(EMPTY_EVENT_DESC);
                        }
                        String[] actualTask = temp.split("/at");
                        event EVENT = new event(actualTask[0], actualTask[1]);
                        todoList.add(EVENT);
                        System.out.println(straightLine +
                                "  Got it. I've added this task: \n " +
                                "   " + EVENT.toString() + " \n" +
                                "  Now you have " + todoList.size() + " " + "tasks in the list.\n" +
                                straightLine + "\n");
                    } else {
                        throw new dukeException(UNKNOWN_INPUT);
                    }
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


//Array List of to-do
//List<task> todoList = new ArrayList<>();

//Managing the inputs
// Store the List of tasks as a linked list --> easy access and remove
// Store the input of user as a array --> split using  " "
// convert to a linked list
// remove the first word (type of task )  --> join the rest of it as a task
// again split the remaining words based on "/at" or "/by"

//try{
//whole block of code --> in between have if statements for different error and throw the messages needed
//catch ( initialise ex object ){
//print the message }
