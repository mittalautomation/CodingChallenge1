package com.zoopla.qa.testutils;

import java.io.File;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.zoopla.qa.base.TestBase;

public class TestListeners extends TestBase implements ITestListener {

	public void onTestStart(ITestResult result) {
		System.out.println("<----"+result.getName()+"  is Started---->");
		log.info("<----"+result.getName()+ "  is Started---->");
	}

	public void onTestSuccess(ITestResult result) {
		System.out.println("<----"+result.getName()+"  was Passed---->");
		log.info("<----"+result.getName()+ "  was Passed---->");
	}
	

	public void onTestFailure(ITestResult result) {
		log.error("<----"+result.getName()+ "  was Failed---->");
		try {
			File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			File destFile= new File(".\\Screenshots\\" + result.getName() + ".png");
			FileHandler.copy(scrFile,destFile);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	public void onTestSkipped(ITestResult result) {
		System.out.println("<----"+result.getName()+ "  was Skipped---->");
		log.warn("<----"+result.getName()+ "  was Skipped---->");
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

}
