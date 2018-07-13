package com.kyler.space.common.util;

import java.beans.PropertyDescriptor;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.security.SecureRandom;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtilsBean;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.context.MessageSource;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.kyler.space.common.Criteria;

/**
 * Web层相关的实用工具类
 * 
 */
public class WebUtil {

	/** 下拉列表框显示值Key */
	public static final String COMBOX_TEXT_FIELD = "textFieldKey";

	/** 下拉列表框实际值Key */
	public static final String COMBOX_VALUE_FIELD = "valueFieldKey";

	public static MessageSource messageSource;

	static {
		try {
			// 获取消息处理类
			messageSource = new ClassPathXmlApplicationContext(
					"classpath:/config/spring/spring-message-bean.xml");
		} catch (Exception e) {
		}
	}

	/**
	 * 将请求参数封装为Map<br>
	 * request中的参数t1=1&t1=2&t2=3<br>
	 * 形成的map结构：<br>
	 * key=t1;value=1,2<br>
	 * key=t2;value=3<br>
	 * 
	 * @param request
	 *            HTTP请求对象
	 * @return 封装后的Map
	 * @throws UnsupportedEncodingException 
	 */
	@SuppressWarnings("rawtypes")
	public static HashMap<String, String> getParameterMap(
			HttpServletRequest request){
		// 返回值HaspMap
		HashMap<String, String> returnMap = new HashMap<String, String>();
		try {
			// 参数Map
			Map properties = request.getParameterMap();
			Iterator entries = properties.entrySet().iterator();
			Map.Entry entry;
			String name = "";
			String value = "";
			while (entries.hasNext()) {
				entry = (Map.Entry) entries.next();
				name = (String) entry.getKey();
				Object valueObj = entry.getValue();
				if (null == valueObj) {
					value = "";
				} else if (valueObj instanceof String[]) {
					String[] values = (String[]) valueObj;
					for (int i = 0; i < values.length; i++) {
						
						String tempValue = "";
						tempValue = new String(values[i].getBytes("iso-8859-1"),"UTF-8");
						value = tempValue + ",";
					}
					value = value.substring(0, value.length() - 1);
				} else {
					value = valueObj.toString();
				}
				returnMap.put(name, value);
				
			}
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return returnMap;
	}
	
	/**
	 * json字符串转conditionMap
	 * 过滤null,空字符,空格值
	 */
	public static Map<String, Object> getNotBlankValueMap(String jsonContent){
		Map<String,Object> returnMap = new HashMap<String, Object>();
		try {
			Map<String,Object> map = JsonUtil.fromJson(jsonContent, Map.class);
			Iterator entries = map.entrySet().iterator();
			String key = "";
			Object value = "";
			Map.Entry entry;
			while(entries.hasNext()){
				entry = (Map.Entry)entries.next();
				key = (String) entry.getKey();
				value =  entry.getValue();
				if(!StringUtil.isNullOrEmpty(value)){
					returnMap.put(entry.getKey().toString(), value);
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return returnMap;
	}
	
	/**
	 * 设置分页查询条件相关参数。
	 * 
	 * @param request
	 *            HTTP请求对象(从前台获取以"qm."开头的查询条件)
	 * @param criteria
	 *            查询条件
	 * @param defaultOrderByClause
	 *            默认排序条件
	 */
	public static void preparePageParams(HttpServletRequest request, Criteria criteria, String defaultOrderByClause) {

		if (request == null || criteria == null) {
			return;
		}

		// 取得分页信息
		String strPageSum = request.getParameter("pagenum");
		String strPageSize = request.getParameter("pagesize");

		// 设置分页信息
		if (!StringUtil.isNullOrEmpty(strPageSum)
				&& !StringUtil.isNullOrEmpty(strPageSize)) {
			int pageSize = Integer.valueOf(strPageSize);
			int recordStart = Integer.valueOf(strPageSum) * pageSize;
			criteria.setMysqlLength(pageSize);
			criteria.setMysqlOffset(recordStart);
		}

		// 取得排序信息
		String sortDatafield = request.getParameter("sortdatafield");
		String sortOrder = request.getParameter("sortorder");

		// 排序信息
		if (StringUtils.isNotBlank(sortDatafield)
				&& StringUtils.isNotBlank(sortOrder)) {
			criteria.setOrderByClause(WebUtil.toClumn(sortDatafield) + " "
					+ sortOrder + ", " + defaultOrderByClause);
		} else {
			// 默认以帐号排序
			criteria.setOrderByClause(defaultOrderByClause);
		}

		// 将请求参数Map
		HashMap<String, String> paramMap = getParameterMap(request);
		
		// 将查询条件设置到criteria中
		Iterator<Entry<String, String>> keyIterator = paramMap.entrySet()
				.iterator();
		while (keyIterator.hasNext()) {
			Entry<String, String> entry = keyIterator.next();
			String key = entry.getKey();
			if (key.indexOf("qm.") == 0
					&& StringUtils.isNotBlank(entry.getValue())) {
				criteria.put(key.substring(3), entry.getValue());
			}
		}
	}

	public static void preparePageParams1(HttpServletRequest request,
			Criteria criteria, String defaultOrderByClause) {

		if (request == null || criteria == null) {
			return;
		}

		// 取得分页信息
		String strPageSum = request.getParameter("pagenum");
		String strPageSize = request.getParameter("pagesize");

		// 设置分页信息
		if (!StringUtil.isNullOrEmpty(strPageSum) && !StringUtil.isNullOrEmpty(strPageSize)) {
			int pageSize = Integer.valueOf(strPageSize);
			int recordStart = Integer.valueOf(strPageSum) * pageSize;
			criteria.setMysqlLength(pageSize);
			criteria.setMysqlOffset(recordStart);
		}

		// 取得排序信息
		String sortDatafield = request.getParameter("sortdatafield");
		String sortOrder = request.getParameter("sortorder");

		// 排序信息
		if (StringUtils.isNotBlank(sortDatafield) && StringUtils.isNotBlank(sortOrder)) {
			criteria.setOrderByClause(WebUtil.toClumn(sortDatafield) + " " + sortOrder + ", " + defaultOrderByClause);
		} else {
			// 默认以帐号排序
			criteria.setOrderByClause(defaultOrderByClause);
		}

		// 将请求参数Map
		HashMap<String, String> paramMap = getParameterMap(request);

		// 将查询条件设置到criteria中
		Iterator<Entry<String, String>> keyIterator = paramMap.entrySet().iterator();
		while (keyIterator.hasNext()) {
			Entry<String, String> entry = keyIterator.next();
			String key = entry.getKey();
			if (key.indexOf("qm.") == 0 && StringUtils.isNotBlank(entry.getValue())) {
				criteria.put(key.substring(3), entry.getValue());
			}
		}
	}

	/**
	 * 把pojo字段转为数据库字段<br>
	 * fileName -> FILE_NAME
	 * 
	 * @param field
	 *            变量名
	 * @return 字段名
	 */
	public static String toClumn(String field) {

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < field.length(); i++) {
			char c = field.charAt(i);
			if (Character.isUpperCase(c) && i > 0) {
				sb.append("_").append(Character.toUpperCase(c));
			} else {
				sb.append(Character.toUpperCase(c));
			}
		}
		return sb.toString();
	}

	/**
	 * 使用Response输出指定格式内容.
	 */
	protected static void render(HttpServletResponse response, String text,
			String contentType) {

		try {
			response.setContentType(contentType);
			if (StringUtil.isNullOrEmpty(text)) {
				text = "";
			}
			response.getWriter().write(text);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 直接输出字符串.
	 */
	public static void renderText(HttpServletResponse response, String text) {

		render(response, text, "text/plain;charset=UTF-8");
	}

	/**
	 * 直接输出JSON.
	 */
	public static void renderJson(HttpServletResponse response, String text) {

		render(response, text, "application/json; charset=utf-8");
	}

	/**
	 * 直接输出HTML.
	 */
	public static void renderHtml(HttpServletResponse response, String html) {

		render(response, html, "text/html;charset=UTF-8");
	}

	/**
	 * 直接输出XML.
	 */
	public static void renderXML(HttpServletResponse response, String xml) {

		render(response, xml, "text/xml;charset=UTF-8");
	}

	/**
	 * MD5加密5
	 * 
	 * @param data
	 *            数据值
	 * @param salt
	 *            加密添加字符串
	 * @return 加密后字符串
	 */
	public static String encrypt(String data, String salt) {

		// 可以更换算法:sha512Hex
		return DigestUtils.md5Hex(data + "{" + salt.toLowerCase() + "}");
	}

	/**
	 * BASE64加密
	 * 
	 * @param data
	 * @return
	 */
	public static String encryptBase64(String data) {
		return Base64.encodeBase64String(data.getBytes());
	}

	/**
	 * BASE64解密
	 * 
	 * @param data
	 * @return
	 */
	public static String decryptBase64(String data) {
		return new String(Base64.decodeBase64(data));
	}

	/**
	 * 新增时添加用户以及当前时间信息
	 * 
	 * @param obj
	 */
	public static <T> void prepareInsertParams(T obj) {
//		if (AuthUtil.getAuthUser() != null
//				&& AuthUtil.getAuthUser().getAccount() != null) {
//			// 创建人
//			invokeSet(obj, "createdBy", AuthUtil.getAuthUser().getAccount());
//			// 更新人
//			invokeSet(obj, "updatedBy", AuthUtil.getAuthUser().getAccount());
//		}else{
//			invokeSet(obj, "createdBy", "admin");
//			invokeSet(obj, "updatedBy", "admin");
//		}
		Date date = new Date();
		// 更新时间
		invokeSet(obj, "createdDt", date);
		// 更新时间
		invokeSet(obj, "updatedDt", date); 
		// 初始版本号
		invokeSet(obj, "version", 1L);
	}

	/**
	 * 新增时添加用户以及当前时间信息(For Activiti)
	 * 
	 * @param obj
	 */
	public static <T> void prepareInsertParams(T obj, String user) {
		if (user != null && !StringUtil.EMPTY.equals(user)) {
			// 创建人
			invokeSet(obj, "createdBy", user);
			// 更新人
			invokeSet(obj, "updatedBy", user);
		}
		Date date = new Date();
		// 更新时间
		invokeSet(obj, "createdDt", date);
		// 更新时间
		invokeSet(obj, "updatedDt", date);
		// 初始版本号
		invokeSet(obj, "version", 1L);
	}

	/**
	 * 新增时添加管理员用户以及当前时间信息
	 * 
	 * @param obj
	 */
	public static <T> void prepareInsertAdminParams(T obj) {
		// 创建人
		invokeSet(obj, "createdBy", "admin");
		// 更新人
		invokeSet(obj, "updatedBy", "admin");

		Date date = new Date();
		// 更新时间
		invokeSet(obj, "createdDt", date);
		// 更新时间
		invokeSet(obj, "updatedDt", date);
		// 初始版本号
		invokeSet(obj, "version", 1L);
	}

	/**
	 * 更新时添加用户以及当前时间信息
	 * 
	 * @param obj
	 */
	public static <T> void prepareUpdateParams(T obj) {
//		if (AuthUtil.getAuthUser() != null
//				&& AuthUtil.getAuthUser().getAccount() != null) {
//			// 更新人
//			invokeSet(obj, "updatedBy", AuthUtil.getAuthUser().getAccount());
//		}else{
//			invokeSet(obj, "updatedBy", "admin");
//		}
		// 更新时间
		Date date = new Date();
		invokeSet(obj, "updatedDt", date);
	}

	/**
	 * 更新时添加用户以及当前时间信息
	 * 
	 * @param obj
	 */
	public static <T> void prepareUpdateParams(T obj, String user) {
		if (user != null && !StringUtil.EMPTY.equals(user)) {
			// 更新人
			invokeSet(obj, "updatedBy", user);
		}
		// 更新时间
		Date date = new Date();
		invokeSet(obj, "updatedDt", date);
	}

	/**
	 * java反射bean的get方法
	 * 
	 * @param objectClass
	 * @param fieldName
	 * @return
	 */
	// TODO
	// private static Method getGetMethod(Class<? extends Object> objectClass,
	// String fieldName) {
	// StringBuffer sb = new StringBuffer();
	// sb.append("get");
	// sb.append(fieldName.substring(0, 1).toUpperCase());
	// sb.append(fieldName.substring(1));
	// try {
	// return objectClass.getMethod(sb.toString());
	// } catch (Exception e) {
	// }
	// return null;
	// }

	/**
	 * java反射bean的set方法
	 * 
	 * @param objectClass
	 * @param fieldName
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	private static Method getSetMethod(Class<? extends Object> objectClass,
			String fieldName) {

		try {
			Class[] parameterTypes = new Class[1];
			Field field = getField(objectClass, fieldName);
			parameterTypes[0] = field.getType();
			StringBuffer sb = new StringBuffer();
			sb.append("set");
			sb.append(fieldName.substring(0, 1).toUpperCase());
			sb.append(fieldName.substring(1));
			Method method = objectClass
					.getMethod(sb.toString(), parameterTypes);
			return method;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}

	/**
	 * 获取类已经类的父的某一声明变量
	 * 
	 * @param clazz
	 * @param fieldName
	 *            变量名
	 * @return Field 变量
	 * @throws NoSuchFieldException
	 */
	@SuppressWarnings("rawtypes")
	private static Field getField(Class clazz, String fieldName)
			throws NoSuchFieldException {
		try {
			return clazz.getDeclaredField(fieldName);
		} catch (NoSuchFieldException e) {
			Class superClass = clazz.getSuperclass();
			if (superClass == null) {
				throw e;
			} else {
				return getField(superClass, fieldName);
			}
		}
	}

	/**
	 * 执行set方法
	 * 
	 * @param o执行对象
	 * @param fieldName属性
	 * @param value值
	 */
	private static void invokeSet(Object o, String fieldName, Object value) {

		Method method = getSetMethod(o.getClass(), fieldName);
		try {
			method.invoke(o, new Object[] { value });
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 取得系统消息
	 * 
	 * @param msgId
	 *            消息ID
	 * @param arg
	 *            消息设置参数
	 * @return 消息内容
	 */
	public static String getMessage(String msgId, Object[] arg) {
		String message = StringUtils.EMPTY;
		try {
			message = messageSource.getMessage(msgId, arg, Locale.CHINA);
		} catch (Exception e) {
		}

		return message;
	}

	/**
	 * 取得系统消息
	 * 
	 * @param msgId
	 *            消息ID
	 * @return 消息内容
	 */
	public static String getMessage(String msgId) {
		return WebUtil.getMessage(msgId, null);
	}

	/**
	 * 取得前后N年分下拉列表Map
	 * 
	 * @param yearCount
	 *            指定年数
	 * @param addPreYear
	 *            是否取得前N年份(true:是;false:否)
	 * @param addNextYear
	 *            是否取得后N年份(true:是;false:否)
	 * @return 下拉列表Map
	 */
	public static Map<String, String> getYearMap(int yearCount,
			boolean addPreYear, boolean addNextYear) {

		Map<String, String> yearMap = new LinkedHashMap<String, String>();

		// 日历取得
		Calendar cder = Calendar.getInstance();

		int cYear = cder.get(Calendar.YEAR);

		// 前N年
		if (addPreYear) {
			for (int i = yearCount; i >= 1; i--) {
				yearMap.put(String.valueOf(cYear - i),
						String.valueOf(cYear - i));
			}
		}
		// 今年
		yearMap.put(String.valueOf(cYear), String.valueOf(cYear));
		// 后N年
		if (addNextYear) {
			for (int j = 1; j <= yearCount; j++) {
				yearMap.put(String.valueOf(cYear + j),
						String.valueOf(cYear + j));
			}
		}

		return yearMap;
	}

	/**
	 * 取得月份下拉列表Map
	 * 
	 * @return 下拉列表Map
	 */
	public static Map<String, String> getMonthMap() {

		Map<String, String> monthMap = new LinkedHashMap<String, String>();

		// 12月份
		monthMap.put("1", "01");
		monthMap.put("2", "02");
		monthMap.put("3", "03");
		monthMap.put("4", "04");
		monthMap.put("5", "05");
		monthMap.put("6", "06");
		monthMap.put("7", "07");
		monthMap.put("8", "08");
		monthMap.put("9", "09");
		monthMap.put("10", "10");
		monthMap.put("11", "11");
		monthMap.put("12", "12");

		return monthMap;
	}

	/**
	 * 取得前后N年年份中文下拉列表Map
	 * 
	 * @param yearCount
	 *            指定年数
	 * @param addPreYear
	 *            是否取得前N年份(true:是;false:否)
	 * @param addNextYear
	 *            是否取得后N年份(true:是;false:否)
	 * @return 下拉列表Map
	 */
	public static Map<String, String> getYearChineseMap(int yearCount,
			boolean addPreYear, boolean addNextYear) {

		Map<String, String> yearMap = new LinkedHashMap<String, String>();

		// 日历取得
		Calendar cder = Calendar.getInstance();

		int cYear = cder.get(Calendar.YEAR);

		// 前N年
		if (addPreYear) {
			for (int i = yearCount; i >= 1; i--) {
				yearMap.put(String.valueOf(cYear - i),
						String.valueOf(cYear - i) + "年");
			}
		}
		// 今年
		yearMap.put(String.valueOf(cYear), String.valueOf(cYear) + "年");
		// 后N年
		if (addNextYear) {
			for (int j = 1; j <= yearCount; j++) {
				yearMap.put(String.valueOf(cYear + j),
						String.valueOf(cYear + j) + "年");
			}
		}

		return yearMap;
	}

	public static Map<String, String> getMonthChineseMap() {
		Map<String, String> monthMap = new LinkedHashMap<String, String>();

		// 12月份
		monthMap.put("1", "1月");
		monthMap.put("2", "2月");
		monthMap.put("3", "3月");
		monthMap.put("4", "4月");
		monthMap.put("5", "5月");
		monthMap.put("6", "6月");
		monthMap.put("7", "7月");
		monthMap.put("8", "8月");
		monthMap.put("9", "9月");
		monthMap.put("10", "10月");
		monthMap.put("11", "11月");
		monthMap.put("12", "12月");

		return monthMap;
	}

	public static Map<String, String> getWeekMap() {
		Map<String, String> weekMap = new LinkedHashMap<String, String>();
		weekMap.put("0", "星期日");
		weekMap.put("1", "星期一");
		weekMap.put("2", "星期二");
		weekMap.put("3", "星期三");
		weekMap.put("4", "星期四");
		weekMap.put("5", "星期五");
		weekMap.put("6", "星期六");
		return weekMap;
	}

	public static Map<String, String> getQuarterMap() {
		Map<String, String> quarterMap = new LinkedHashMap<String, String>();
		quarterMap.put("1", "第一季度");
		quarterMap.put("2", "第二季度");
		quarterMap.put("3", "第三季度");
		quarterMap.put("4", "第四季度");
		return quarterMap;
	}

	/*
	 * public static String getYearMapJson(int yearCount, boolean addPreYear,
	 * boolean addNextYear) { ArrayList<Map<String, String>> yearList = new
	 * ArrayList<Map<String, String>>(); // 日历取得 Calendar cder =
	 * Calendar.getInstance(); int cYear = cder.get(Calendar.YEAR); Map<String,
	 * String> yearMap = null; // 前N年 if (addPreYear) { for (int i = yearCount;
	 * i >= 1; i--) { yearMap = new LinkedHashMap<String, String>();
	 * yearMap.put(WebUtil.COMBOX_TEXT_FIELD, String.valueOf(cYear - i) + "年");
	 * yearMap.put(WebUtil.COMBOX_VALUE_FIELD, String.valueOf(cYear - i));
	 * yearList.add(yearMap); } } // 今年 yearMap = new LinkedHashMap<String,
	 * String>(); yearMap.put(WebUtil.COMBOX_TEXT_FIELD, String.valueOf(cYear) +
	 * "年"); yearMap.put(WebUtil.COMBOX_VALUE_FIELD, String.valueOf(cYear));
	 * yearList.add(yearMap); // 后N年 if (addNextYear) { for (int j = 1; j <=
	 * yearCount; j++) { yearMap = new LinkedHashMap<String, String>();
	 * yearMap.put(WebUtil.COMBOX_TEXT_FIELD, String.valueOf(cYear + j) + "年");
	 * yearMap.put(WebUtil.COMBOX_VALUE_FIELD, String.valueOf(cYear + j));
	 * yearList.add(yearMap); } } return JsonUtil.Encode(yearList); }
	 * 
	 * public static String getMonthChineseMapJson() { ArrayList<Map<String,
	 * String>> monthList = new ArrayList<Map<String, String>>();
	 * 
	 * for (int i = 1; i <= 12; i++) { Map<String, String> monthMap = new
	 * HashMap<String, String>(); monthMap.put(WebUtil.COMBOX_TEXT_FIELD,
	 * String.valueOf(i) + "月"); monthMap.put(WebUtil.COMBOX_VALUE_FIELD,
	 * String.valueOf(i));
	 * 
	 * monthList.add(monthMap); }
	 * 
	 * return JsonUtil.Encode(monthList); }
	 * 
	 * public static String getWeekMapJson() { ArrayList<Map<String, String>>
	 * weekList = new ArrayList<Map<String, String>>(); String[] num = new
	 * String[] { "星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六" }; for (int i
	 * = 0; i <= 6; i++) { Map<String, String> weekMap = new
	 * LinkedHashMap<String, String>(); weekMap.put(WebUtil.COMBOX_TEXT_FIELD,
	 * num[i]); weekMap.put(WebUtil.COMBOX_VALUE_FIELD, String.valueOf(i + 1));
	 * weekList.add(weekMap); } return JsonUtil.Encode(weekList); }
	 * 
	 * public static String getQuarterMapJson() { ArrayList<Map<String, String>>
	 * quarterList = new ArrayList<Map<String, String>>(); String[] num = new
	 * String[] { "第一季度", "第二季度", "第三季度", "第四季度" }; for (int i = 0; i < 4; i++)
	 * { Map<String, String> quarterMap = new LinkedHashMap<String, String>();
	 * quarterMap.put(WebUtil.COMBOX_TEXT_FIELD, num[i]);
	 * quarterMap.put(WebUtil.COMBOX_VALUE_FIELD, String.valueOf(i + 1));
	 * quarterList.add(quarterMap); } return JsonUtil.Encode(quarterList); }
	 */

	/**
	 * 取得客户端真实IP
	 * 
	 * @param request
	 * @return 客户端真实IP
	 */
	public static String getIpAddr(HttpServletRequest request) {
		String ip = request.getHeader("X-Forwarded-For");
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("WL-Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("HTTP_CLIENT_IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("HTTP_X_FORWARDED_FOR");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getRemoteAddr();
		}
		return ip;
	}

	/**
	 * 根据当前系统时间生成ID
	 * 
	 * @return 精确到毫秒
	 */
	public static long IdGenerator() {

		long baseId;
		long t = System.currentTimeMillis();
		// 52~43
		baseId = t;
		baseId &= 0x1FF0000000L;
		baseId <<= 14;
		// 28~15
		t &= 0xFFFC000L;
		baseId |= t;
		// 42~29
		SecureRandom ng = new SecureRandom();
		t = ng.nextLong();
		t &= 0x3FFF0000000L;
		// 14~1
		baseId |= t;
		baseId |= t;
		baseId /= 10000;
		baseId *= 10000;
		baseId &= 0x1FFFFFFFFFFFFL;
		return baseId;

	}

	/**
	 * 查询数据字典
	 * 
	 * @param category
	 *            数据字典类型
	 * @return List<Code> 返回
	 */
//	public static List<Code> findListCode(String category) {
//		List<Code> list = new ArrayList<Code>();
//		Criteria criteria = new Criteria();
//		criteria.put("codeCategory", category);
//		criteria.setOrderByClause("sort");
//		CodeService codeService = SpringContextHolder
//				.getBean("codeServiceImpl");
//		list = codeService.selectByParams(criteria);
//		return list;
//	}
//
//	/**
//	 * 根据字段值和数据字典类型查询字段显示值
//	 * 
//	 * @param codeValue
//	 * @param category
//	 * @return
//	 */
//	public static String findDisplayByParams(String codeValue, String category) {
//		Criteria criteria = new Criteria();
//		criteria.put("codeValue", codeValue);
//		criteria.put("codeCategory", category);
//		CodeService codeService = SpringContextHolder
//				.getBean("codeServiceImpl");
//		List<Code> list = codeService.selectByParams(criteria);
//		Code code = list.get(0);
//		return code.getCodeDisplay();
//	}

	/**
	 * 生成指定位数随机密码
	 * 
	 * @return 随机密码
	 */
	public static String randomPwd(int length) {

		String randomPwd = "";
		StringBuffer buffer = new StringBuffer(
				"0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ");
		Random r = new Random();
		int range = buffer.length();
		for (int i = 0; i < length; i++) {
			randomPwd += buffer.charAt(r.nextInt(range));
		}
		return randomPwd;
	}

	/**
	 * 小时转换成微秒
	 * 
	 * @param hour
	 * @return
	 */
	public static long convertTime(String hour) throws NullPointerException,
			NumberFormatException {
		double t = Double.parseDouble(hour);
		return (long) (t * 60 * 60 * 1000);
	}

	public static final void mergeObject(Object dest, Object orig){
		BeanUtilsBean bean = BeanUtilsBean.getInstance();
		PropertyDescriptor origDescriptors[] = bean.getPropertyUtils().getPropertyDescriptors(orig);
		for (int i = 0; i < origDescriptors.length; i++) {
			String name = origDescriptors[i].getName();
			if ("class".equals(name)) {
				continue; 
			}
			if (bean.getPropertyUtils().isReadable(orig, name) && bean.getPropertyUtils().isWriteable(dest, name)) {
				try {
					Object value = bean.getPropertyUtils().getSimpleProperty(orig, name);
					if (isNotBlank(value)) {
						bean.copyProperty(dest, name, value);
					}
				} catch (NoSuchMethodException e) {
					; // Should not happen
				} catch(Exception e) {
					throw new RuntimeException(e);
				}
			}
		}
	}

	public static final boolean isNotBlank(Object obj) {
		if (obj == null) {
			return false;
		} else if (obj.getClass() == String.class) {
			if (StringUtils.isNotBlank((String) obj)) {
				return true;
			} else {
				return false;
			}
		} else {
			return true;
		}
	}

}
