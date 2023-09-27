package com_HRM.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hrm.genericUtils.WebDriverUtilities;

public class LoginPage extends WebDriverUtilities
{
	@FindBy(name="hr_email")
	private WebElement HrEmailEdit;
	
	@FindBy(name="hr_password")
	private WebElement passwordEdit;
	
	@FindBy(name = "hr_type")
	private WebElement HrTypeEdit;

	@FindBy(name = "login_hr")
	private WebElement LoginHr;

	
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}


	public WebElement getHrEmailEdit() {
		return HrEmailEdit;
	}


	public WebElement getPasswordEdit() {
		return passwordEdit;
	}


	public WebElement getHrTypeEdit() {
		return HrTypeEdit;
	}


	public WebElement getLoginHr() {
		return LoginHr;
	}
	
	//Business Libraries
	public void login(String UN,String PWD,String txt)
	{
		HrEmailEdit.sendKeys(UN);
		passwordEdit.sendKeys(PWD);
		selectDropdown(txt, HrTypeEdit);
		LoginHr.click();
		
	}
	
	}	


