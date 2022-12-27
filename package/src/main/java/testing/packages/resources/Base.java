package testing.packages.resources;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Base implements IAutoConstant{

	static
	{
		System.setProperty(CHROME_KEY, CHROME_VALUE);
		System.setProperty(GECKO_VALUE, GECKO_VALUE);
	}
	
	public static ExtentReports extentReports;
	public static ExtentTest extentTest;
	public static WebDriver driver;
	
	@BeforeTest
	public static void extentReportsInitialization()
	{
		extentReports = new ExtentReports(System.getProperty("user.dir")+"/reporter/index.html", true);
	}
	
	@BeforeClass
	public static void openBrowser() throws IOException
	{
		Properties properties = new Properties();
		FileInputStream fis = new FileInputStream("C:\\Users\\nitinbet\\eclipse-workspace\\package\\src\\main\\java\\testing\\packages\\resources\\data.properties");
		properties.load(fis);
		String browser = properties.getProperty("browser");
		if(browser.equals("chrome"))
		{
			driver = new ChromeDriver();
		}
		else
		{
			driver = new FirefoxDriver();
		}
		driver.manage().timeouts().implicitlyWait(ITO, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}
	
	@BeforeMethod
	public static void openURL()
	{
		driver.get(URL);
	}
	
	@AfterMethod
	public static void tearDown(ITestResult result)
	{
		if(result.getStatus() == ITestResult.FAILURE)
		{
			extentTest.log(LogStatus.FAIL, "Test case failed is"+result.getName());
			extentTest.log(LogStatus.FAIL, "Test case failed is"+result.getThrowable());
			
			
		}
		else if(result.getStatus() == ITestResult.SKIP)
		{
			extentTest.log(LogStatus.SKIP, "Test case skipped is"+result.getName());
		}
		else if(result.getStatus() == ITestResult.SUCCESS)
		{
			extentTest.log(LogStatus.PASS, "Test case passed is"+result.getName());
		}
		extentReports.endTest(extentTest);
		driver.close();
	}
	
	@AfterTest
	public static void endReport()
	{
		extentReports.flush();
		extentReports.close();
	}
	
}
