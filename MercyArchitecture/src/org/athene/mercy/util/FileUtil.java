package org.athene.mercy.util;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.apache.log4j.Logger;

/**
 * 
 * @author 850030121
 *
 */

public final class FileUtil {

	private static final Logger LOGGER = Logger.getLogger(FileUtil.class);
	
	/**
	 * 获取真实文件名(自动去掉文件路径)
	 * @param fileName
	 * @return
	 */
	public static String getRealFileName(String fileName) {
		return FilenameUtils.getName(fileName);
	}
	
	/**
	 * 创建文件
	 * @param filePath
	 * @return
	 */
	public static File createFile(String filePath) {
		File file = null;
		try {
			file = new File(filePath);
			System.out.println(filePath);
			File parentDir = file.getParentFile();
			if(!parentDir.exists()) {
				FileUtils.forceMkdir(parentDir);
			}
		} catch(Exception e) {
			LOGGER.error("create file failure", e);
			throw new RuntimeException(e);
		}
		return file;
	}
}
