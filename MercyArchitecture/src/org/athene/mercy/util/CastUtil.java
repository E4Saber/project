package org.athene.mercy.util;

/**
 * ת�Ͳ���������
 * @author 850030121
 * 
 */
public class CastUtil {

	/**
	 * תΪString��
	 * @param obj
	 * @return
	 */
	public static String castString(Object obj) {
		return CastUtil.castString(obj, "");
	}
	
	/**
	 * תΪString��(�ṩĬ��ֵ)
	 * @param obj
	 * @param defaultValue
	 * @return
	 */
	public static String castString(Object obj, String defaultValue) {
		return obj != null ? String.valueOf(obj) : defaultValue;
	}
	
	/**
	 * תΪdouble��
	 * @param obj
	 * @return
	 */
	public static double castDouble(Object obj) {
		return CastUtil.castDouble(obj, 0);
	}
	
	/**
	 * תΪdouble��(�ṩĬ��ֵ)
	 * @param obj
	 * @param defaultValue
	 * @return
	 */
	public static double castDouble(Object obj, double defaultValue) {
		double doubleValue = defaultValue;
		if(obj!=null) {
			String strValue = castString(obj);
			if(!StringUtil.isEmpty(strValue)) {
				try {
					doubleValue = Double.parseDouble(strValue);
				} catch(NumberFormatException e) {
					doubleValue = defaultValue;
				}
			}
		}
		return doubleValue;
	}
	
	/**
	 * תΪlong��
	 * @param obj
	 * @return
	 */
	public static long castLong(Object obj) {
		return castLong(obj, 0l);
	}
	
	/**
	 * תΪlong��(�ṩĬ��ֵ)
	 * @param obj
	 * @param defaultValue
	 * @return
	 */
	public static long castLong(Object obj, long defaultValue) {
		long longValue = defaultValue;
		if(obj!=null) {
			String strValue = castString(obj);
			if(!StringUtil.isEmpty(strValue)) {
				try {
					longValue = Long.parseLong(strValue);
				} catch(NumberFormatException e) {
					longValue = defaultValue;
				}
			}
		}
		return longValue;
	}
	
	/**
	 * תΪint��
	 * @param obj
	 * @return
	 */
	public static int castInt(Object obj) {
		return castInt(obj, 0);
	}
	
	/**
	 * תΪint��(�ṩĬ��ֵ)
	 * @param obj
	 * @param defaultValue
	 * @return
	 */
	public static int castInt(Object obj, int defaultValue) {
		int intValue = defaultValue;
		if(obj!=null) {
			String strValue = castString(intValue);
			if(!StringUtil.isEmpty(strValue)) {
				try {
					intValue = Integer.parseInt(strValue);
				} catch(NumberFormatException e) {
					intValue = defaultValue;
				}
			}
		}
		return intValue;
	}
	
	/**
	 * תΪboolean��
	 * @param obj
	 * @return
	 */
	public static boolean castBoolean(Object obj) {
		return castBoolean(obj, false);
	}
	/**
	 * תΪboolean��(�ṩĬ��ֵ)
	 * @param obj
	 * @param defaultValue
	 * @return
	 */
	public static boolean castBoolean(Object obj, boolean defaultValue) {
		boolean booleanValue = defaultValue;
		if(obj!=null) {
			String strValue = castString(obj);
			if(!StringUtil.isEmpty(strValue)) {
				booleanValue = Boolean.parseBoolean(strValue);
			}
		}
		return booleanValue;	
	}
}