import java.util.ArrayList;
import java.util.Scanner;

public class Duke {
    public static void main(String[] args) {
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";

        System.out.println(logo + "\n"+ "Hello! I'm Duke\n" +
                "     What can I do for you?\n");

        Scanner sc = new Scanner(System.in);
        //Array List of to-do
        ArrayList<task> todoList = new ArrayList<task>();

        String straightLine = "____________________________________________________________ \n";

        while (true) {
            String line = sc.nextLine();
            String[] doneLine = line.split(" "); // delimiter --> so for every " " breaks up and adds to the array of strings


            if(line.toLowerCase().equals("bye")){
                System.out.println(" Bye. Hope to see you again soon!\n");
                todoList.clear();
                break;
            }else if (line.toLowerCase().equals("list")){

                System.out.println(straightLine);
                System.out.println( "  Here are the tasks in your list: \n");

                for(int i = 0; i < todoList.size(); ++i){
                    System.out.println((i+1) + ". " + "[" +todoList.get(i).getStatus()+"] "+todoList.get(i).getTodo());
                }

                System.out.println(straightLine);

            }else if ( doneLine[0].equals("done")){
                int index = Integer.parseInt(doneLine[1]) -1;
                todoList.get(index).changeStatus();
                System.out.println(straightLine);
                System.out.println("Nice! I've marked this task as done: \n" + (index+1) + ". " + "[" +todoList.get(index).getStatus()+"] "+todoList.get(index).getTodo());
                System.out.println(straightLine);

            }

            else{
                task Todo = new task();
                Todo.setTodo(line);
                todoList.add(Todo);
                System.out.println(straightLine +
                        "     added: " + line + " \n" +
                        straightLine +
                        "\n");
            }

        }

        sc.close();
    }
}
