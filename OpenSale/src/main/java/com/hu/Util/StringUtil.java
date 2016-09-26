/**
 * 描述：
 *     处理字符串
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
import java.math.BigInteger;
import java.text.NumberFormat;
/**
 * @Description: 工具类
 * @author: Huge 
 * @date: 2016年9月23日
 */
public class StringUtil {

	

	
	private StringUtil() {
	}
	/**
	 * 校验输入的字符串是否有值 
	 * @param str 待验证字符串 
	 * @return 字符串为null、空串都返回为假,反之为真
	 */
	public static boolean stringHasValue(String str) {
		return str != null && str.length() > 0;
	}

    /**
     * 判断输入的字符串是否含有空格
     * @param s 输入字符串
     * @return 字符串为null、不含空格返回为假，反之为真
     */
    public static boolean stringContainsSpace(String s) {
        return s != null && s.indexOf(' ') != -1;
    }
  
    /**
	 * 转换为首字母大写
	 * @param str
	 * @return
	 */
	public static String toUpperFirstLetter(String str){
		char[] src = str.toCharArray();
		src[0] = String.valueOf(src[0]).toUpperCase().toCharArray()[0];
		return new String(src);
	}
	/**
	 * 转换为首字母大写
	 * @param str
	 * @return
	 */
	public static String toLowerFirstLetter(String str){
		char[] src = str.toCharArray();
		src[0] = String.valueOf(src[0]).toLowerCase().toCharArray()[0];
		return new String(src);
	}
	/**
	 * 将带下划线的名去掉，同时将每个下划线分割的单词转换为首字母大写的字符串
	 * @param str
	 * @return
	 */
	public static String toCleanUnderlineAndUpperFirstLetter(String str){
		String[] src = str.split("_");
		StringBuffer buffer = new StringBuffer();
		for(int i = 0; i < src.length; i++){			
			buffer.append(toUpperFirstLetter(src[i].toLowerCase()));
		}
		return buffer.toString();
	}

	/**
	 * 将浮点数输出为字符串
	 * @param val 输入的浮点数
	 * @return 浮点数字符串形式，无逗号形式
	 */
	public static String toString(double val) {
		String str = NumberFormat.getInstance().format(val);
		return replace(str, ",", "");
	}

	/**
	 * 将str中的oldSub替换为newSub,区分大小写
	 * @param str 输入的字符串
	 * @param oldSub 需要替换的字符串
	 * @param newSub 要替换为的字符串
	 * @return 处理后的结果
	 */
	public static String replace(String str, String oldSub, String newSub) {
		if (str == null || oldSub == null) {
			return str;
		}

		int start = 0, next;
		StringBuffer buff = new StringBuffer();

		next = str.indexOf(oldSub, start);
		while (next > -1) {
			buff.append(str.substring(start, next));
			buff.append(newSub == null ? "" : newSub);
			start = next + oldSub.length();
			next = str.indexOf(oldSub, start);
		}
		buff.append(str.substring(start));
		return buff.toString();
	}
	/**
	 * 将str中的oldSub替换为newSub，不区分大小写
	 * @param str 输入的字符串
	 * @param oldSub 需要替换的字符串
	 * @param newSub 要替换为的字符串
	 * @return 处理后的结果
	 */
	public static String replaceIgnoreCase(String str, String oldSub, String newSub) {
		if (str == null || oldSub == null) {
			return str;
		}

		String STR = str.toUpperCase();
		String OLDSUB = oldSub.toUpperCase();

		int start = 0, next;
		StringBuffer buff = new StringBuffer();

		next = STR.indexOf(OLDSUB, start);
		while (next > -1) {
			buff.append(str.substring(start, next));
			buff.append(newSub == null ? "" : newSub);
			start = next + oldSub.length();
			next = STR.indexOf(OLDSUB, start);
		}
		buff.append(str.substring(start));
		return buff.toString();
	}
	
	
	/**
	 * 将输入的字符串数组拼接为以token分割的字符串
	 * @param array 字符串数组
	 * @param token 分隔符
	 * @return 以token分割的字符串
	 * 
	 */
	public static String jointStrings(String[] array, String token) {
		StringBuffer buff = new StringBuffer();
		for (int i = 0; i < array.length - 1; i++) {
			buff.append(array[i]);
			buff.append(token);
		}
		if (array.length > 0) {
			buff.append(array[array.length - 1]);
		}
		return buff.toString();
	}

