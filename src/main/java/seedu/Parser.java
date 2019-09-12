package seedu;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Parses the input and splits based on the type of task
 */

public class Parser {

    Ui ui = new Ui();

    protected String[] doneLine; // split up user entry using " " to identify type of task
    protected String line;
    protected String typeOfTask;
    protected List<String> fullDetailOfTask; // we will remove the typeOfTask and keep the rest in array form
    protected String temp; // the joined array into a string
    protected String by = " ";
    protected String at = " ";
    protected String taskDescription = " ";
    protected int index = -1;
    protected String searchTaskDescription = " ";
    protected String[] duration = {};


    // line refers to the user entered input
    public Parser(String line) throws dukeException {
        this.line = line;
        this.doneLine = line.split(" "); // delimiter --> so for every " " breaks up and adds to the array of strings
        this.typeOfTask = this.doneLine[0].toLowerCase();
        this.fullDetailOfTask = new LinkedList<>(Arrays.asList(this.doneLine));
        this.fullDetailOfTask.remove(0);
        this.temp = String.join(" ", this.fullDetailOfTask);
        this.createTask();

    }

    // Based on input getting the by or at and the task description ready for passing to the required kind of task
    public void createTask() throws dukeException {
        if (this.typeOfTask.equals("deadline")) {
            String[] actualTask = this.temp.split("/by");
            try {
                this.by = actualTask[1];
                this.taskDescription = actualTask[0];
            } catch (Exception E) {

            }

        } else if (this.typeOfTask.equals("event")) {
            String[] actualTask = this.temp.split("/at");
            try {
                this.at = actualTask[1];
                this.taskDescription = actualTask[0];
                this.duration = actualTask[1].split("-");

            } catch (Exception E) {

            }

        } else if (this.typeOfTask.equals("todo")) {
            this.taskDescription = this.temp;

        } else if (this.typeOfTask.equals("done")) {
            try {
                this.index = Integer.parseInt(this.doneLine[1]) - 1;
            } catch (Exception E) {

            }

        } else if (this.typeOfTask.equals("find")) {
            try {
                this.searchTaskDescription = this.doneLine[1];
            } catch (Exception E) {
            }
        } else if (this.typeOfTask.equals("delete")) {
            try {
                this.index = Integer.parseInt(this.doneLine[1]) - 1;
            } catch (Exception E) {

            }
        }
    }

    public String getTypeOfTask() {
        return typeOfTask;
    }

    public String getTaskDescription() {
        return taskDescription;
    }

    public String getBy() {
        return by;
    }

    public String getAt() {
        return at;
    }

    public int getIndex() {
        return index;
    }

    public String getSearchTaskDescription() {
        return searchTaskDescription;
    }

    public String[] getDuration() {
        return duration;
    }
}
