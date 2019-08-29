import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class dateAndTime {

    public Date getDateAndTime(String userInput) throws ParseException {
//        String[] pattern = {"yyyy-MM-dd HH:mm:ss", "dd-MM-yy", "dd-MM-yyyy", "MM-dd-yyyy", "yyyy-MM-dd", "yyyy-MM-dd HH:mm:ss"};
        String pattern = "dd/MM/yyyy HH:mm";

//        int i = 0;
//        Date dateAndTime = null;
//        while (i < 6) {
        Date dateAndTime = null;
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
            dateAndTime = simpleDateFormat.parse(userInput);
        } catch (Exception ex) {
            System.out.println("ENTER IN THE FOLLOWING FORMAT --> dd/MM/yyyy HH:mm");
        }
        return dateAndTime;
    }

//    public String convert12(String str)
//    {
//        // Get Hours
//        int h1 = (int)str.charAt(0) - '0';
//        int h2 = (int)str.charAt(1)- '0';
//
//        int hh = h1 * 10 + h2;
//
//        // Finding out the Meridien of time
//        // ie. AM or PM
//        String Meridien;
//
//
//        hh %= 12;
//
//        // Handle 00 and 12 case separately
//        if (hh == 0) {
//            System.out.print("12");
//
//            // Printing minutes and seconds
//            for (int i = 2; i < 8; ++i) {
//                System.out.print(str.charAt(i));
//            }
//        }
//        else {
//            System.out.print(hh);
//            // Printing minutes and seconds
//            for (int i = 2; i < 8; ++i) {
//                System.out.print(str.charAt(i));
//            }
//        }
//
//        // After time is printed
//        // cout Meridien
//        System.out.println(" "+Meridien);
//    }
}
