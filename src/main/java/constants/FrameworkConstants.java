package constants;

import base.ConfigLoader;

public class FrameworkConstants {
	
    public static final String BASE_URL = ConfigLoader.get("baseUrl");
    public static final String SCREENSHOT_PATH = "screenshots/";
    public static final String REPORT_PATH = "reports/";
    public static final String TESTDATA_PATH = "resources/testdata/DataSource.xlsx";
    
}