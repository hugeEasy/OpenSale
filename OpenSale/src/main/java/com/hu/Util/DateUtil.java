/**
 * 描述： 用于处理日期相关
 * 版权所有：HugeDog 软件研发中心
 * Copy Right: Copyright(C) 2016-2017
 * @author: huge
 * @version V1.0
 * 
 * 创建时间：@2016年9月23日
 * 修改时间		修改人员		 版本号		描述
 * 
 */
package com.hu.Util;

import java.sql.Timestamp;
import java.text.*;
import java.util.*;

public class DateUtil {


	/**
	 * 精确到分的日期格式 yyyyMMddHHmmss MINUTE_FORMAT1
	 */
	public static final String MINUTE_FORMAT1   = "yyyyMMddHHmmss";
	/**
	 * 日期格式 yyyyMMdd
	 */
	public static final String FILE_FORMAT1   = "yyyyMMdd";
	/**
	 * 日期格式 HHmmss
	 */
	public static final String FILE_FORMAT3   = "HHmmss";
	
	/**
	 * 日期格式 HH:mm:ss
	 */
	public static final String FILE_FORMAT2   = "HH:mm:ss";
	
	
	private DateUtil() {
		
	}
	
	/**
	 * 获取输入的日期时间，获取对应的掩码格式
	 * @param strDate 时间或日期字符串
	 * @return 掩码格式，例如 
	 * yyyy-MM-dd 
	 * yyyy/MM/dd 
	 * yyyyMMdd
	 * yyyy年MM月dd日
	 * yyyy-MM-dd-HH-mm-ss
	 * yyyyMMddHHmmss
	 * yyyy-MM-dd HH:mm:ss
	 * yyyy/MM/dd HH:mm:ss
	 * yyyy年MM月dd日 HH时mm分ss秒
	 * HH时mm分ss秒
	 * HH:mm:ss
	 */
	public static String getPartten(String strDate)
	{
		strDate = strDate.trim();
		if(strDate!=null) {
			if(strDate.matches("^\\d{4}-\\d{2}-\\d{2}$")) {
				return "yyyy-MM-dd";
			}else if (strDate.matches("^\\d{4}\\d{2}\\d{2}$")) {
				return "yyyyMMdd";
			}else if (strDate.matches("^\\d{4}/\\d{2}/\\d{2}$")) {
				return "yyyy/MM/dd";
			}else if (strDate.matches("^\\d{4}年\\d{2}月\\d{2}日$")) {
				return "yyyy年MM月dd日";
			}else if (strDate.matches("^\\d{4}-\\d{2}-\\d{2}-\\d{2}-\\d{2}-\\d{2}$")) {				
				return "yyyy-MM-dd-HH-mm-ss";
			}else if (strDate.matches("^\\d{4}\\d{2}\\d{2}\\d{2}\\d{2}\\d{2}$")) {				
				return "yyyyMMddHHmmss";
			}else if(strDate.matches("^\\d{4}-\\d{2}-\\d{2}\\s+\\d{2}:\\d{2}:\\d{2}\\.0$")){
				return "yyyy-MM-dd HH:mm:ss";	
			}else if (strDate.matches("^\\d{4}-\\d{2}-\\d{2}\\s+\\d{2}:\\d{2}:\\d{2}$")) {				
				return "yyyy-MM-dd HH:mm:ss";
			}else if (strDate.matches("^\\d{4}/\\d{2}/\\d{2}\\s+\\d{2}:\\d{2}:\\d{2}$")) {				
				return "yyyy/MM/dd HH:mm:ss";
			}else if (strDate.matches("^\\d{4}年\\d{2}月\\d{2}日\\s+\\d{2}时\\d{2}分\\d{2}秒$")) {				
				return "yyyy年MM月dd日 HH时mm分ss秒";
			}else if (strDate.matches("^\\d{2}:\\d{2}:\\d{2}$")) {
				return "HH:mm:ss";
			}else if (strDate.matches("^\\d{2}时\\d{2}分\\d{2}秒$")) {
				return "HH时mm分ss秒";
			}
		}
		return null;
	}
	/**
	 * 将符合日期格式的字符串转化为日期对象
	 * <p>
	 * 符合这样日期格式的
	 * yyyyMMdd
	 * yyyy/MM/dd 
	 * yyyy-MM-dd 
	 * yyyy年MM月dd日
	 * yyyyMMddHHmmss
	 * yyyy/MM/dd HH:mm:ss 
	 * yyyy-MM-dd HH:mm:ss 
	 * yyyy年MM月dd日 HH时mm分ss秒
	 * HH时mm分ss秒 
	 * HH:mm:ss 
	 * </p>
	 * @param dateStr 日期字符串
	 * @return 日期对象
	 */
	public static Date toDate(String dateStr) throws Exception{
		String formatStr = getPartten(dateStr);
		if ( formatStr == null) {
			throw new Exception("无效的日期格式");
		}else if (formatStr.equals("yyyy年MM月dd日 HH时mm分ss秒") || formatStr.equals("yyyy年MM月dd日") || formatStr.equals("HH时mm分ss秒")) {
			dateStr.replaceAll("年|月|日|时|分|秒", "");
			formatStr = getPartten(dateStr);
		}
		try{
			SimpleDateFormat format = new SimpleDateFormat(formatStr);
			return format.parse(dateStr);
		}catch(Exception e){
			return null;
		}
	}

