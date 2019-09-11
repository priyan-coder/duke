package seedu;

import java.util.Date;

public class deadline extends todo {
    protected String by; // the deadline
    protected Date dateAndTime;

    public deadline(String todo, String by) {
        super(todo);
        this.by = by;
        this.icon = "[D]";
    }

    public String getBy() {
        return " (by: " + this.dateAndTime.toString() + ")";
    }

    @Override
    public String toString() {
        return super.toString() + this.getBy();
    }

    public void setDateAndTime(Date dateAndTime) {
        this.dateAndTime = dateAndTime;
    }
}
