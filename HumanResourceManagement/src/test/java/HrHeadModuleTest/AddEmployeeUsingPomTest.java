package HrHeadModuleTest;

import java.io.IOException;
import java.util.HashMap;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.hrm.genericUtils.BaseClass;
import com.hrm.genericUtils.ExcelUtility;
import com.hrm.genericUtils.FileUtility;
import com.hrm.genericUtils.WebDriverUtilities;

import com_HRM.ObjectRepository.AddEmployeeNewWindowPage;
import com_HRM.ObjectRepository.HomePage;
import com_HRM.ObjectRepository.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class AddEmployeeUsingPomTest 
{
	

	public static void main(String[] args) throws Throwable 
{
		
		FileUtility fLib = new FileUtility();
	    WebDriverUtilities wLib = new WebDriverUtilities();
		ExcelUtility eLib = new ExcelUtility();
		
		//To fetch data from property file
		String BROWSER = fLib.getPropertyKeyValue("browser");
		String URL = fLib.getPropertyKeyValue("url");
		String USERNAME = fLib.getPropertyKeyValue("username");
		String PASSWORD = fLib.getPropertyKeyValue("password");
		
		WebDriver driver = null;
		if(BROWSER.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();

			driver = new ChromeDriver();
		}
		else if (BROWSER.equalsIgnoreCase("firefox"))
		{
			driver = new FirefoxDriver();
		}
		else
		{
			System.out.println("Invalid browser");
		}
	
			//maximize the browser	
		wLib.maximizeTheBrowser(driver);
		//pass the url
		driver.get(URL);
		
		//implicitWait
		wLib.implicitWait(driver, 10);
	
		//login to the application
		LoginPage lp=new LoginPage(driver);
		lp.login( USERNAME, PASSWORD,"→ HR Head");
		//handle login popup
		wLib.acceptAlertPopup(driver, "Login Successfully!!");
		
		//click on eployee
		HomePage hp = new HomePage(driver);
		hp.home();
		
		//addEmployee
		AddEmployeeNewWindowPage emp=new AddEmployeeNewWindowPage(driver);
	  emp.addEmployee(eLib.getMultipleDataFromExcel("Sheet1", 0, 1, driver), driver);
	}

}
