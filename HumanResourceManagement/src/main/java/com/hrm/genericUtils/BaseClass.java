package com.hrm.genericUtils;

import java.io.IOException;
import java.sql.SQLException;

import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com_HRM.ObjectRepository.HomePage;
import com_HRM.ObjectRepository.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass 
{
	public static WebDriver sdriver;
	
	
	public DatabaseUtility dLib=new DatabaseUtility();
	public ExcelUtility eLib=new ExcelUtility();
	public FileUtility fLib=new FileUtility();
	public JavaUtility jLib=new JavaUtility();
	public WebDriverUtilities wLib=new WebDriverUtilities();
	
	public WebDriver driver;
	
	@BeforeSuite(alwaysRun = true)
	public void confBS() throws Throwable
	{
		dLib.connectToDB();
		System.out.println("----connect to database----");
	}
	
	@Parameters("browser")
	@BeforeClass(alwaysRun = true)
	public void confBC() throws Throwable
	{
		String browser=fLib.getPropertyKeyValue("browser");
		if(browser.equalsIgnoreCase("chrome"))
		{
		WebDriverManager.chromedriver().setup();

			driver=new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("edge"))
		{
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
			
		}
		else
		{
			System.out.println("----invalid browser---");
		}
		System.out.println("----launch the browser---");
		sdriver=driver;
		
		wLib.maximizeTheBrowser(driver);
		
	}
	@BeforeMethod(alwaysRun = true)
	public void confBM() throws Throwable
	{
		String URL=fLib.getPropertyKeyValue("url");
		String USERNAME = fLib.getPropertyKeyValue("username");
		String PASSWORD = fLib.getPropertyKeyValue("password");
		String text = "→ HR Head";
		driver.get(URL);
		wLib.implicitWait(driver, 10);
		LoginPage lp=new LoginPage(driver);
				lp.login(USERNAME, PASSWORD, text);
		
	}
	@AfterMethod(alwaysRun = true)
	public void confAM()
	{
		HomePage hp=new HomePage(driver);
		hp.getUserLookUpImage();
		System.out.println("----signout from application---");
		
	}
	@AfterClass(alwaysRun = true)
	public void confAC()
	{
		driver.quit();
		System.out.println("---close the browser---");
	}
	@AfterSuite(alwaysRun = true)
	public void confAS() throws Throwable
	{
		dLib.connectToDB();
		System.out.println("----db closed----");
	}
	


}
