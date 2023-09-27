package com_HRM.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddBranchesPage 
{
	//declaration
	@FindBy(xpath="//p[.='Add Braches']")
	private WebElement AddBracheslRbtn;
	
	
	@FindBy(xpath="//h3[@class='card-title']")
	private WebElement AddBranchesBtn;
	
	
	@FindBy(xpath="//input[@placeholder='Branches Name']")
	private WebElement BranchesNamePholde;
	
	@FindBy(xpath="//button[.='Save']")
	private WebElement SaveBtn;
	
	@FindBy(xpath="//button[text()='Close']")
	private WebElement CloseBtn;
	
	
	//initialization
	public AddBranchesPage(WebDriver driver)
	{
	PageFactory.initElements(driver, this);
	}

	//utilization
	public WebElement getAddBracheslRbtn() {
		return AddBracheslRbtn;
	}

	public WebElement getAddBranchesBtn() {
		return AddBranchesBtn;
	}

	public WebElement getBranchesNamePholde() {
		return BranchesNamePholde;
	}

	public WebElement getSaveBtn() {
		return SaveBtn;
	}

	public WebElement getCloseBtn() {
		return CloseBtn;
	}
	
	
	//Business Libraries
	public void addbranch(String BranchesName)
	{
		AddBracheslRbtn.click();
		AddBranchesBtn.click();
		BranchesNamePholde.sendKeys(null);
		SaveBtn.click();
	}

}