	/**
	 * 将时间戳对象转换为日期对象
	 * @param timestamp 时间戳对象
	 * @return 日期对象
	 */
	public static Date toDate(Timestamp timestamp) {
		return new Date(timestamp.getTime());
	}
	/**
	 * 将输入的日期对象根据日期掩码方式输出为字符串
	 * @param cal 输入的日历
	 * @param pattern 日期掩码
	 * @return 字符串
	 */
	public static String toString(java.util.Calendar cal, String pattern) {
		return toString(cal.getTime(), pattern);
	}
	/**
	 * 将日期对象转换为日历对象
	 * @param date 日期对象
	 * @return 日历对象
	 */
	public static Calendar toCalendar(Date date) {
		GregorianCalendar gc = (GregorianCalendar) Calendar.getInstance();
		gc.setTime(date);
		return gc;
	}
	
	/**
	 * 将日期对象转换为时间戳对象
	 * @param date 日期对象
	 * @return 时间戳对象
	 */
	public static Timestamp toTimestamp(Date date) {
		Timestamp timestamp = new Timestamp(date.getTime());
		return timestamp;
	}
	/**
	 * 将输入的日期对象根据日期掩码方式输出为字符串
	 * @param date 输入的日期
	 * @param pattern 日期掩码
	 * @return 字符串
	 */
	public static String toString(java.util.Date date, String pattern) {
		SimpleDateFormat sdf = new SimpleDateFormat();
		String str = null;
		sdf.applyPattern(pattern);
		str = sdf.format(date);
		return str;
	}
	
	/**
	 * 将日期对象输出为yyyyMMddHHmmss字符串 格式为 20110909090909
	 * @param date 日期对象
	 * @return 字符串形式的日期
	 */
	public static String toStringByFileFormat2(Date date){
		return toStringByFileFormat2(toCalendar(date));
	}
	/**
	 * 将日历对象输出为yyyyMMddHHmmss字符串 格式为 20110909090909
	 * @param cal 日历对象
	 * @return 字符串形式的日期
	 */
	public static String toStringByFileFormat2(Calendar cal){
		return toString(cal, MINUTE_FORMAT1);
	}

	/**
	 * 将日期对象输出为HHmmss字符串 格式为 090909
	 * @param date 日期对象
	 * @return 字符串形式的日期
	 */
	public static String toStringByFileFormat3(Date date){
		return toStringByFileFormat3(toCalendar(date));
	}
	/**
	 * 将日历对象输出为HHmmss字符串 格式为 090909
	 * @param cal 日历对象
	 * @return 字符串形式的日期
	 */
	public static String toStringByFileFormat3(Calendar cal){
		return toString(cal, FILE_FORMAT3);
	}

	/**
	 * 将日期对象输出为yyyyMMdd字符串 格式为 20110909
	 * @param date 日期对象
	 * @return 字符串形式的日期
	 */
	public static String toStringByFileFormat1(Date date){
		return toStringByFileFormat1(toCalendar(date));
	}
	/**
	 * 将日历对象输出为yyyyMMdd字符串 格式为 20110909
	 * @param cal 日历对象
	 * @return 字符串形式的日期
	 */
	public static String toStringByFileFormat1(Calendar cal){
		return toString(cal, FILE_FORMAT1);
	}
	
	/**
	 * 将时间戳对象输出为字符串  格式为 201191 2011101 2011911 20111211
	 * @param timestamp 时间戳对象
	 * @return 字符串形式的日期
	 */
	public static String toString(Timestamp timestamp){
		return toString(toDate(timestamp));
	}
	
