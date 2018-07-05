package com.kyler.space.common.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 字符串处理工具类
 * 
 * @author 刘洋
 * 
 */
public class StringUtil {

	/** 日期格式字符串 */
	public static final String DF_YMD = "yyyy-MM-dd";
	/** 日期格式字符串 */
	public static final String DF_YM = "yyyy-MM";
	/** 日期格式字符串 */
	public static final String DF_YMD_24 = "yyyy-MM-dd HH:mm:ss";
	/** 日期格式字符串 */
	public static final String DF_EEE_MMM = "EEE MMM dd HH:mm:ss zzz yyyy";

	/**
	 * 空字符串
	 */
	public static final String EMPTY = "";

	/**
	 * 判断字符串是否为空
	 * 
	 * @param obj
	 * @return ture:为空 false:不为空
	 */
	public static boolean isNullOrEmpty(String value) {
		return value == null || EMPTY.equals(value);
	}

	/**
	 * 判断对象字符串是否为空
	 * 
	 * @param obj
	 * @return ture:为空 false:不为空
	 */
	public static boolean isNullOrEmpty(Object value) {
		return value == null || EMPTY.equals(value);
	}

	/**
	 * 删除前后全角半角空格和tab
	 * 
	 * @param value
	 *            处理值
	 * @return 处理字符串
	 */
	public static String delSpace(String value) {
		if (isNullOrEmpty(value)) {
			return EMPTY;
		}
		value = value.replaceAll("^[　 \t]+|[　 \t]+$", "");
		return value;
	}

	/**
	 * 当字符串为null的时候、返回空字符串 ("") 。<br>
	 * 不为null的场合返回传入字符串。
	 * 
	 * @param str
	 *            处理值
	 * @return 处理字符串
	 */
	public static String nullToEmpty(String str) {
		return (str != null) ? str : EMPTY;
	}

	/**
	 * 当对象为null的时候、返回空字符串 ("") 。<br>
	 * 不为null的场合返回传入对象的字符串。
	 * 
	 * @param obj
	 *            对象
	 * @return 处理字符串
	 */
	public static String nullToEmpty(Object obj) {
		return (obj != null) ? obj.toString() : EMPTY;
	}

	/**
	 * 字符串转换成日期<br>
	 * value为yyyy-MM-dd格式
	 * 
	 * @param value
	 *            处理值
	 * @return 转换字符串
	 */
	public static Date strToDate(String value) {
		return strToDate(value, DF_YMD);
	}

	/**
	 * 字符串转换成日期
	 * 
	 * @param value
	 *            处理值
	 * @param format
	 *            处理值日期格式
	 * @return 转换字符串
	 */
	public static Date strToDate(String value, String format) {
		Date result;
		if (value == null) {
			result = null;
		} else {
			SimpleDateFormat sdf = (SimpleDateFormat) DateFormat.getDateInstance();
			sdf.applyPattern(format);
			sdf.setLenient(false);
			result = sdf.parse(value, new ParsePosition(0));
		}
		return result;
	}
	
	/**
	 * 字符串转换成日期
	 * 
	 * @param value
	 *            处理值
	 * @param format
	 *            处理值日期格式 locale
	 * @param locale
	 *            locale
	 * @return 转换字符串
	 */
	public static Date strToDate(String value, String format, Locale locale) {
        if(value == null) {
            return null;
        }
        try {
			return new SimpleDateFormat(format, locale).parse(value);
		} catch (ParseException e) {
			e.printStackTrace();
		}
        return null;
    }
	
	/**
	 * 日期转换字符串<br>
	 * 默认yyyy-MM-dd格式
	 * 
	 * @param value
	 *            处理值
	 * @return String 转换值
	 * 
	 */
	public static String dateFormat(Date value) {
		return dateFormat(value, DF_YMD);
	}

	/**
	 * 日期转换字符串
	 * 
	 * @param value
	 *            处理值
	 * @param format
	 *            日期格式
	 * @return String 转换值
	 * 
	 */
	public static String dateFormat(Date value, String format) {
		if (value == null || format == null) {
			return EMPTY;
		}

		SimpleDateFormat sdf = (SimpleDateFormat) DateFormat.getDateInstance();
		sdf.applyPattern(format);
		return sdf.format(value);
	}

	/**
	 * 将整数转换成指定长度字符传，前面加0补位
	 * 
	 * @param value
	 *            要转换的整数
	 * @param length
	 *            长度
	 * @return
	 */
	public static String formatIntToString(Long value, Integer length) {
		if (value == null) {
			return null;
		}
		String strValue = value.toString();
		while (strValue.length() < length) {
			strValue = "0" + strValue;
		}
		return strValue;
	}

	/**
	 * StringBuffer替换
	 * 
	 * @param target
	 *            目标字符串
	 * @param value
	 *            替换值
	 * @param source
	 *            替换字符串
	 * @return StringBuffer
	 */
	public static StringBuffer strBufReplace(String target, String value, StringBuffer source) {
		if (source == null || target == null) {
			return source;
		}
		if (StringUtil.isNullOrEmpty(value)) {
			value = "";
		}

		int index = -1;

		while ((index = source.indexOf(target)) != -1) {
			source.replace(index, index + target.length(), value);
		}

		return source;
	}
	
	/**
	 * 获取字符串中第N次出现的字符位置
	 * 
	 * @param value
	 *            要获取的字符串
	 * @param character
	 *            字符
	 * @param pos
	 *            第几次出现
	 * @return
	 */
	public static int getCharacterPosition(String value, String character, int pos){
	    //这里是获取"subString"符号的位置
	    Matcher slashMatcher = Pattern.compile(character).matcher(value);
	    int resultPos = 0;
	    int mIdx = 0;
	    while(slashMatcher.find()) {
	       mIdx++;
	       //当"subString"符号第pos次出现的位置
	       if(mIdx == pos){
	    	  resultPos = slashMatcher.start();
	          break;
	       }
	    }
	    return resultPos;
	}
}
