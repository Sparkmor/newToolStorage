package datesComparing;

import javafx.scene.control.TextArea;
import org.joda.time.LocalDate;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import reportUser.ReportDeptor;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateDeptor  {
    private static String deptorA;
    public static void receivingDateString(TextArea textDeptors, String recipientConn,
                                           String stationConn,
                                           String nominationConn,
                                           String sizeConn,
                                           String indexConn,
                                           String dateOfIssueConn,
                                           String returnDateConn,
                                           String detailConn,
                                           String iD)   {

        String s = returnDateConn.toString();

        LocalDate today = new LocalDate();
        DateTimeFormatter format = DateTimeFormat.forPattern("dd.MM.yyyy");

        String a = today.toString(format);

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
        Date dateUser = null;
        try {
            dateUser = dateFormat.parse(s);

        Date dateToday = dateFormat.parse(a);
            System.out.println(dateToday + " " + dateUser);


        if (dateToday.compareTo(dateUser) == 1) {
            System.out.println("отдай  " + recipientConn);
            //textDeptor.add(recipientConn + " " + stationConn + " " + nominationConn + " " + sizeConn + " " + indexConn + " " + detailConn);
             deptorA = recipientConn + " " + stationConn + " " + nominationConn + " " + sizeConn + " " + indexConn + " " + detailConn;
            ReportDeptor.goPrintDeptors(deptorA, textDeptors);

        }else if (dateToday.compareTo(dateUser) == 0) {
            System.out.println("отдай  " + recipientConn);
            //textDeptor.add(recipientConn + " " + stationConn + " " + nominationConn + " " + sizeConn + " " + indexConn + " " + detailConn);
             deptorA =  recipientConn + " " + stationConn + " " + nominationConn + " " + sizeConn + " " + indexConn + " " + detailConn;
             ReportDeptor.goPrintDeptors(deptorA, textDeptors);
        }
    } catch (ParseException e) {
        e.printStackTrace();
    }
    }
}
