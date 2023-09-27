package HrHeadModuleTest;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.asserts.SoftAssert;

import com.hrm.genericUtils.BaseClass;
import com.hrm.genericUtils.ExcelUtility;
import com.hrm.genericUtils.FileUtility;
import com.hrm.genericUtils.WebDriverUtilities;

import com_HRM.ObjectRepository.AddCorporatePage;
import com_HRM.ObjectRepository.HomePage;
import com_HRM.ObjectRepository.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class AddCorporatePomTest 
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
		lp.login( USERNAME, PASSWORD,"→ HR Head" );
		//handle login popup
	    wLib.acceptAlertPopup(driver, "Login Successfully!!");
	    
	   // validate 
	    String expected="Admin | Dhoom";
	    String actual=driver.getTitle();
	    System.out.println(actual);
	    assertEquals(actual, expected);
	   
	    
		//go to corporate
	    HomePage hp=new HomePage(driver);
	    hp.corporate();
	    
//	    
	}

}
