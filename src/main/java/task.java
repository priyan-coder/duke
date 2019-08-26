// every non list / non bye is a task
// add to the arrayList of task
// each task has a status
// status whether done or not done
// if the user says done 2 -- > we

public class task {
    private boolean done = false;
    private char status = '\u2716'; //cross
    private String todo = " ";

    public void changeStatus ( ){
        this.done = true;
        this.status = '\u2714'; // tick
    }

    public String getTodo() {
        return todo;
    }

    public char getStatus() {
        return status;
    }

    public void setTodo(String todo) {
        this.todo = todo;

    }
}
