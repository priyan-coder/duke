package seedu;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * This class assists with sensing the date and time entered and understanding it
 */
public class dateAndTime {

    public Date getDateAndTime(String userInput) throws ParseException {
//        String[] pattern = {"yyyy-MM-dd HH:mm:ss", "dd-MM-yy", "dd-MM-yyyy", "MM-dd-yyyy", "yyyy-MM-dd", "yyyy-MM-dd HH:mm:ss"};
        String pattern = "d/M/y HHmm";

//        int i = 0;
//        Date dateAndTime = null;
//        while (i < 6) {
        Date dateAndTime = null;
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
            dateAndTime = simpleDateFormat.parse(userInput);
        } catch (Exception ex) {
            System.out.println("ENTER IN THE FOLLOWING FORMAT --> d/M/y HHmm");
        }
        return dateAndTime;
    }


}
