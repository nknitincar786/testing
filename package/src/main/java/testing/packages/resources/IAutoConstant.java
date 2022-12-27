package testing.packages.resources;

public interface IAutoConstant {

	String CHROME_KEY = "webdriver.chrome.driver";
	String CHROME_VALUE = "./driver/chromedriver.exe";
	String GECKO_KEY = "webdriver.gecko.driver";
	String GECKO_VALUE = "./driver/geckodriver.exe";
	
	long ETO = 20;
	long ITO = 20;
	
	String filePath = "./DataInput/dataInput.xlsx";
	String resultPath = "./DataOutput/dataOutput.xlsx";
	String photoPath = "./screenshots/";
	
	String URL = "http://www.google.com";
	
}
