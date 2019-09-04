// every non list / non bye is a task
// add to the arrayList of task
// each task has a status
// status whether done or not done
// if the user says done 2 -- > we

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.LinkedList;

public class todo implements Serializable {
    protected boolean done = false; // is it done yet ?
    protected char status = '\u2718'; //cross
    protected String description = " "; // description
    protected String icon = "[T]"; // the kind of task --> this is a description

    //markAsDone
    public void markAsDone() {
        this.done = true;
        this.status = '\u2713'; // tick
    }

    // constructor to set the description
    public todo(String description) {
        this.description = description;
    }

    // returns the description of the todo
    public String getDescription() {
        return description;
    }

    //check if tick or cross
    public String getStatus() {
        return "[" + status + "]";
    }

    //changes the description of the todo
    public void setDescription(String description) {
        this.description = description;
    }

    //Returns the entire --> status, icon (Kind of task ) ,description
    public String toString() {
        return this.getStatus() + this.icon + " " + this.getDescription();
    }
}
