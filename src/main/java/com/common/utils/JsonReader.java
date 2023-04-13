package com.common.utils;

import com.qmetry.qaf.automation.util.Reporter;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Reads the JSON files available in class path
 *
 * JSON files must have env object at 1st level and within that other
 * properties/objects should be defined.
 *
 * ENV system property must be set to use this class
 *
 * @author Ostan Dsouza
 *
 */
public class JsonReader {
	private static final Map<String, JSONObject> FILE_TO_PROPS = new HashMap<>();
	private static String env;

	private JsonReader() {
		// All methods are static, so restrict object creation
	}

	public static JSONObject loadJsonFile(File file) {
		String filePath = file.getAbsolutePath();
		JSONObject jsonContent = FILE_TO_PROPS.getOrDefault(filePath, null);

		if (jsonContent == null) {
			try {
				jsonContent = (JSONObject) new JSONParser().parse(new FileReader(file));
				FILE_TO_PROPS.put(filePath, jsonContent);
				System.out.println("Loaded json file");
			} catch (IOException ioe) {
				System.out.println("IOException while reading file to map. Error[{}]");
			} catch (ParseException pe) {
				System.out.println("ParseException while parsing file content to JSONObject. Error[{}]");
			}
		}

		return jsonContent;
	}

	/**
	 * This method loads JSON file and returns env.header key from JSON content. ENV
	 * system property must be set to use this function
	 *
	 * @param fileName
	 * @param header
	 * @param dirs     parent directories
	 * @return Object for env.key in JSON object. This can be string, JSONArray,
	 *         int, bool, etc.
	 */
	@SuppressWarnings("unchecked")
	public static Object getJsonProperties(String fileName, String header, String... dirs) {
		File propFile = ClasspathResourceHelper.getPropertyFileByLocale(fileName, ClasspathResourceHelper.FileType.JSON, dirs);
		JSONObject jsonContent = loadJsonFile(propFile);

		Object val = jsonContent.get(header); // default value (could be null), e.g., props common for all envs

		if (env != null && jsonContent.containsKey(env)) {
			jsonContent = (JSONObject) jsonContent.get(env);
			if (jsonContent.containsKey(header)) {
				// override common value if env specific value is present
				Object envVal = jsonContent.get(header);

				if (val instanceof Map && envVal instanceof Map) {
					Map<String, Object> valMap = (Map<String, Object>) val;
					Map<String, Object> envValMap = (Map<String, Object>) envVal;
					for (String key : envValMap.keySet()) {
						valMap.put(key, envValMap.get(key));
					}
				} else {
					val = envVal;
				}
			}
		}

		return val;
	}

	/**
	 * This method loads JSON file and returns env.header key from JSON content. ENV
	 * system property must be set to use this function
	 *
	 * @param fileName
	 * @param header
	 * @param dirs     parent directories
	 * @return Object for env.key in JSON object. This can be string, JSONArray,
	 *         int, bool, etc.
	 */
	@SuppressWarnings("unchecked")
	public static Map<String, String> getMap(String fileName, String header, String... dirs) {
		Object valObj = getJsonProperties(fileName, header, dirs);
		Map<String, String> retVal = null;

		if (valObj instanceof Map) {
			retVal = (Map<String, String>) valObj;
			System.out.println("value retrieved");
		}

		return retVal;
	}

	/**
	 * This method loads JSON file and returns env.header key as a JSONObject from
	 * JSON content. ENV system property must be set to use this function. If value
	 * is not JSONObject, it will return null.
	 *
	 * @param fileName
	 * @param header
	 * @param dirs     parent directories
	 * @return JSONObject
	 */
	@SuppressWarnings("unchecked")
	public static JSONObject getJsonObject(String fileName, String header, String... dirs) {

		Object valObj = getJsonProperties(fileName, header, dirs);
		JSONObject retVal = null;

		if (valObj instanceof Map) {
			retVal = new JSONObject((Map<String, ?>) valObj);
		} else if (valObj instanceof JSONObject) {
			retVal = (JSONObject) valObj;
		}

		if (retVal != null) {
			System.out.println("value retrieved");
		}
		return retVal;
	}

	/**
	 * This method loads specified JSON file under test_data folder in class path
	 * and returns env+header key as a JSONObject from JSON content. ENV system
	 * property must be set to use this function. If value is not JSONObject, it
	 * will return null.
	 *
	 * @param fileName
	 * @param header
	 * @return JSONObject
	 */
	public static JSONObject getJsonObjectTestData(String fileName, String header) {
		return getJsonObject(fileName, header, "test_data");
	}

	/**
	 * This method loads JSON file and returns env.header key as a Object of T class
	 * from JSON content. ENV system property must be set to use this function. If
	 * value is not of T class, it will return null.
	 *
	 * @param fileName
	 * @param header
	 * @return T type object
	 */
	@SuppressWarnings("unchecked")
	public static <T> T getTypeValue(String fileName, String header, Class<T> t, String... dirs) {
		T retVal = null;
		Object valObj = getJsonProperties(fileName, header, dirs);

		if (t.isAssignableFrom(valObj.getClass())) {
			retVal = (T) valObj;
			System.out.println("value retrieved");
		}

		return retVal;
	}

	/**
	 * Reads specified JSON file under test_data folder in class path
	 *
	 * @param fileName
	 * @param header
	 * @return Map
	 */
	public static Map<String, String> getMapTestData(String fileName, String header) {
		return getMap(fileName, header, "test_data");
	}

	/**
	 * This method loads JSON file and returns env.header.key key as a String from
	 * JSON content. ENV system property must be set to use this function. If key is
	 * not present it returns defaultVal
	 *
	 * @param fileName
	 * @param header
	 * @param key
	 * @param defaultVal
	 * @param dirs       parent directories
	 * @return String value
	 */
	public static String getString(String fileName, String header, String key, String defaultVal, String... dirs) {
		String retVal = defaultVal;
		JSONObject jsonObj = getJsonObject(fileName, header, dirs);

		if (jsonObj != null) {
			retVal = jsonObj.get(key).toString();
		}
		System.out.println("retVal[{}]");

		return retVal;
	}

	/**
	 * This method returns a particular value for a specified key from specified
	 * JSON file under test_data
	 *
	 * @param fileName
	 * @param header
	 * @param key
	 * @return
	 */
	public static String getStringTestData(String fileName, String header, String key) {
		return getStringTestData(fileName, header, key, null);
	}

	/**
	 * This method returns a particular value for a specified key from specified
	 * JSON file under test_data
	 *
	 * @param fileName
	 * @param header
	 * @param key
	 * @param defaultVal
	 * @return
	 */
	public static String getStringTestData(String fileName, String header, String key, String defaultVal) {
		return getString(fileName, header, key, defaultVal, "test_data");
	}

}
