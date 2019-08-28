import java.util.*;

public class Duke {
    public static String straightLine = "____________________________________________________________ \n";


    public static void main(String[] args) {
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";

        System.out.println(logo + "\n"+ "Hello! I'm Duke\n" +
                "     What can I do for you?\n");


        Scanner sc = new Scanner(System.in);
        //Linked List of to-do
        LinkedList<task> todoList = new LinkedList<task>();

        //Managing the inputs
        // Store the List of tasks as a linked list --> easy access and remove
        // Store the input of user as a array --> split using  " "
        // convert to a linked list
        // remove the first word (type of task )  --> join the rest of it as a task
        // again split the remaining words based on "/at" or "/by"
        while (true) {
            String line = sc.nextLine();
            // doneLine refers to the user input which is something like  done 2
            String[] doneLine = line.split(" "); // delimiter --> so for every " " breaks up and adds to the array of strings

            if (line.toLowerCase().equals("bye")) {
                System.out.println(" Bye. Hope to see you again soon!\n");
                todoList.clear();
                break;

            } else if (line.toLowerCase().equals("list")) {
                System.out.println(straightLine);
                System.out.println("  Here are the tasks in your list: \n");
                for (int i = 0; i < todoList.size(); ++i) {
                    System.out.println(
                            (i + 1) + ". " + todoList.get(i).getStatus() + todoList.get(i).icon + " " + todoList.get(i).getTodo());
                }
                System.out.println(straightLine);

            } else if (doneLine[0].equals("done")) {
                int index = Integer.parseInt(doneLine[1]) - 1;
                todoList.get(index).markAsDone();
                System.out.println(straightLine);
                System.out.println("Nice! I've marked this task as done: \n"
                        + todoList.get(index).getStatus() + todoList.get(index).icon + " " + todoList.get(index).getTodo());
                System.out.println(straightLine);
            } else {
                String typeOfTask = doneLine[0];

                if (typeOfTask.toLowerCase().equals("todo")) {
                    List<String> fullDetailOfTask = new LinkedList<>(Arrays.asList(doneLine));
                    fullDetailOfTask.remove(0);
                    String temp = String.join(" ", fullDetailOfTask);
                    task TODO = new task(temp);
                    todoList.add(TODO);
                    System.out.println(straightLine +
                            "  Got it. I've added this task: \n " +
                            "   " + TODO.icon + TODO.getStatus() + " " + TODO.todo + " \n" +
                            "  Now you have " + todoList.size() + " " + "tasks in the list.\n" +
                            straightLine + "\n");

                } else if (typeOfTask.toLowerCase().equals("deadline")) {
                    List<String> fullDetailOfTask = new LinkedList<>(Arrays.asList(doneLine));
                    fullDetailOfTask.remove(0);
                    String temp = String.join(" ", fullDetailOfTask);
                    String[] actualTask = temp.split("/by");
                    deadline DEADLINE = new deadline(actualTask[0], actualTask[1]);
                    todoList.add(DEADLINE);
                    System.out.println(straightLine +
                            "  Got it. I've added this task: \n " +
                            "   " + DEADLINE.icon + DEADLINE.getStatus() + " " + DEADLINE.todo + DEADLINE.getBy() + " \n" +
                            "  Now you have " + todoList.size() + " " + "tasks in the list.\n" +
                            straightLine + "\n");

                } else if (typeOfTask.toLowerCase().equals("event")) {
                    List<String> fullDetailOfTask = new LinkedList<>(Arrays.asList(doneLine));
                    fullDetailOfTask.remove(0);
                    String temp = String.join(" ", fullDetailOfTask);
                    String[] actualTask = temp.split("/at");
                    event EVENT = new event(actualTask[0], actualTask[1]);
                    todoList.add(EVENT);
                    System.out.println(straightLine +
                            "  Got it. I've added this task: \n " +
                            "   " + EVENT.icon + EVENT.getStatus() + " " + EVENT.todo + EVENT.getAt() + " \n" +
                            "  Now you have " + todoList.size() + " " + "tasks in the list.\n" +
                            straightLine + "\n");
                }
            }
        }
        sc.close();
    }

}