	/**
	 * 将输入的字符串按照token分割为数组
	 * @param val 输入的字符串
	 * @param token 分隔符
	 * @return 字符数组
	 */
	public static String[] splitStrings(String val, String token) {
		return val != null ? val.split(token) : null;
	}

	/**
	 * 将输入的对象为null,空串转换为字符串0
	 * @param o 输入的对象
	 * @return 处理后的字符串
	 */
	public static String converBlankToZero(Object o) {
		if (o == null || o.equals("")) {
			return "0";
		} else {
			return o.toString();
		}

	}
	/**
	 * 将输入的对象，如果为null就转化为空串，否则去除前后导空格
	 * @param o 输入的对象
	 * @return 处理后的字符串
	 */
	public static String convertNullToString(Object o){
		if (o == null)
			return "";
		else
			return o.toString().trim();
	}

	/**
	 * 将null转换为空串,如果不是null则原样返回
	 * @param inStr 输入的字符串
	 * @return 处理后的结果
	 */
	public static String convertNullToBlank(String inStr) {
		return inStr == null ? "" : inStr;
	}

	/**
	 * 将空格转换为null,如果输入null，将直接返回。如果不是空串或则含空格的字符串则按去掉前后导的字符串返回
	 * @param value 输入的字符串
	 * @return 处理后的字符串
	 */
	public static String convertBlankToNull(String value) {
		if (value == null) {
			return null;
		}
		String rt = value.trim();
		return rt.length() == 0 ? null : rt;
	}
	/**
	 * 输入的字符串如果不足长度length，则以字符串0填充前导
	 * @param str 输入的字符串
	 * @param length 需要的长度
	 * @return 处理后的字符串
	 */
	public static String fillToLenWithZero(String str, int length) {
		String zero = "0";
		if (str.length() < length) {
			str = zero + str;
			return fillToLenWithZero(str, length);
		} else {
			return str;
		}
	}
	
	/**
	 * 制造指定长度字符串，
	 * 如果字符串长度不足length,则以字符串0从左边对字符进行填充，
	 * 如果字符串长度大于length,则截取字符最后面的length位。
	 * @param str 源字符串
	 * @param length 需要字符串的长度
	 * @param chs 填充的字符串
	 * @return 
	 */
	public static String makeLenStr(String str, int length){
		//源字符串长度
		int olStrLength = str.trim().length();
		 if(olStrLength <= length){
			 str=StringUtil.fillToLenWithZero(str,length);
		 }else{
			 str=str.substring(olStrLength - length, olStrLength);
		 }
		return str;
	}

