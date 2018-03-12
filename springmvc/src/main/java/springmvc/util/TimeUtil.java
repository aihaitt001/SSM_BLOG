package springmvc.util;

import java.sql.Timestamp;
import java.util.Date;

public class TimeUtil {
	public static Timestamp now() {
		Date date = new Date();
		Timestamp now = new Timestamp(date.getTime());
		return now;
	}

}
