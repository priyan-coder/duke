import java.text.ParseException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class TaskList {

    Ui ui = new Ui();
    dateAndTime dateAndTimeHandler = new dateAndTime();

    public void listTasks(List<todo> todoList) {
        ui.getSLine();
        ui.listTasks();
        for (int i = 0; i < todoList.size(); ++i) {
            System.out.println(
                    (i + 1) + ". " + todoList.get(i).toString());
        }
        ui.getSLine();
    }

    public void taskDone(List<todo> todoList, int index) {
        todoList.get(index).markAsDone();
        ui.getSLine();
        ui.doneTask();
        System.out.println(todoList.get(index).toString());
        ui.getSLine();
    }

    public void deleteTask(List<todo> todoList, int index) {
        ui.getSLine();
        ui.removedTask();
        System.out.println("   " + todoList.get(index).toString() + " \n" +
                "  Now you have " + (todoList.size() - 1) + " " + "tasks in the list.\n");
        ui.getSLine();
        todoList.remove(index);
    }

    public void findTask(List<todo> todoList, String searchTask) {
        ui.findTask();
        for (int i = 0; i < todoList.size(); i++) {
            if (todoList.get(i).getDescription().contains(searchTask)) {
                System.out.println((i + 1) + ". " + todoList.get(i).toString());
            }
        }
    }

    public void addTodo(List<todo> todoList, String taskDescription) throws dukeException {
        todo TODO = new todo(taskDescription);
        if (taskDescription.length() == 0) {
            throw new dukeException(ui.getEMPTY_TODO_DESC());
        }
        todoList.add(TODO);
        ui.getSLine();
        ui.addedTask();
        System.out.println("   " + TODO.toString() + " \n" +
                "  Now you have " + todoList.size() + " " + "tasks in the list.\n");
        ui.getSLine();
    }

    public void addDeadline(List<todo> todoList, String taskDescription, String by) throws dukeException, ParseException {
        if (taskDescription.equals(" ") && by.equals(" ")) {
            throw new dukeException(ui.getEMPTY_DEAD_DESC());
        } else if (!taskDescription.equals(" ") && by.equals(" ")) {
            throw new dukeException(ui.getWRONG_DATE_AND_TIME_FORMAT());
        } else {
            deadline DEADLINE = new deadline(taskDescription, by);
            DEADLINE.setDateAndTime(dateAndTimeHandler.getDateAndTime(by));
            todoList.add(DEADLINE);

            ui.getSLine();
            ui.addedTask();
            System.out.println(
                    "   " + DEADLINE.toString() + " \n" +
                            "  Now you have " + todoList.size() + " " + "tasks in the list.\n");
            ui.getSLine();
        }

    }

    public void addEvent(List<todo> todoList, String taskDescription, String at, String duration[]) throws dukeException, ParseException {

        if (taskDescription.equals(" ") || at.equals(" ")) {
            throw new dukeException(ui.getEMPTY_EVENT_DESC());
        } else {
            event EVENT = new event(taskDescription, at);
            EVENT.time_1 = dateAndTimeHandler.getDateAndTime(duration[0]).toString();
            EVENT.time_2 = dateAndTimeHandler.getDateAndTime(duration[1]).toString();
            todoList.add(EVENT);
            ui.getSLine();
            ui.addedTask();
            System.out.println(
                    "   " + EVENT.toString() + " \n" +
                            "  Now you have " + todoList.size() + " " + "tasks in the list.\n");
            ui.getSLine();
        }
    }


}
