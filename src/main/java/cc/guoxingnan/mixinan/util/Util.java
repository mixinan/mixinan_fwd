package cc.guoxingnan.mixinan.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Util {
	
	public static String getCurrentTime(){
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String current = sdf.format(date);
		return current;
	}
}
