package com.longke.manager.project.util;  

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.input.SAXBuilder;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
/** 
 * ClassName:JsonUtil <br/> 
 * Function: Json工具类. <br/> 
 * Date:     2017年11月8日 下午4:26:47 <br/> 
 * @author   "Alex Hu" 
 * @version  1.0.0
 * @since    JDK 1.7
 */
public class JsonUtil {
	// 定义jackson对象
	private static final ObjectMapper MAPPER = new ObjectMapper();

	/**
	 * 
	 * objectToJson:(将对象转换成json字符串). <br/> 
	 * 
	 * @author "Alex Hu" 
	 * @param data 对象信息
	 * @return 对象json字符串
	 * @since JDK 1.7
	 */
	public static String objectToJson(Object data) {
		try {
			String string = MAPPER.writeValueAsString(data);
			return string;
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 
	 * jsonToPojo:(将json结果集转化为对象). <br/> 
	 * 
	 * @author "Alex Hu" 
	 * @param jsonData json字符串
	 * @param beanType 对象信息
	 * @return 对象信息
	 * @since JDK 1.7
	 */
	public static <T> T jsonToPojo(String jsonData, Class<T> beanType) {
		try {
			T t = MAPPER.readValue(jsonData, beanType);
			return t;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 
	 * jsonToList:(将json数据转换成pojo对象list). <br/> 
	 * 
	 * @author "Alex Hu" 
	 * @param jsonData json字符串 
	 * @param beanType 对象类型
	 * @return 对象列表
	 * @since JDK 1.7
	 */
	public static <T>List<T> jsonToList(String jsonData, Class<T> beanType) {
		JavaType javaType = MAPPER.getTypeFactory().constructParametricType(List.class, beanType);
		try {
			List<T> list = MAPPER.readValue(jsonData, javaType);
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	/**
	 * 
	 * xml2JSON:(将xml文件内容转化为json字符串格式). <br/> 
	 * 
	 * @author "Alex Hu" 
	 * @param xml xml格式的文件内容
	 * @return 转化后的json字符串
	 * @since JDK 1.7
	 */
	public static String xml2JSON(String xml) {    
		JSONObject obj = new JSONObject();    
		try {    
			InputStream is = new ByteArrayInputStream(xml.getBytes("utf-8"));    
			SAXBuilder sb = new SAXBuilder();    
			Document doc = sb.build(is);    
			Element root = doc.getRootElement();    
			obj.put(root.getName(), iterateElement(root));    
			return obj.toString();    
		} catch (Exception e) {    
			e.printStackTrace();    
			return null;    
		}    
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	private static Map iterateElement(Element element) {    
		List jiedian = element.getChildren();    
		Element et = null;    
		Map obj = new HashMap();    
		List list = null;    
		for (int i = 0; i < jiedian.size(); i++) {    
			list = new LinkedList();    
			et = (Element) jiedian.get(i);    
			if (et.getTextTrim().equals("")) {    
				if (et.getChildren().size() == 0)    
					continue;    
				if (obj.containsKey(et.getName())) {    
					list = (List) obj.get(et.getName());    
				}    
				list.add(iterateElement(et));    
				obj.put(et.getName(), list);    
			} else {    
				if (obj.containsKey(et.getName())) {    
					list = (List) obj.get(et.getName());    
				}    
				list.add(et.getTextTrim());    
				obj.put(et.getName(), list);    
			}    
		}    
		return obj;    
	} 
}
