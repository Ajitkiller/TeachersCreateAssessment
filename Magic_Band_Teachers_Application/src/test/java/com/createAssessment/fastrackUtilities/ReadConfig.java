package com.createAssessment.fastrackUtilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;


public class ReadConfig {

	
	Properties pro;
	
	public ReadConfig() {
		
		File src=new File("./Configuration\\Config.properties");
		try {
			FileInputStream fis=new FileInputStream(src);
			pro=new Properties();
			pro.load(fis);
		}
		catch (Exception e) {
			System.out.println("Exception is "+e.getMessage());
		}
	}
	public String getBaseurl()
	{
		String baseUrl=pro.getProperty("baseUrl");
		return baseUrl;
	}
	
	public String getFormUrl()
	{
		String url=pro.getProperty("baseUrl");
		return url;
	}
	
	public String getChromePath()
	{
		String chromepath=pro.getProperty("chromepath");
		return chromepath;
	}
	public String getFirefoxPath()
	{
		String firefoxpath=pro.getProperty("firefoxpath");
		return firefoxpath;
	}
	public String getIEPath()
	{
		String iepath=pro.getProperty("iepath");
		return iepath;
	}
	public String getMSEdgePath()
	{
		String msedgepath=pro.getProperty("msedgepath");
		return msedgepath;
	}
	
	public String getReviewUrl()
	{
		String reviewUrl=pro.getProperty("ReviewLoginUrl");
		return reviewUrl;
	}
	public String getFastrackTestUrl()
	{
		String FastrackTest=pro.getProperty("FastrackTest");
		return FastrackTest;
	}
	public String getFastrackProdUrl()
	{
		String FastrackTest=pro.getProperty("FastrackTest");
		return FastrackTest;
	}
	
}
