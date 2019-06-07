package com.zoopla.qa.util;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import com.zoopla.qa.base.TestBase;


public class TestUtil extends TestBase{

	public static long PAGE_LOAD_TIMEOUT=50;
	public static long IMPLICIT_WAIT=10;
	
	public static void takeScreenshotTest()  throws IOException
	{
		try{
			TakesScreenshot ts=(TakesScreenshot)driver;
			File source =ts.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(source, new File(".\\Screenshots\\"+ System.currentTimeMillis()+".png"));
		} catch (Exception e){
			e.printStackTrace();
		} 			 
	}
}
