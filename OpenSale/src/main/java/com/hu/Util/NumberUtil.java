/**
 * 描述：
 *         数字转换工具类
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

import java.math.BigDecimal;
import java.text.DecimalFormat;
/**
 * @Description: TODO 
 * @author: Huge 
 * @date: 2016年9月23日
 */
public class NumberUtil {

	/**
	 * 将含有int的字符串转化为int,如果转换失败以defval值返回
	 * @param strValue 输入的字符串
	 * @param defval 如果失败时返回的值
	 * @return int数字
	 */
	public static int parseInt(String strValue, String defval) {
		try {
			if (ErrMsgUtil.isBlank(strValue)) {
				return Integer.parseInt(defval);
			}else {
				return Integer.parseInt(strValue);
			}
		} catch (Exception ex) {
			return Integer.parseInt(defval);
		}
	}
	/**
	 * 将含有double的字符串转化为double,如果转换失败以defval值返回
	 * @param strValue 输入的字符串
	 * @param defval 如果失败时返回的值
	 * @return double数字
	 */
	public static Double parseDouble(String strValue, String defval) {
		try {
			return Double.valueOf(strValue);
		} catch (Exception ex) {
			return Double.valueOf(defval);
		}
	}
	/**
	 * 将含有double的字符串转化为double,如果转换失败以0.00值返回
	 * @param strValue 输入的字符串
	 * @param defval 如果失败时返回的值
	 * @return double数字
	 */
	public static Double parseDouble(String strValue) {
		try {
			return Double.valueOf(strValue);
		} catch (Exception ex) {
			return Double.valueOf(0.00);
		}
	}
	/**
	 * 将含有Float的字符串转化为Float,如果转换失败以defval值返回
	 * @param strValue 输入的字符串
	 * @param defval 如果失败时返回的值
	 * @return Float数字
	 */
	public static Float parseFloat(String strValue, String defval) {
		try {
			return Float.parseFloat(strValue);
		} catch (Exception ex) {
			return Float.parseFloat(defval);
		}
	}
	/**
	 * 将含有大整数的字符串转化为BigDecimal,如果转换失败以defval值返回
	 * @param strValue 输入的字符串
	 * @param defval 如果失败时返回的值
	 * @return BigDecimal对象
	 */
	public static Long parseLong(String strValue, String defval) {
		try {
			return Long.parseLong(strValue);
		} catch (Exception ex) {
			return Long.parseLong(strValue);
		}
	}
	/**
	 * 将含有大整数的字符串转化为BigDecimal,如果转换失败以defval值返回
	 * @param strValue 输入的字符串
	 * @param defval 如果失败时返回的值
	 * @return BigDecimal对象
	 */
	public static BigDecimal parseBigDecimal(String strValue, String defval) {
		try {
			return new BigDecimal(strValue);
		} catch (Exception ex) {
			return new BigDecimal(defval);
		}
	}
	
	/**
	 * 将含有double的字符串转化为double
	 * @param inStr 输入的字符串
	 * @return double数字
	 */
	public static double toDouble(String inStr) {
		return parseDouble(inStr, "0");
	}
	/**
	 * 将含有float的字符串转化为float
	 * @param inStr 输入的字符串
	 * @return float数字
	 */
	public static float toFloat(String inStr) {
		return parseFloat(inStr, "0");
	}

	/**
	 * 将含有BigDecimal的字符串转化为BigDecimal
	 * @param inStr 输入的字符串
	 * @return BigDecimal数字
	 */ 
	public static BigDecimal toBigDecimal(String inStr) {
		return parseBigDecimal(inStr, null);
	}

	/**
	 * 返回一个 BigDecimal，其值为 (inStr / base)，其标度为指定标度。如果必须执行舍入，以生成具有指定标度的结果，则应用指定的舍入模式
	 * @param inStr 输入的字符串 
	 * @param base 基数除数
	 * @param scale 精度
	 * @return BigDecimal数字
	 */
	public static BigDecimal toBigDecimal(String inStr, double base, int scale) {
		try {
			if (inStr == null) {
				return null;
			} else {
				return new BigDecimal(inStr).divide(new BigDecimal(base), scale, BigDecimal.ROUND_HALF_UP);
			}
		} catch (Exception e) {
			return null;
		}
	}
	
	/**
	 * 将输入的字符串转换为long数据
	 * @param inStr long字符串
	 * @return long数字
	 */
	public static long toLong(String inStr) {
		return parseLong(inStr, "0");
	}
	/**
	 * 将输入的BigDecimal数字强制丢失精度转化为long
	 * @param val BigDecimal数字
	 * @return long数字
	 */
	public static long tolong(BigDecimal val) {
		if (val == null) {
			return 0;
		} else {
			return Long.parseLong("" + val);
		}
	}
	
	/**
	 * 将输入的字符串转换为Integer数据
	 * @param inStr Integer字符串
	 * @return Integer数字
	 */
	public static int toInteger(Object inStr) {
		return parseInt(inStr == null ? null: inStr.toString(), "0");
	}
	/**
	 * 将输入的字符串转换为Integer数据
	 * @param inStr Integer字符串
	 * @return Integer数字
	 */
	public static int toInteger(String inStr) {
		return parseInt(inStr, "0");
	}

	/**
	 * 将输入的数字格式化为保留两位小数的字符串
	 * @param obj 输入对象
	 */
	public static String numberFormat2(Object obj){
		if(obj==null){
			return "0";
		}else{
			return numberFormat(obj, "0.00");
		}
		
	}
	/**
	 * 将输入的数字格式化为字符串
	 * @param obj 输入对象
	 * @param pattern 格式化掩码
	 * @return 格式化后的数字符串
	 */
	public static String numberFormat(Object obj, String pattern){
		BigDecimal bd = null;
		if(obj == null || obj.equals("") || obj.equals("0")){
			bd = new BigDecimal(0);
		}
		bd = new BigDecimal(obj.toString());
		DecimalFormat format = new DecimalFormat(pattern);
		
		return format.format(bd);
	}
	/**
	 * 字符串object不足num位，用fillChar填充
	 * @param object 待处理数据
	 * @param fillChar 填充字符
	 * @param num 目标位数
	 * @return
	 */
	public static String toStringToNum(Object object, String  fillChar, int num){
		String str = String.valueOf(object);
		if (str.length() > num) {
			str = str.substring(str.length() - num);
		}
		StringBuffer sb = new StringBuffer();
		for(int i = 0; i< num - str.length(); i++){
			sb.append(fillChar);
		}
		sb.append(str);
		return sb.toString();
	}
	/**
	 * 将数字格式化为 "01"格式
	 * @param num 输入数字
	 * @return 0打头形式的数字字符串
	 */
	public static String FormatNum(int num){
		return toStringToNum(num, "0", 2);
	}
	
	public static void main(String[] args) {
//		System.out.println(toLong("1,111,111,111"));
//		System.out.println(toDouble("1,111.223,11"));
//		System.out.println(toInteger("111"));
		System.out.println(toStringToNum("123456789012232342132", "0", 10));
	}
}
