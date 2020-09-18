package training.weather.utils;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtils {
    /**
     * Add days to a given Date.
     * @param date date to add days
     * @param days days added to date
     * @return date plus days
     */
    public static Date AddDays(Date date, int days){
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DATE, days);
        return  cal.getTime();
    }

    /**
     * Converts a Date object to string with given format
     * @param format string with date time format
     * @param date date to be formatted
     * @return A string containing the date formatted in given format
     */
    public static String FormatDate(String format, Date date){
        return new SimpleDateFormat(format).format(date);
    }
}
