package org.athene.mercy.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;

import org.apache.log4j.Logger;


/**
 * 流操作工具
 * @author 850030121
 *
 */

public class StreamUtil {

	private static final Logger LOGGER = Logger.getLogger(StreamUtil.class);
	
	/**
	 * 从出入流中获取字符串
	 * @param is
	 * @return
	 */
	public static String getString(InputStream is) {
		StringBuilder sb = new StringBuilder();
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(is));
			String line = null;
			while((line=reader.readLine())!=null) {
				sb.append(line);
			}
		} catch (IOException e) {
			LOGGER.error("get string failure", e);
			throw new RuntimeException(e);
		}
		return sb.toString();
	}
	
	/**
	 * 将输入流复制到输出流
	 * @param is
	 * @param os
	 */
	public static void copyStream(InputStream is, OutputStream os) {
		try {
			int length = 0;
			byte[] buffer = new byte[4*1024];
			while((length=is.read(buffer, 0, buffer.length))!=-1) {
				os.write(buffer, 0, length);
			}
			os.flush();
		} catch(Exception e) {
			LOGGER.error("copy stream failure", e);
			throw new RuntimeException(e);
		} finally {
			try {
				is.close();
				os.close();
			} catch (IOException e) {
				LOGGER.error("close stream failure", e);
				throw new RuntimeException(e);
			}
		}
	}
}
