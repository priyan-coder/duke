package seedu;

public class event extends todo {

    protected String at; // duration
    protected String time_1;
    protected String time_2;

    public event(String todo, String at) {
        super(todo);
        this.at = at;
        this.icon = "[E]";
    }

    public String getAt() {
        return " (at: " + this.time_1 + " to " + this.time_2 + ")";
    }

    @Override
    public String toString() {
        return super.toString() + this.getAt();
    }

}
