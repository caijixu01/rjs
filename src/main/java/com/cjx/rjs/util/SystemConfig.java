package com.cjx.rjs.util;

import java.io.InputStream;
import java.util.Properties;

import org.apache.log4j.Logger;

/**
 * 系统配置
 * @author caijx
 * @createdate 2015年3月19日
 */
public class SystemConfig {
	private static Logger logger = Logger.getLogger(SystemConfig.class);

	private static final String CONFIG_FILE_NAME = "/config.properties";

	private static Properties properties = null;

	static {
		try {
			if (properties == null) {
				properties = new Properties();
				final InputStream is = SystemConfig.class.getResourceAsStream(CONFIG_FILE_NAME);
				properties.load(is);
			}
		} catch (final Exception e) {
			logger.warn("读取配置文件失败: " + e.getMessage());
		}
	}

	public static String getValue(final String key) {
		try {
			return properties.getProperty(key);
		} catch (final Exception e) {
			logger.warn(e.getMessage());
			return "";
		}
	}
}
