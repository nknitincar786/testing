package testing.packages.tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

import testing.packages.resources.Base;

public class DemoTest extends Base{

	public static Logger log = LogManager.getLogger(Base.class.getName());
	
	@Test
	public void test()
	{
		extentTest = extentReports.startTest("test");
		log.info("Hi");
	}
	
}
