import java.io.IOException;
import java.text.ParseException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Ui {

    protected String logo = " ____        _        \n"
            + "|  _ \\ _   _| | _____ \n"
            + "| | | | | | | |/ / _ \\\n"
            + "| |_| | |_| |   <  __/\n"
            + "|____/ \\__,_|_|\\_\\___|\n";

    protected String straightLine = "____________________________________________________________ \n";
    protected String UNKNOWN_INPUT = " ☹ OOPS!!! I'm sorry, but I don't know what that means :-(\n";
    protected String EMPTY_EVENT_DESC = "☹ OOPS!!! The description of an event cannot be empty.\n" +
            "ENTER IN THE FOLLOWING FORMAT --> e.g event attend sep talk /at 23/12/2019 1700 - 23/12/2019 1800\n";
    protected String EMPTY_TODO_DESC = "☹ OOPS!!! The description of a todo cannot be empty.\n" +
            "ENTER IN THE FOLLOWING FORMAT --> e.g todo return book ";
    protected String EMPTY_DEAD_DESC = "☹ OOPS!!! The description of a deadline cannot be empty.\n" +
            "ENTER IN THE FOLLOWING FORMAT --> e.g deadline eat lunch /by 5/9/2019 1200\n";
    protected String WRONG_DATE_AND_TIME_FORMAT = "ENTER IN THE FOLLOWING FORMAT --> d/M/y HHmm\n";
    protected String INCORRECT_DONE_FORMAT = "CHOOSE A TASK TO MARK AS DONE --->  e.g done 3 \n";
    protected String INCORRECT_DELETE_FORMAT = "EITHER LIST IS EMPTY OR YOUR ENTRY FORMAT IS WRONG \n" +
            "ENTER IN THE FOLLOWING FORMAT ---> e.g delete 3";
    protected String INCORRECT_FIND_FORMAT = "EITHER THE TASK SEARCHED DOESN'T EXIST OR ENTRY FORMAT IS WRONG \n" +
            "ENTER IN THE FOLLOWING FORMAT ---> e.g. find book\n";


    public String getLogo() {
        return logo;
    }

    public void getSLine() {
        System.out.println(straightLine);
    }

    public String getUNKNOWN_INPUT() {
        return UNKNOWN_INPUT;
    }

    public String getEMPTY_EVENT_DESC() {
        return EMPTY_EVENT_DESC;
    }

    public String getEMPTY_TODO_DESC() {
        return EMPTY_TODO_DESC;
    }

    public String getEMPTY_DEAD_DESC() {
        return EMPTY_DEAD_DESC;
    }

    public void welcomeUser() {
        System.out.println(logo + "\n" + "Hello! I'm Duke\n" +
                "     What can I do for you?\n");
    }

    public void listTasks() {
        System.out.println("  Here are the tasks in your list: \n");
    }

    public void removedTask() {
        System.out.println("  Noted! I've removed this todo: \n");
    }

    public void findTask() {
        System.out.println("Here are the matching tasks in your list:\n");
    }

    public void byeUser() {
        System.out.println(" Bye. Hope to see you again soon!\n");
    }

    public void doneTask() {
        System.out.println("Noted! I've marked this todo as done: \n");
    }

    public void addedTask() {
        System.out.println("Got it. I've added this todo: \n ");
    }

    public String getWRONG_DATE_AND_TIME_FORMAT() {
        return WRONG_DATE_AND_TIME_FORMAT;
    }

    public String getINCORRECT_DONE_FORMAT() {
        return INCORRECT_DONE_FORMAT;
    }

    public String getINCORRECT_DELETE_FORMAT() {
        return INCORRECT_DELETE_FORMAT;
    }

    public String getINCORRECT_FIND_FORMAT() {
        return INCORRECT_FIND_FORMAT;
    }
}


