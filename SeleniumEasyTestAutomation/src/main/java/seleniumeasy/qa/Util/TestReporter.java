package seleniumeasy.qa.Util;

import java.util.List;

import org.testng.IReporter;
import org.testng.ISuite;
import org.testng.reporters.IReporterConfig;
import org.testng.xml.XmlSuite;

public class TestReporter implements IReporter{

	/* (non-Javadoc)
	 * @see org.testng.IReporter#generateReport(java.util.List, java.util.List, java.lang.String)
	 */
	public void generateReport(List<XmlSuite> xmlSuites, List<ISuite> suites, String outputDirectory) {
		// TODO Auto-generated method stub
		//IReporter.super.generateReport(xmlSuites, suites, outputDirectory);
		
		for(ISuite iSuite:suites)
		{
			String sSuiteName = iSuite.getName();
			
			
		}
	}

	/* (non-Javadoc)
	 * @see org.testng.IReporter#getConfig()
	 */
	public IReporterConfig getConfig() 
	{
		return null;
		// TODO Auto-generated method stub
		//return IReporter.super.getConfig();
	}

}
