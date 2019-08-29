import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class dataHandler {

    public static List<task> loader() throws IOException, ClassNotFoundException {
        FileInputStream fileInputStream = new FileInputStream(System.getProperty("user.dir") + "taskData.txt");
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        List<task> todoList = (List<task>) objectInputStream.readObject();
        objectInputStream.close();
        return todoList;
    }


    public static void writer(List<task> todoList) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream(System.getProperty("user.dir") + "taskData.txt");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(todoList);
        objectOutputStream.close();
    }

    // references to https://stackoverflow.com/questions/16111496/java-how-can-i-write-my-arraylist-to-a-file-and-read-load-that-file-to-the

}
