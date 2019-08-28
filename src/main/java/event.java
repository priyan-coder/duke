public class event extends task {

    protected String at; // duration

    public event(String todo, String at) {
        super(todo);
        this.at = at;
        this.icon = "[E]";
    }

    public String getAt() {
        return " (at: " + at+ ")";
    }
}
