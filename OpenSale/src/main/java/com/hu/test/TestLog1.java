/**
 * 描述：
 * 
 * 版权所有：HugeDog 软件研发中心
 * Copy Right: Copyright(C) 2016-2017
 * @author: huge
 * @version V1.0
 * 
 * 创建时间：@2016年9月26日
 * 修改时间		修改人员		 版本号		描述
 * 
 */
package com.hu.test;


/**
 * @Description: TODO 
 * @author: Huge 
 * @date: 2016年9月26日
 */
public class TestLog1 {



	public static void main(String[] args) {
		
		
		
		
		
		
		
		
		
		OpenSaleLogger tsOpLogger = OpenSaleLogger.getOpenSaleLogger();

		// 测试代码
		String debug = "debug信息";
		String warn = "warn信息";
		String info = "info信息";
		String error = "error信息";
		String fatal = "fatal信息";
		tsOpLogger.debug(debug);
		tsOpLogger.warn(warn);
		tsOpLogger.info(info);
		tsOpLogger.error(error);
		tsOpLogger.fatal(fatal);
	}


}
