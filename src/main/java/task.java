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

public class task implements Serializable {
    protected boolean done = false; // is it done yet ?
    protected char status = '\u2718'; //cross
    protected String todo = " "; // description
    protected String icon = "[T]"; // the kind of task --> this is a todo


    //markAsDone
    public void markAsDone ( ){
        this.done = true;
        this.status = '\u2713'; // tick
    }

    // constructor to set the todo
    public task(String todo) {
        this.todo = todo;
    }
    // returns the description of the todo
    public String getTodo() {
        return todo;
    }

    //check if tick or cross
    public String getStatus() {
        return "[" + status +"]";
    }

    //changes the description of the todo
    public void setTodo(String todo) {
        this.todo = todo;
    }

    public String toString(){
        return this.getStatus() +  this.icon + " " + this.getTodo();
    }




}
