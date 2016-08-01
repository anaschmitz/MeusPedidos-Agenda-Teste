package utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {

	public final static String BR_PATTERN = "dd/MM/yyyy";
	public final static String HOUR_PATTERN = "HH:mm";

	public static String getDateFormatted(Date date, String pattern) {
		SimpleDateFormat format = new SimpleDateFormat(pattern);
		return format.format(date);
	}

}
