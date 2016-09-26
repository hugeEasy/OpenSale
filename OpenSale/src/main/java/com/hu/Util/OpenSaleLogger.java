/**
 * 描述：通用 log4j 封装类  
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



import org.apache.log4j.*;   
/**
 * @Description: TODO 
 * @author: Huge 
 * @date: 2016年9月23日
 */
public class OpenSaleLogger {
    private static OpenSaleLogger openSaleLogger;
    private Logger logger;

    public OpenSaleLogger(String configPath) {
        PropertyConfigurator.configure(configPath);
        // this.logger = Logger.getRootLogger();
        this.logger = Logger.getLogger(OpenSaleLogger.class);
    }

    public static OpenSaleLogger getOpenSaleLogger() {
        if (openSaleLogger == null) {
        	openSaleLogger = new OpenSaleLogger("resources/log4j.properties");///OpenSale/src/main/resources/log4j.properties
        }
        return openSaleLogger;
    }

    public static void debug(String str) {
    	openSaleLogger.logger.debug(str);
    }

    public static void info(String str) {
    	openSaleLogger.logger.info(str);
    }

    public static void warn(String str) {
    	openSaleLogger.logger.warn(str);
    }

    public static void error(String str) {
    	openSaleLogger.logger.error(str);
    }

    public static void fatal(String str) {
    	openSaleLogger.logger.fatal(str);
    }
}
