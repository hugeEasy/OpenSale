package com.hu.Util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CheckIDCard {

	
	
	
	
	/** 
     * 验证身份证号码 
     *  
     * @param papersNumber 
     *            身份证号码 
     */  
    public static boolean checkPapersNumber(String papersNumber) {  
        if (papersNumber == null) {  
            return false;  
        } else if (papersNumber.length() < 15) {  
            return false;  
        }  
        String dt = papersNumber.substring(6, 14);  
        if (!checkDate(dt, "yyyyMMdd")) {  
            return false;  
        }  
        // 18位身份证号码验证  
        if (papersNumber.length() == 18) {  
            int a, b, c = 0;  
            String d = "";  
            if (!checkNumber(papersNumber.substring(0, 17))) {  
                return false;  
            }  
            a = Integer.parseInt(papersNumber.substring(0, 1)) * 7   
                            + Integer.parseInt(papersNumber.substring(1, 2)) * 9   
                            + Integer.parseInt(papersNumber.substring(2, 3)) * 10;  
            a = a + Integer.parseInt(papersNumber.substring(3, 4)) * 5   
                            + Integer.parseInt(papersNumber.substring(4, 5)) * 8   
                            + Integer.parseInt(papersNumber.substring(5, 6)) * 4;  
            a = a + Integer.parseInt(papersNumber.substring(6, 7)) * 2   
                            + Integer.parseInt(papersNumber.substring(7, 8)) * 1   
                            + Integer.parseInt(papersNumber.substring(8, 9)) * 6;  
            a = a + Integer.parseInt(papersNumber.substring(9, 10)) * 3   
                            + Integer.parseInt(papersNumber.substring(10, 11)) * 7   
                            + Integer.parseInt(papersNumber.substring(11, 12)) * 9;  
            a = a + Integer.parseInt(papersNumber.substring(12, 13)) * 10   
                            + Integer.parseInt(papersNumber.substring(13, 14)) * 5   
                            + Integer.parseInt(papersNumber.substring(14, 15)) * 8;  
            a = a + Integer.parseInt(papersNumber.substring(15, 16)) * 4   
                            + Integer.parseInt(papersNumber.substring(16, 17)) * 2;  
            b = a % 11;  
            if (b == 2) // 最后一位为校验位  
            {  
                d = papersNumber.substring(17, 18).toUpperCase();   
                                // 转为大写X  
            } else {  
                c = Integer.parseInt(papersNumber.substring(17, 18));  
            }  
  
            String JYM = "10X98765432";  
            String m = JYM.substring(b, b + 1);  
            if ("X".equals(m)) {  
                if (!"X".equals(d)) {  
                    //System.out.println("身份证号码校验位错:最后一位应该为:X");  
                    return false;  
                }  
            } else {  
                if (c != Integer.parseInt(m)) {  
                    //System.out.println("身份证好号码校验位错:最后一位应该为:" + m);  
                    return false;  
                }  
            }  
        } else {  
            // 15位身份证号  
            if (!checkNumber(papersNumber)) {  
                //System.out.println("身份证号码错误,前15位不能含有英文字母！");  
                return false;  
            }  
        }  
        return true;  
    }  
  
    /** 
     * 检测日期格式 
     *  
     * @param date 
     *            待检测日期 
     * @param format 
     *            格式字符串 
     * @return 
     */  
    public static boolean checkDate(String date, String format) {  
        SimpleDateFormat sdf = new SimpleDateFormat(format);  
        try {  
            sdf.parse(date);  
        } catch (ParseException e) {  
            return false;  
        }  
        return true;  
    }  
  
    /** 
     * 验证数字格式 
     *  
     * @param num 
     * @return 
     */  
    public static boolean checkNumber(String num) {  
        String regex = "^\\d+$";  
        Pattern patten = Pattern.compile(regex);  
        Matcher m = patten.matcher(num);  
        boolean b = m.matches();  
        if (b) {  
            return true;  
        }  
        return false;  
    }  


    
}