	/**
	 * 根据传入的数据类型将输入的字符串转换为目标数据
	 * @param value 输入的字符串
	 * @param bindType 数据类型类
	 * @return 目标数据
	 * @throws Exception 
	 */
	public static Object getValueByDataType(String value, Class bindType) throws Exception {
		if (value == null || value.trim().length() == 0)
			return null;
		String typeName = bindType.getName();
		if (typeName.equals("java.lang.String")) {
			return value;
		} else if (typeName.equals("int") || typeName.equals("java.lang.Integer")) {
			return new Integer(value);
		} else if (typeName.equals("long") || typeName.equals("java.lang.Long")) {
			return new Long(value);
		} else if (typeName.equals("boolean") || typeName.equals("java.lang.Boolean")) {
			return new Boolean(value);
		} else if (typeName.equals("Float") || typeName.equals("java.lang.Float")) {
			return new Float(value);
		} else if (typeName.equals("double") || typeName.equals("java.lang.Double")) {
			return new Double(value);
		} else if (typeName.equals("short") || typeName.equals("java.lang.Short")) {
			return new Short(value);
		} else if (typeName.equals("java.math.BigDecimal")) {
			return new BigDecimal(value);
		} else if (typeName.equals("java.math.BigInteger")) {
			return new BigInteger(value);
		} else if (typeName.equals("java.util.Date")) {
			return DateUtil.toDate(value);
		} else if (typeName.equals("java.sql.Date")) {
			return new java.sql.Date(DateUtil.toDate(value).getTime());
		} else if (typeName.equals("java.sql.Timestamp")) {
			return DateUtil.toTimestamp(DateUtil.toDate(value));
		} else {
			return value;
		}
	}
	
	
	/**
	 * 将字节数组转换为字符串
	 * @param bytes 字节数组
	 * @param charsetName 字符集
	 * @return 字符串
	 * @throws Exception 异常
	 */
	public static String toString(byte bytes[], String charsetName) throws Exception {
		return new String(bytes, charsetName);
	}
	/**
	 * 如果输入的字符串为空串，则转换为默认值字符串
	 * @param input 输入的字符串
	 * @param defval 默认字符串
	 * @return
	 * @throws Exception
	 */
	public static String toString(String input, String defval) throws Exception {
		return ErrMsgUtil.isBlank(input) ? defval : input;
	}
	
	/**
	 * 生成In语法需要的语句
	 * @param haveQuotes 是否带引号
	 * @param ins in 语句中的参数列表
	 * @return 语句 '1','2','3',...,'n'
	 */
	public static String genInStatement(boolean haveQuotes, Object...ins) {
		if (ins == null || ins.length == 0) {
			return null;
		}
		StringBuffer buffer = new StringBuffer("");
		for (int i = 0; i < ins.length; i++) {
			if (i > 0) {
				buffer.append(",");
			}
			if (haveQuotes == true) {				
				buffer.append("'");
			}
			if (ins[i] == null) {
				buffer.append(ins[i]);
			}else {
				buffer.append(ins[i].toString());
			}
			if (haveQuotes == true) {				
				buffer.append("'");
			}
		}
		return buffer.toString();
	}
	
	
	/**
	 * 字符串转为BigDecimal类型比较大小
	 * -1小于， 0等于， 1大于
	 * @param str1
	 * @param str2
	 * @return
	 * @throws Exception
	 */
	public static int strCompareTo(String str1, String str2) throws Exception{
		return new BigDecimal(str1).compareTo(new BigDecimal(str2));
	}
	
	/**
	 * 是否包含
	 * @param names
	 * @param name
	 * @return true  包含
	 */
	public static boolean isContain(String[] names, String name) {
		return isContain(names, name, true);
	}

	/**
	 * 是否包含
	 * @param names
	 * @param name
	 * @param isIgnoreCase
	 * @return
	 */
	public static boolean isContain(String[] names, String name, boolean isIgnoreCase) {
		if (names == null || names.length == 0 || name == null) {
			return false;
		}
		for (int i = 0; i < names.length; i++) {
			if (isIgnoreCase) {
				if (name.equalsIgnoreCase(names[i])) {
					return true;
				}
			} else {
				if (name.equals(names[i])) {
					return true;
				}
			}
		}
		return false;
	}
	
	/**
	 * 将传入的字符串，如：xxxx,xxxxx 转换成xxxx+xxxxx
	 * @param prodSepcName
	 * @return
	 */
	public static String covertString(String prodSepcName) {
		String name = prodSepcName.replace(",", "+");
		return name;
	}
	
