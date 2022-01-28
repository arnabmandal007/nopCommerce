package com.nopCommerce.testCases;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.nopCommerce.utilities.ReadConfig;

public class BaseClass {
	
	ReadConfig readconfig= new ReadConfig();
	
	public String baseURL = readconfig.getapplicationURL();
	public String username = "admin@yourstore.com";
	public String password = "admin";
	public static WebDriver driver;
	public static Logger logger;
	
	@BeforeClass
	@Parameters ("browser")
	public void setup(String br)
	{
		logger=Logger.getLogger("nopCommerce");
		PropertyConfigurator.configure("Log4j.properties");
		
		if (br.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", readconfig.getchromepath());
			driver=new ChromeDriver();
		}
		else if (br.equals("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", readconfig.getfrefoxpath());
			driver=new FirefoxDriver();
		}
		
	}
	
	@AfterClass
	public void BrowserClose()
	{
		driver.quit();
	}

	public void captureScreen(WebDriver driver, String tname) throws IOException
	{
		TakesScreenshot ts= (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir"));
		FileUtils.copyFile(source, target);
		System.out.println("Screenshot taken");
	}
	
	
}
