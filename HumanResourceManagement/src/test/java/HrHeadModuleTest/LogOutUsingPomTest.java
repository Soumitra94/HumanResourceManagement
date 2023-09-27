package HrHeadModuleTest;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.hrm.genericUtils.BaseClass;

import com_HRM.ObjectRepository.HomePage;


//@Listeners(com.hrm.genericUtils.ListenerImpClass.class)
public class LogOutUsingPomTest extends BaseClass
{

	
	


	//public static void main(String[] args) throws Throwable 
	@Test
	public void loginTest()
	{
	
//		FileUtility fLib = new FileUtility();
//		WebDriverUtilities wLib = new WebDriverUtilities();
		
		//To fetch data from property file
//		String BROWSER = fLib.getPropertyKeyValue("browser");
//		String URL = fLib.getPropertyKeyValue("url");
//		String USERNAME = fLib.getPropertyKeyValue("username");
//		String PASSWORD = fLib.getPropertyKeyValue("password");
		
//		WebDriver driver = null;
//		if(BROWSER.equalsIgnoreCase("chrome"))
//		{
//			WebDriverManager.chromedriver().setup();
//
//			driver = new ChromeDriver();
//		}
//		else if (BROWSER.equalsIgnoreCase("firefox"))
//		{
//			driver = new FirefoxDriver();
//		}
//		else
//		{
//			System.out.println("Invalid browser");
//		}
//	
//				
//		wLib.maximizeTheBrowser(driver);
//		
//		driver.get(URL);
//		wLib.implicitWait(driver, 10);
//				
//		LoginPage lp = new LoginPage(driver);
//		lp.login(USERNAME, PASSWORD,"→ HR Head");
		
//	validate
		String expected="Testyantra";
		String actual=driver.getTitle();
		System.out.println(actual);
		assertEquals(actual, expected);
		
		
//		To handle alter pop up 
		wLib.acceptAlertPopup(driver, "Login Successfully!!");
		
		//to logout from HR Head
		
		HomePage hm=new HomePage(driver);
//		Thread.sleep(2000);
		hm.logout();
	}

}