	/**
	 * 将日期对象输出为字符串  格式为 201191 2011101 2011911 20111211
	 * @param date 日期对象
	 * @return 字符串形式的日期
	 */
	public static String toString(Date date){
		GregorianCalendar gc = (GregorianCalendar) Calendar.getInstance();
		gc.setTime(date);
		return toString(gc);
	}
	/**
	 * 将日历对象输出为字符串 格式为 201191 2011101 2011911 20111211
	 * @param cal 日历对象
	 * @return 字符串形式的日期
	 */
	public static String toString(Calendar cal){
		String startDate = "";
		startDate = startDate + cal.get(Calendar.YEAR);
		int i = cal.get(Calendar.MONTH);
		i = i + 1;
		startDate = startDate + i;
		startDate = startDate + cal.get(Calendar.DATE);
		return startDate;
	}

	/**
	 * Date 转 String 无时分秒
	 * 
	 * @param date 
	 * formateStr 转换格式 如:YYYYMMDD
	 * @return  
	 */
	public static String dateToString(Date date,String formateStr) throws Exception  {
	    SimpleDateFormat sdf = new SimpleDateFormat(formateStr);
	    return sdf.format(date);
	}

	/**
	 * 获取当前系统日期
	 * @param  无参数
	 * @return 字符串  如：2014-01-01
	 *  @throws Exception
	 */
	public static String toStringDate()throws Exception{
		Date date = new Date();
		return DateUtil.toStringByFileFormat1(date);
	}
	/**
	 * 获取当前系统时间
	 * @param 无参
	 * @return 字符串 如：20141212090909
	 * @throws Exception
	 */
	public static String toStringTime()throws Exception{
		Date date = new Date();
		return DateUtil.toString(date, MINUTE_FORMAT1);
	}
	
	/**
	 * 将日历对象输出为HH:mm:ss字符串 格式为 09:09:09
	 * @param cal 日历对象
	 * @return 字符串形式的日期
	 */
	public static String toStringByFileFormat4(Calendar cal)throws Exception{
		return toString(cal, FILE_FORMAT2);
	}
	/**
	 * 将日期对象输出为HH:mm:ss字符串 格式为 09:09:09
	 * @param date 日期对象
	 * @return 字符串形式的日期
	 */
	public static String toStringByFileFormat4(Date date)throws Exception{
		return toStringByFileFormat4(toCalendar(date));
	}
	/**
	 * 两个时间进行比较大小
	 * @param firstDate 时间1
	 * @param lastDate 时间2 
	 * @return -1小于， 0等于， 1大于
	 * @throws Exception
	 */
	public static int toCompareDate(String firstDate,String lastDate) throws Exception{
		SimpleDateFormat sdf = new SimpleDateFormat();
		sdf.setLenient(false);
		sdf.applyPattern("HHmmss");
		//将比较的时间转换成微妙
		long time1 = sdf.parse(firstDate).getTime();
		long time2 = sdf.parse(lastDate).getTime();
		//进行比较
		int result  = StringUtil.strCompareTo(String.valueOf(time1),String.valueOf(time2));
		return result;
	}
	/**
	 * String 转  Date 无时分秒
	 * @param stringdate
	 * @return //eg:20150802 
	 */
	public static Date stringToDate(String stringDate) throws Exception  {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		sdf.setLenient(false);
		Date date = sdf.parse(stringDate);
		return date;
	}
	/**
	 * String 转  Time
	 * @param stringdate
	 * @return //eg:122323
	 */
	public static Date stringToShortTime(String stringTime) throws Exception  {
		SimpleDateFormat sdf = new SimpleDateFormat("HHmmss");
		sdf.setLenient(false);
		Date time = sdf.parse(stringTime);
		return time;
	}
	/**
	 * String 转  Time
	 * @param stringdate
	 * @return //eg:20141221122323
	 */
	public static Date stringToTime(String stringTime) throws Exception  {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		sdf.setLenient(false);
		Date time = sdf.parse(stringTime);
		return time;
	}

	public static void main(String args[]) throws Exception{
		System.out.println(DateUtil.stringToDate("19001202"));
		System.out.println(DateUtil.stringToTime("19001202230059"));
		System.out.println(DateUtil.stringToShortTime("230059"));
		int num = DateUtil.toCompareDate("213321", "213321");
		System.out.println(num);
	}

}
