package testing.packages.tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

import testing.packages.resources.Base;

public class PresentationTest extends Base{

	public static Logger log = LogManager.getLogger(Base.class.getName());
	
	@Test
	public void testing()
	{
		extentTest = extentReports.startTest("testing");
		log.info("Hello");
	}
	
}
