package training.weather.utils;
import java.text.SimpleDateFormat;
import java.util.Date;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

import java.util.Calendar;

public class DateUtilsTest {

    /**
     * Method to test AddDays from Date.Utils
     */
    @Test
    public  void AddDaysTest(){
        Date now = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(now);
        cal.add(Calendar.DATE,2);
        Date afterTwoDays = cal.getTime();
        DateUtils.AddDays(now,2);
        assertEquals(afterTwoDays, DateUtils.AddDays(now,2));
    }

    /**
     * Method to test FormatDateMethod from DateUtils
     */
    @Test
    public void FormatDateTest(){
        Date now = new Date();
        String formatToTest = "yyyy-MM-dd-HH-mm-ss";
        String formattedDate = new SimpleDateFormat(formatToTest).format(now);
        assertEquals(formattedDate,DateUtils.FormatDate(formatToTest,now));
    }
}
