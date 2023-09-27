package com_HRM.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage 
{
	//corporateDD
	@FindBy(xpath="//p[contains(.,'CORPORATE')]")
	private WebElement CorporateBtn;
	//Add Corporate Radio Button
	@FindBy(xpath="//p[.='Add Corporate']")
	private WebElement AddCorporateRbtn;
	//Add Corporate button
	@FindBy(xpath="//button[contains(.,'Add Corporate')]")
	private WebElement AddCorporateBtn;
	
	
	@FindBy(xpath="//i[@class='nav-icon fas fa-user']")
	private WebElement EmployeeBtn;
	
	@FindBy(xpath="//p[.='Add Employee']")
	private WebElement AddEmployeeRbtn;
	
	@FindBy(xpath="//button[contains(.,'Add Employee')]")
	private WebElement AddEmployeeBtn;
	
	@FindBy(xpath="//i[@class='fa fa-user']")
	private WebElement UserLookUpImage;
	
	@FindBy(xpath="//i[@class='fa fa-power-off']")
	private WebElement LogOut;
	
	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public WebElement getEmployeeBtn() {
		return EmployeeBtn;
	}



	public WebElement getAddEmployeeRbtn() {
		return AddEmployeeRbtn;
	}



	public WebElement getAddEmployeeBtn() {
		return AddEmployeeBtn;
	}



	public WebElement getUserLookUpImage() {
		return UserLookUpImage;
	}



	public WebElement getLogOut() {
		return LogOut;
	}



	public WebElement getCorporateBtn() {
		return CorporateBtn;
	}

	public WebElement getAddCorporateRbtn() {
		return AddCorporateRbtn;
	}

	public WebElement getAddCorporateBtn() {
		return AddCorporateBtn;
	}

	//Business Libraries
	public void home()
	{
		EmployeeBtn.click();
		AddEmployeeRbtn.click();
		AddEmployeeBtn.click();	
	}
	public void corporate()
	{
		CorporateBtn.click();
		AddCorporateRbtn.click();
		AddCorporateBtn.click();
	}
	
	public void logout()
	{
		UserLookUpImage.click();
		LogOut.click();
	}
	
	

}
