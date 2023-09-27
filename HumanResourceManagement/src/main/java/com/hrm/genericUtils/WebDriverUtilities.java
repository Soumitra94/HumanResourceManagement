package com.hrm.genericUtils;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;

public class WebDriverUtilities
{
private By element;

//	private static final ExpectedConditions ExpectedCondition = null;
//	private String expectedurl;
//	private By element;
//	private Object duartion;

	public void maximizeTheBrowser(WebDriver driver)
	{
		//This method is used to maximize the browser
		driver.manage().window().maximize();
	}
	
	public void minimizeTheBrowser(WebDriver driver)
	{
		//This method is used to minimize the browser
		driver.manage().window().minimize();
	}
	
	public void implicitWait(WebDriver driver,int duration)
	{
		//This metod is used for implicitly wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(duration));
	}
	
	public void explicitWait(WebDriver driver,int duration,String expectedurl)
	{
		//This method is used for explicit wait
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(duration));
		wait.until(ExpectedConditions.urlContains(expectedurl));
		
	}
	public void waitUntilUrlLoads(WebDriver driver,int duration,String expectedurl)
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(duration));
		wait.until(ExpectedConditions.urlContains(expectedurl));
		
	}
	public void waitUntilTitleContains(WebDriver driver,int duration,String title)
	{
		WebDriverWait  wait=new WebDriverWait(driver,Duration.ofSeconds(duration));
		wait.until(ExpectedConditions.titleContains(title));
		
	}
	public void waitElementToBeVisible(WebDriver driver,int duration)
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(duration));
		By element = null;
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	public void  ignoreNoSuchElementException(WebDriver driver,int duration)
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(duration));
		wait.ignoring(NoSuchElementException.class);
		
	}
	
	public void customWait(WebElement element) throws Exception
	{
		int count=0;
		while(count<20)
		{
			try {
				element.click();
				break;
				
			} catch (Exception e) {
				Thread.sleep(1000);
				count++;
			}
		}
	}
		
		public void selectDropdown(WebElement element, int index)
		{
			Select s=new Select(element);
			s.selectByIndex(index);
			
			
			
		}
		public void selectDropdown(WebElement element,String value)
		{
			Select s=new Select(element);
			s.selectByValue(value);
			
		}
		public void selectDropdown(String text,WebElement element)
		{
		Select s=new Select(element);
		s.selectByVisibleText(text);
		}
		
		public void mouseOverOnElement(WebDriver driver,WebElement element)
		{
			Actions act=new Actions(driver);
			act.moveToElement(element).perform();
		}
		public void rightClick(WebDriver driver,WebElement element)
		{
			Actions act=new Actions(driver);
			act.contextClick(element).perform();
		}
		
		public void clickOnEnterKey(WebDriver driver,WebElement element)
		{
			Actions act=new Actions(driver);
			act.sendKeys(Keys.ENTER).perform();
		}
		public void switchFrame(WebDriver driver,int index)
		{
			driver.switchTo().frame(index);
		}
		public void switchFrame(WebDriver driver,String id)
		{
			driver.switchTo().frame(id);
		}
		public void switchFrame(WebDriver driver,WebElement element)
		{
			driver.switchTo().frame(element);
		}
		public void switchToMainFrame(WebDriver driver)
		{
			driver.switchTo().defaultContent();
		}
		public void acceptAlertPopup(WebDriver driver,String expectedMsg)
		{
			Alert alt=driver.switchTo().alert();
			if(alt.getText().equalsIgnoreCase(expectedMsg))
			{
				System.out.println("alert msg is verified");
			}
			else
			{
				System.out.println("alert msg is not verified");
			}
			alt.accept();
		}

		public void dismissAlertPopup(WebDriver driver,String expectedMsg)
		{
			Alert alt=driver.switchTo().alert();
			if(alt.getText().equalsIgnoreCase(expectedMsg))
			{
				System.out.println("alert message is verified");
			}
			else
			{
				System.out.println("alert message is not verified");
			}
			alt.dismiss();
		}
		public void switchWindowBasedOnTitle(WebDriver driver, String expectedTitle)
		{
			Set<String> s = driver.getWindowHandles();
			for(String str:s)
			{
				driver.switchTo().window(str);
				String title=driver.getTitle();
				if(title.contains(expectedTitle))
				{
					break;
				}
				
			}
		}
		
		public static String   takeScreenshot(WebDriver driver,String screenShotName)
		{
			TakesScreenshot tss=(TakesScreenshot) driver;
			File src=tss.getScreenshotAs(OutputType.FILE);
			File dst=new File("./screenShots"+screenShotName+".png");
			try {
				Files.copy(src, dst);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return screenShotName;
					
		}
		
		public void scrollToPrticularElement(WebDriver driver,WebElement element)
		{
			JavascriptExecutor jss=(JavascriptExecutor) driver;
			jss.executeScript("arguments[0].scrollIntoView()",element);
		}
		public void enterKey(WebDriver driver) throws Throwable
		{
			Robot rbt=new Robot();
			rbt.keyPress(KeyEvent.VK_ENTER);
		}
		public void enterRelease(WebDriver driver) throws Throwable
		{
			Robot rbt=new Robot();
			rbt.keyRelease(KeyEvent.VK_ENTER);
		}
		public void dragAndDrop(WebDriver driver,WebElement src,WebElement dst)
		{
			Actions act=new Actions(driver);
			act.dragAndDrop(src, dst);
		}
		public void doubleClickAction(WebDriver driver,WebElement element)
		{
			Actions act=new Actions(driver);
			act.doubleClick(element).perform();
		}
		public void scrollBarAction(WebDriver driver)
		{
			JavascriptExecutor jss=(JavascriptExecutor) driver;
			jss.executeScript("window.scrollBy(0,800)","");
		}
		
		
	}
	
	
	