	/**
	 * 将传入的字符串，如：1111,2222 转换成1111+2222=3333
	 * @param priceCount
	 * @return
	 */
	public static String covertAmt(String priceCount){
	    int amt = priceCount.indexOf(",");
	    if(amt<=0){
	    	return priceCount;
	    }else{
	    	String[] array = priceCount.split(",");
	    	double num=0;
	    	for(int i=0;i<array.length;i++){
	    		num+=Double.parseDouble(array[i]);
	    	}	
	    	return String.valueOf(num);
	    }
	}
	
	public static String getUUID(){
		String uuid = java.util.UUID.randomUUID().toString().replaceAll("-", "");
		if(uuid.length()>32) return uuid.substring(0,32);
		else return uuid;
	}
	/**
	 * 去掉字符串中的空格，含全角半角空格
	 * @return
	 */
	public static String lmrtrim(String s){
		if(s == null)
			return null;
		s = s.replaceAll("　| ", "");
		return s;
	}
	
	/**
	 * 处理字符串方法，对于是null的String对象，或是‘null’字符串的，均返回空字符串。
	 */
	public static String doEmpty(String src){
		if(src==null||"null".equalsIgnoreCase(src)) return "";
		else return String.valueOf(src);
	}
	

	/**
	 * 处理字符串方法，对于是null的String对象，或是‘null’字符串的，均返回空字符串。
	 */
	public static String doEmpty(Object src){
		if(src==null||"null".equalsIgnoreCase(String.valueOf(src))) return "";
		else return String.valueOf(src);
	}
	
	/**
	 * 处理字符串方法，对于是null的String对象，或是‘null’字符串的，均以参数replace中指定的内容返回，否则原字符串返回。
	 */
	public static String doEmpty(String src,String replace){
		if(src==null||"null".equalsIgnoreCase(src)||src.length()<1 || "".equals(src)) return replace;
		else return src;
	}
	/**
	 * 处理字符串方法，对于是null的Object对象，或是‘null’字符串，或是空字符串的，均以参数replace中指定的内容返回，否则原字符串返回。
	 */
	public static String doEmpty(Object src,String replace){
		if(src==null||"null".equalsIgnoreCase(String.valueOf(src))||String.valueOf(src).length()<1) return replace;
		else return String.valueOf(src);
	}
	
	/**
	 * 处理字符串方法，对于是null的String对象，或是‘null’字符串的，均返回空字符串，否则原字符串去除头尾空格后返回。
	 */
	public static String doEmptyAndTrim(String src){
		if(src==null||"null".equalsIgnoreCase(src)) return "";
		else return src.trim();
	}
	
	/**
	 * 处理字符串方法，对于是null的String对象，或是‘null’字符串，或是空字符串的，均以参数replace中指定的内容返回，否则原字符串去除头尾空格后返回。
	 */
	public static String doEmptyAndTrim(String src,String replace){
		if(src==null||"null".equalsIgnoreCase(src)||src.length()<1) return replace;
		else return src.trim();
	}
	

	/**
	 * byte类型转换成BIt类型
	 * @param b 参数byte
	 * @return 字符串
	 */
	public static String byteToBit(byte b){
		String result = ""+(byte)((b>>7) & 0x1)+(byte)((b>>6) &0x1)
							+(byte)((b>>5) &0x1)+(byte)((b>>4) &0x1)
							+(byte)((b>>3) &0x1)+(byte)((b>>2) &0x1)
							+(byte)((b>>1) &0x1)+(byte)((b>>0) &0x1);
		return result;
	}

	/**
	 * 取得一个数字的绝对值
	 * @param num
	 * @return
	 */
	public static int abs(int num){
		return num*(1-((num>>>31)<<1));
	}
	/**
	 * 以"逗号"分割字符串
	 * @param value 字符串信息
	 * @param num 需要获取的第几位信息
	 * @return 分割后的单一字符串
	 */
	public static String separationString(String value,int num){
		String[] str = value.split(",");
		return str[num];
	}
	
}
