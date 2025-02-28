/************************************************************
 Environment values like App url,authentication etc are saved 
 in a constants class.Values are saved as static to make it 
 available across all classes.Values are saved as threadLocal 
 to ensures that each thread gets its own instance of a variable 
 during parallel test execution and to avoid racing condition.
 *************************************************************/

package com.constants;

public class EnvironmentConstants {

	// ThreadLocal variables for configuration
	private static ThreadLocal<String> USERNAME = ThreadLocal.withInitial(() -> "");
	private static ThreadLocal<String> PASSWORD = ThreadLocal.withInitial(() -> "");
	private static ThreadLocal<String> ROLE = ThreadLocal.withInitial(() -> "");
	private static ThreadLocal<String> APP_URL = ThreadLocal.withInitial(() -> "");
	private static ThreadLocal<String> BROWSER_TYPE = ThreadLocal.withInitial(() -> "");
	private static ThreadLocal<String> OS_TYPE = ThreadLocal.withInitial(() -> "");

	public static String EXCEL_FILE_PATH = "./src/test/resources/TestData.xlsx";
	public static String PROPERTIES_FILE_PATH = "./src/test/resources/Config/Config.properties";
public static String GOOGLE_API_KEY="./src/test/resources/graphic-abbey-451818-g4-4d1a40a330d6.json";
	
	
	public void setBrowserType(ThreadLocal<String> browserType) {
		BROWSER_TYPE = browserType;
	}

	public void setAppUrl(ThreadLocal<String> appUrl) {
		APP_URL = appUrl;
	}

	public void setUsername(ThreadLocal<String> username) {
		USERNAME = username;
	}

	public void setPassword(ThreadLocal<String> password) {
		PASSWORD = password;
	}

	public void setRole(ThreadLocal<String> role) {
		ROLE = role;
	}

	public void setOsType(ThreadLocal<String> osType) {
		OS_TYPE = osType;
	}

	public String getBrowserType() {
		String browser = BROWSER_TYPE.get();

		return browser;
	}

	public String getAppUrl() {
		String appurl = APP_URL.get();

		return appurl;
	}

	public String getUsername() {
		String username = USERNAME.get();

		return username;
	}

	public String getPassword() {
		String password = PASSWORD.get();

		return password;
	}

	public String getRole() {
		String role = ROLE.get();

		return role;
	}

	public String getOsType() {
		String ostype = OS_TYPE.get();

		return ostype;
	}

}
