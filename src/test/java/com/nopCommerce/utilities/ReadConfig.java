package com.nopCommerce.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {

	Properties pro;
	
	public ReadConfig()
	{
		File src=new File("./Configuration/config.properties");
		
		try
		{
			FileInputStream fis = new FileInputStream(src);
			pro = new Properties();
			pro.load(fis);
		} catch (Exception e)
		{
			System.out.println("Exception is "+ e.getMessage());
		}
		
	}
	
	
	public String getapplicationURL()
	{
		String url=pro.getProperty("baseURL");
		return url;
	}
	
	public String getchromepath()
	{
		String chrome=pro.getProperty("chromepath");
		return chrome;
	}
	
	public String getfrefoxpath()
	{
		String firefox=pro.getProperty("firefoxpath");
		return firefox;
	}
	
	
	
}
