package grp.wudi.j2ee.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFormat {
	/**
	 * 用于将日期类型转换为字符串类型
	 * @param date 日期类
	 * @return	formatStr 标准格式的日期字符串
	 */
	public static String dataFormatToStr(Date date) {
		SimpleDateFormat date1 =  new SimpleDateFormat("yyyy-MM-dd");
		String formatStr = date1.format(date);
		return formatStr;
	}
}
