package service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;

public class regex {

    public String formatDate(String str) throws ParseException {
        SimpleDateFormat format1 = new SimpleDateFormat("dd/mm/yyyy");
        SimpleDateFormat format2 = new SimpleDateFormat("yyyy/mm/dd");
        Date date = format1.parse(str);
        System.out.println(format2.format(date));
        return format2.format(date);
    }

    public long calculateDate(String timeBegin,String timeEnd) {
        String startDate = timeBegin;
        String passedDate = timeEnd;

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate date1 = LocalDate.parse(startDate, formatter);
        LocalDate date2 = LocalDate.parse(passedDate, formatter);

        long elapsedDays = ChronoUnit.MONTHS.between(date1, date2);
        System.out.println(elapsedDays);
        return elapsedDays;
    }

    public static void main(String[] args) throws ParseException {
        regex regex = new regex();
        regex.calculateDate("01/01/2021", "02/02/2021");
//
//        SimpleDateFormat format1 = new SimpleDateFormat("dd/mm/yyyy");
//        SimpleDateFormat format2 = new SimpleDateFormat("yyyy/mm/dd");
//        Date date = format1.parse("15/07/2021");
//        System.out.println(format2.format(date));

//
//        String startDate = "04/02/2020";
//        String passedDate = "03/03/2021";
//
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
//        LocalDate date1 = LocalDate.parse(startDate, formatter);
//        LocalDate date2 = LocalDate.parse(passedDate, formatter);
//
//        int elapsedDays = (int) ChronoUnit.MONTHS.between(date1, date2);
//        System.out.println(elapsedDays);
//        Calendar c1 = Calendar.getInstance();
//
//        // set Month
//        // MONTH starts with 0 i.e. ( 0 - Jan)
//        c1.set(Calendar.MONTH, 11);
//
//        // set Date
//        c1.set(Calendar.DATE, 5);
//
//        // set Year
//        c1.set(Calendar.YEAR, 2000);
//
//        // creating a date object with specified time.
//        String b = "2021/01/01";
//        Date dateOne = c1.getTime();
//
//        System.out.println("Date: " + dateOne);
//
//        System.out.println(dateOne.getTime());
    }
}
