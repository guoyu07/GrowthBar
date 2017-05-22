
package utils;


import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public final class TimeUtils {

	private static long currentTime = System.currentTimeMillis();

	public static String getCurrentTime() {
		return new Timestamp(currentTime).toString();
	}
	
	public static int getcurrentYear(){
		return Calendar.getInstance().get(Calendar.YEAR);
	}
	
	public static int getcurrentMonth(){
		return Calendar.getInstance().get(Calendar.MONTH)+1;
	}

	public static String getFormatTime() {
		SimpleDateFormat format = new SimpleDateFormat("yyyy年MM月dd日 HH时mm分ss秒");
		return format.format(new Date());
	}

}
