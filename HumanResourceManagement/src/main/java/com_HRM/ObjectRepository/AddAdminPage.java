package com_HRM.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddAdminPage 
{
	@FindBy(xpath="//p[.='Add Admin']")
	private WebElement AddAdminRbtn;
	
	@FindBy(xpath="//h3[@class='card-title']")
	private WebElement AddAdminBtn;
	
	@FindBy(name="hr_companyid")
	private WebElement CompantIdTf;
	
	@FindBy(name="hr_firstname")
	private WebElement FirstNameTf;
	
	@FindBy(name="hr_lastname")
	private WebElement LastNameTf;
	
	@FindBy(name="hr_middlename")
	private WebElement MiddleNameTf;
	
	@FindBy(name="hr_contactno")
	private WebElement ContactNoTf;
	
	@FindBy(name="hr_email")
	private WebElement EmailAddTf;
	
	@FindBy(name="hr_password")
	private WebElement PasswordTf;
	
	@FindBy(xpath="//button[.='Save']")
	private WebElement SaveBtn;
	
	@FindBy(xpath="//button[text()='Close']")
	private WebElement CloseBtn;
	
	
	public AddAdminPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}


	public WebElement getAddAdminRbtn() {
		return AddAdminRbtn;
	}


	public WebElement getAddAdminBtn() {
		return AddAdminBtn;
	}


	public WebElement getCompantIdTf() {
		return CompantIdTf;
	}


	public WebElement getFirstNameTf() {
		return FirstNameTf;
	}


	public WebElement getLastNameTf() {
		return LastNameTf;
	}


	public WebElement getMiddleNameTf() {
		return MiddleNameTf;
	}


	public WebElement getContactNoTf() {
		return ContactNoTf;
	}


	public WebElement getEmailAddTf() {
		return EmailAddTf;
	}


	public WebElement getPasswordTf() {
		return PasswordTf;
	}


	public WebElement getSaveBtn() {
		return SaveBtn;
	}


	public WebElement getCloseBtn() {
		return CloseBtn;
	}
	
	
	//Business Libraries
	public void admin(String companyID,String firstname,String lastname,String middlename,int contactno,String email,String password)
	{
		AddAdminRbtn.click();
		AddAdminBtn.click();
		CompantIdTf.sendKeys(null);
		FirstNameTf.sendKeys(null);
		LastNameTf.sendKeys(null);
		MiddleNameTf.sendKeys(null);
		ContactNoTf.sendKeys(null);
		EmailAddTf.sendKeys(null);
		PasswordTf.sendKeys(null);
		SaveBtn.click();
		CloseBtn.click();
	}

}
