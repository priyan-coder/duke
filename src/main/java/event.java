import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class event extends task {

    protected String at; // duration
    protected dateAndTime DateAndTime;

    public event(String todo, String at) {
        super(todo);
        this.at = at;
        this.icon = "[E]";
    }

    public String getAt() {
        return " (at: " + this.DateAndTime.toString()+ ")";
    }

    @Override
    public String toString() {
        return super.toString() + this.getAt();
    }

    public void setDateAndTime(dateAndTime dateAndTime) {
        DateAndTime = dateAndTime;
    }
}
