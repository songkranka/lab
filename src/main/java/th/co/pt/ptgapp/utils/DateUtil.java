package th.co.pt.ptgapp.utils;

import org.apache.commons.lang3.time.FastDateFormat;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public class DateUtil {

    public static final TimeZone DEFAULT_TIMEZOME = TimeZone.getDefault();
    public static final Locale DEFAULT_LOCALE = Locale.getDefault();
    public static final Locale ENG_LOCALE = new Locale("en", "US");
    public static final Locale THAI_LOCALE = new Locale("th", "TH");
    public static final String STANDARD_DATE_TIME_PATTERN = "dd/MM/yyyy HH:mm:ss";
    public static final String DATE_PATTERN_DDMMYYYY = "dd/MM/yyyy";
    public static final String DATE_PATTERN_YYYYMMDD = "yyyy/MM/dd";

    public static Date nowDate(Locale locale){
        Calendar calendar = Calendar.getInstance(locale);
        return calendar == null ? null : calendar.getTime();
    }

    public static String nowString(Locale locale){
        Calendar calendar = Calendar.getInstance(locale);
        return calendar == null ? null : calendar.getTime().toString();
    }

    public static String getDisplay(Date date, String pattern, Locale locale) {
        String display = "";
        if(date != null) {
            Calendar calendar = Calendar.getInstance(locale);
            calendar.setTime(date);
            display = FastDateFormat.getInstance(pattern, locale).format(calendar);
        }
        return display;
    }

    public static Date stringTodate(String dateInString,String pattern, Locale locale){
        SimpleDateFormat formatter = new SimpleDateFormat(pattern, locale);
        try {
            return formatter.parse(dateInString);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }
}
