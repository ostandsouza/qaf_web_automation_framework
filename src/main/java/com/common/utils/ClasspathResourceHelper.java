package com.common.utils;

import com.qmetry.qaf.automation.util.Reporter;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

/**
 * This class helps to retrieve classpath resource. Resource can be
 * property/json file. It also supports retrieving resource with locale if LANG
 * system property is available
 *
 * @author OstanDsouza
 *
 */
public class ClasspathResourceHelper {
	private static final Map<String, File> FILE_PATH_TO_FILE = new HashMap<>();

	private ClasspathResourceHelper() {
		// All methods are static, so restrict object creation
	}

	public enum FileType {
		JSON(".json"), PROPERTIES(".properties"), XLSX(".xlsx");

		FileType(String ext) {
			this.ext = ext;
		}

		public String getExt() {
			return ext;
		}

		private String ext;
	}

	/**
	 * Retrieves File for provided fileName and ext if file exists, otherwise
	 * returns null object
	 *
	 * @param fileName fileName without extension
	 * @param ext      file extension
	 * @param dirs     parentDirs
	 * @return File object
	 */
	public static File getPropertyFile(String fileName, FileType ext, String... dirs) {
		String fileNameWithExt = fileName + ext.getExt();
		return getPropertyFile(fileNameWithExt, dirs);
	}

	/**
	 * Retrieves File for provided fileNameWithExt if file exists, otherwise returns
	 * null object
	 *
	 * @param fileNameWithExt fileName with extension
	 * @param dirs            parentDirs
	 * @return File object
	 */
	public static File getPropertyFile(String fileNameWithExt, String... dirs) {
		String parentDirs = null;
		if (dirs.length > 0) {
			parentDirs = String.join(File.separator, dirs);
		}
		String fileStr = new File(parentDirs, fileNameWithExt).toString();
		File propFile = FILE_PATH_TO_FILE.getOrDefault(fileStr, null);

		if (propFile == null) {
			URL propFileURL = ClasspathResourceHelper.class.getClassLoader().getResource(fileStr); // file on class path
			Reporter.log("propFileURL[{}]");
			if (propFileURL != null) {
				if (propFileURL.toString().contains(".jar")) {
					try {
						InputStream fileStream = propFileURL.openStream();
						propFile = new File(fileStr);
						FileUtils.copyInputStreamToFile(fileStream, propFile);
					} catch (IOException e) {
						Reporter.log("IOException occured while copying input stream to file object. Error[{}]");
						propFile = null;
					}
				} else {
					try {
						propFile = Paths.get(propFileURL.toURI()).toFile();
					} catch (URISyntaxException use) {
						Reporter.log("URISyntaxException occured while converting file url to file object. Error[{}]");
					}
				}
			}

			if (propFile == null) {
				Reporter.log("{} file is not found");
			} else {
				FILE_PATH_TO_FILE.put(fileStr, propFile);
			}
		}

		return propFile;
	}

	/**
	 * This method checks if LANG system property is available or not and if it is
	 * available, appends it to fileName and then uses getPropertyFile function to
	 * retrieve file object.
	 *
	 * @param fileName fileName without extension
	 * @param ext      file extension
	 * @param dirs     parentDirs
	 * @return File object
	 */
	public static File getPropertyFileByLocale(String fileName, FileType ext, String... dirs) {
		String locale = System.getProperty("LANG");
		if (locale != null) {
			fileName += "_" + locale;
		}

		return getPropertyFile(fileName, ext, dirs);
	}
}
