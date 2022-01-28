package com.nopCommerce.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.nopCommerce.pageObjects.LoginPage;

public class TC001_LoginTest extends BaseClass {

	
	
	@Test
	public void LoginTest() throws InterruptedException, IOException
	{
		
		driver.get(baseURL);
		logger.info("URL is Opened");
		
		LoginPage lp=new LoginPage(driver);
		
		lp.clicklogin();
		logger.info("Login is clicked");
		Thread.sleep(3000);
		
		if (driver.getTitle().equals("Dashboard / nopCommerce administration"))
		{
			Assert.assertTrue(true);
			lp.clicklogout();
			logger.info("Login passed");
		}
		else
		{
			captureScreen(driver, "TC001_LoginTest");
			Assert.fail();
			logger.info("Login failed");
		}
		
	}
	


}
