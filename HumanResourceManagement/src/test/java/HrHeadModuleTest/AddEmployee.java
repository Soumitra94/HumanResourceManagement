package HrHeadModuleTest;

import java.awt.Window;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import com.hrm.genericUtils.WebDriverUtilities;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AddEmployee extends WebDriverUtilities
{
	public static void main(String[] args) throws Exception 
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://rmgtestingserver/domain/HRM_System/");
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		WebElement email = driver.findElement(By.xpath("//input[@placeholder='HR Email']"));
		email.sendKeys("hrhead@gmail.com");
		WebElement password = driver.findElement(By.xpath("//input[@placeholder='HR Password']"));
		password.sendKeys("hrhead@123");
		WebElement dd = driver.findElement(By.xpath("//select[@name='hr_type']"));
		Select s1=new Select(dd);
		s1.selectByVisibleText("→ HR Head");
		WebElement button = driver.findElement(By.xpath("//button[@type='submit']"));
		button.click();
		
		Alert a = driver.switchTo().alert();
		a.accept();
        driver.findElement(By.xpath("//i[@class='nav-icon fas fa-user']")).click();
        driver.findElement(By.xpath("//p[text()='Add Employee']")).click();
        driver.findElement(By.xpath("//p[.='Add Employee']")).click();
        
        
        }

	}


