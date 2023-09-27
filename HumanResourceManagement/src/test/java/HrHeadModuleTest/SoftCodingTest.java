package HrHeadModuleTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SoftCodingTest 
{
	public static void main(String[] args) throws Exception
	{
		WebDriver driver=null;
		
		Random ran=new Random();
		int random=ran.nextInt(500);
		
		//fetch common data using property file
		FileInputStream fis=new FileInputStream("");
		Properties p=new Properties();
		p.load(fis);
		String BROWSER=p.getProperty("browser");
		String URL=p.getProperty("url");
		String USERNAME=p.getProperty("username");
		String PASSWORD=p.getProperty("password");
		
		//read the data from Excel Sheet
		FileInputStream fi=new FileInputStream("");
		Workbook wb = WorkbookFactory.create(fi);
		Sheet sh=wb.getSheet("Organization");
		int count=sh.getLastRowNum();
		
		//launch the browser
		if(BROWSER.equalsIgnoreCase("chrome"))
		{
			driver=new ChromeDriver();
		}
		else if(BROWSER.equalsIgnoreCase("firefox"))
		{
			driver=new FirefoxDriver();
			
		}
		else
		{
			System.out.println("Invalid Browser");
		}
		driver.manage().window().maximize();
		
		//enter the url
		driver.get(URL);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//enter the valid UN & PWD
		driver.findElement(By.name("username")).sendKeys(USERNAME);
		driver.findElement(By.xpath("password")).sendKeys(PASSWORD);
		driver.findElement(By.xpath("Submit button")).click();
		
		
		
		
		
		
	}

}
