public class deadline extends task {
    protected String by; // the deadline

    public deadline(String todo, String by) {
        super(todo);
        this.by = by;
        this.icon = "[D]";
    }

    public String getBy() {
        return " (by: " + by + ")";
    }
}
