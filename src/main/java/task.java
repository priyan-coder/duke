// every non list / non bye is a task
// add to the arrayList of task
// each task has a status
// status whether done or not done
// if the user says done 2 -- > we

public class task {
    protected boolean done = false; // is it done yet ?
    protected char status = '\u2716'; //cross
    protected String todo = " "; // description

    //markAsDone
    public void markAsDone ( ){
        this.done = true;
        this.status = '\u2714'; // tick
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
    public char getStatus() {
        return status;
    }

    //changes the description of the todo
    public void setTodo(String todo) {
        this.todo = todo;
    }
}
