/**
 * 描述：
 * 
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

/**
 * @Description: TODO 
 * @author: Huge 
 * @date: 2016年9月23日
 */
public class ErrMsgUtil {


	
	/**
	 * 是否为空字符串
	 * @param strValue
	 * @return 是空字符串返回真，反之返回假
	 */
	public static boolean isBlank(String strValue){
		if(strValue == null){
			return true;
		}
		if(strValue.toString().trim().equals("")){
			return true;
		}
		return false;
	}

	/**
	 * 是否非空字符串
	 * @param strValue
	 * @return 非空字符串返回真，反之假
	 */
	public static boolean isNotBlank(String strValue){
		return !isBlank(strValue);
	}
	
	/**
	 * 驗證是否是數字
	 * @param value
	 * @return 是數字返回真，反之為假
	 */
	public static boolean isNumber(String value){
		if(value.toString().trim().matches("^-?\\d+$")){
			return true;
		}
		return false;
	}
	
	/**
	 * 驗證是否是非數字
	 * @param value
	 * @return 非數字返回真，反之為假
	 */
	public static boolean isNotNumber(String value){
		return !isNumber(value);
	}
	
	/**
	 * 驗證是否是金錢數字
	 * @param value
	 * @return 是金錢數字則為真，反之為假
	 */
	public static boolean isMoneyNumber(String value){
		if(value.toString().trim().matches("^-?\\d+(\\.\\d{2})?$")){
			return true;
		}
		return false;
	}
	
	/**
	 * 驗證是否非金錢數字
	 * @param value
	 * @return 非金錢數字則為真，反之為假
	 */
	public static boolean isNotMoneyNumber(String value){
		return !isMoneyNumber(value);
	}
	
	/**
	 * 驗證是否是正數
	 * @param value
	 * @return 是正數為真，反之為假
	 */ 
	public static boolean isPostive(Object value){
		BigDecimal num = new BigDecimal(value.toString());
		return num.abs()==num;
	}
	
	/**
	 * 驗證是否是負數
	 * @param value
	 * @return  是負數為真，反之為假
	 */
	public static boolean isNegetive(Object value){
		return isPostive(value) == false;
	}

	/**
	 * 验证输入信息是否是字母或数字（组合：字母、数字、字母和数字） 
	 * @param value
	 * @return 符合要求返回为真，反之为假
	 */
	public static boolean isNumberAndChar(String value){
		String reg = "^[a-zA-z0-9]+$";
		if(value.trim().matches(reg)){
			return true;
		}
		return false;
	}
	
	/**
	 * 验证输入的非字母或数字
	 * @param value
	 * @return 非字母或数字则返回真,反之则为假
	 */
	public static boolean isNotNumberAndChar(String value){
		return !isNumberAndChar(value);
	}
	/**
	 * 验证字符是否含有特殊字符 &<>+^|?《》…
	 * @param value
	 * @return 包含则为假，反之则为真
	 */
	public static boolean isValidSpecChar(String value){
		String  reg = "[^&<>+^|?《》…]{1,}";
		if(!value.trim().matches(reg)){
			return true;
		}
		return false;
	}
	
	public static void main(String args[]){
		System.out.println(ErrMsgUtil.isValidSpecChar(""));
	}
}
