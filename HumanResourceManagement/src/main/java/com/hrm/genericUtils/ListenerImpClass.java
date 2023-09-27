package com.hrm.genericUtils;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.Listeners;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListenerImpClass implements ITestListener 
{
    ExtentReports report;
    ExtentTest test;
    
	@Override
	public void onTestStart(ITestResult result)
	{
		//actual testscripts execution starts from here
		String MethodName=result.getMethod().getMethodName();
		test=report.createTest(MethodName);
		Reporter.log(MethodName+"---->>Execution Starts");
		
		
	}

	@Override
	public void onTestSuccess(ITestResult result)
	{
		String MethodName=result.getMethod().getMethodName();
		test.log(Status.PASS,MethodName+"----Passed" );
		Reporter.log(MethodName+"----Test Script Executed Successfully");
		
	}

	@Override
	public void onTestFailure(ITestResult result) 
	{
		String MethodName=result.getMethod().getMethodName();
		try {
			String failedScript = WebDriverUtilities.takeScreenshot(BaseClass.sdriver, MethodName);
			test.addScreenCaptureFromPath(failedScript);
			
		} catch (Exception e) 
		{
		  e.printStackTrace();
		}
		test.log(Status.FAIL, result.getThrowable());
		test.log(Status.FAIL, MethodName+"----Failed");
		Reporter.log(MethodName+"----->Failed");		
		}
		
		
	@Override
	public void onTestSkipped(ITestResult result) 
	{
		String MethodName=result.getMethod().getMethodName();
	}

	@Override
	public void onStart(ITestContext context) 
	{
		//create report
		ExtentSparkReporter htmlreport=new ExtentSparkReporter("./ExtentReport/report.html");
		htmlreport.config().setDocumentTitle("SDET-51");
		htmlreport.config().setTheme(Theme.STANDARD);
		htmlreport.config().setReportName("Human Resource Management");
		report=new ExtentReports();
		report.attachReporter(htmlreport);
		report.setSystemInfo("OS", "Windows-10");
		report.setSystemInfo("Base-Browser", "chrome");
		report.setSystemInfo("Base-URL", "http://rmgtestingserver/domain/HRM_System/");
		report.setSystemInfo("Reporter Name", "Soumitra Dhar");
		
		
	}

	@Override
	public void onFinish(ITestContext context)
	{
		report.flush();
	
	}
	
	
	

}
