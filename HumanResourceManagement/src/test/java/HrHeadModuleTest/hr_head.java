package HrHeadModuleTest;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class hr_head 
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
		driver.findElement(By.xpath("//i[@class='nav-icon fa fa-handshake']")).click();
		driver.findElement(By.xpath("//p[.='Add Corporate']")).click();
	    driver.findElement(By.xpath("//h3[@class='card-title']")).click();
	    driver.findElement(By.xpath("//input[@placeholder='Corporate Name']")).sendKeys("SDET-51");
	    driver.findElement(By.xpath("//button[.='Save']")).click();
//	    driver.findElement(By.xpath("//i[@class='fa fa-user']")).click();
	    Alert b=driver.switchTo().alert();
	    b.accept();
	    driver.findElement(By.xpath("//i[@class='fa fa-user']")).click();
	    driver.findElement(By.xpath("//i[@class='fa fa-power-off']")).click();
	    Alert c=driver.switchTo().alert();
	    c.accept();
	    
        
		
		
		
		
	}

}
