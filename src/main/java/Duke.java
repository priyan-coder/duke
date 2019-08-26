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


        ArrayList<String> ar = new ArrayList<String>();
        while (true) {
            //String[] myStringArray = new String[100];
            Scanner sc = new Scanner(System.in);
            String line = sc.nextLine();

            if(line.toLowerCase().equals("bye")){
                System.out.println(" Bye. Hope to see you again soon!\n");
                ar.clear();
                break;
            }else if (line.toLowerCase().equals("list")){

                System.out.println( "____________________________________________________________ \n");

                for(int i = 0; i < ar.size(); ++i){
                    System.out.println((i+1) + ". " + ar.get(i));
                }

                System.out.println( "____________________________________________________________ \n");
            }else{
                ar.add(line);
                System.out.println(" ____________________________________________________________\n" +
                        "     added: " + line + " \n" +
                        " ____________________________________________________________\n" +
                        "\n");
            }

        }
    }
}
