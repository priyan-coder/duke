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

        while (true) {
            Scanner sc = new Scanner(System.in);
            String line = sc.nextLine();

            if(line.toLowerCase().equals("bye")){
                System.out.println(" Bye. Hope to see you again soon!\n");
                break;
            }else{
                System.out.println(line);
            }

        }
    }
}
