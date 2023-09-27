package com_HRM.ObjectRepository;

import java.util.HashMap;
import java.util.Map.Entry;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hrm.genericUtils.ExcelUtility;

public class AddEmployeeNewWindowPage extends ExcelUtility
{
	@FindBy(name="employee_companyid")
	private WebElement EmpCmpId;

	@FindBy(name = "employee_firstname")
	private WebElement FirstName;

	@FindBy(name = "employee_lastname")
	private WebElement LastName;
	
	@FindBy(name ="employee_middlename")
	private WebElement MiddleNme;
	
	@FindBy(name = "branches_datefrom")
	private WebElement BranchDate;
	
	@FindBy(name = "branches_recentdate")
	private WebElement BRecentDate;
	
	@FindBy(name = "employee_position")
	private WebElement Possition;
	
	@FindBy(name ="employee_department")
	private WebElement Department;
	
	@FindBy(name="employee_branches")
	private WebElement EmpBranch;
	
	@FindBy(name ="employee_contact" )
	private WebElement EmpContactNo;
	
	@FindBy(name = "employee_sss")
	private WebElement EmpSSS;
	
	@FindBy(name = "employee_tin")
	private WebElement EmpTin;
	
	@FindBy(name = "employee_hdmf_pagibig")
	private WebElement EMpHDMF;
	
	@FindBy(name = "employee_gsis")
	private WebElement EmpGSIS;
	
	@FindBy(xpath="//button[.='Save']")
	private WebElement SaveButton;
	
	@FindBy(xpath="//li[@class='nav-item dropdown']")
	private WebElement PowerOffDropDown;
	
	@FindBy(xpath="//i[@class='fa fa-power-off']")
	private WebElement PowerOffButton;

	
	
	public AddEmployeeNewWindowPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}



	public WebElement getEmpCmpId() {
		return EmpCmpId;
	}



	public WebElement getFirstName() {
		return FirstName;
	}



	public WebElement getLastName() {
		return LastName;
	}



	public WebElement getMiddleNme() {
		return MiddleNme;
	}



	public WebElement getBranchDate() {
		return BranchDate;
	}



	public WebElement getBRecentDate() {
		return BRecentDate;
	}



	public WebElement getPossition() {
		return Possition;
	}



	public WebElement getDepartment() {
		return Department;
	}



	public WebElement getEmpBranch() {
		return EmpBranch;
	}



	public WebElement getEmpContactNo() {
		return EmpContactNo;
	}



	public WebElement getEmpSSS() {
		return EmpSSS;
	}



	public WebElement getEmpTin() {
		return EmpTin;
	}



	public WebElement getEMpHDMF() {
		return EMpHDMF;
	}



	public WebElement getEmpGSIS() {
		return EmpGSIS;
	}



	public WebElement getSaveButton() {
		return SaveButton;
	}



	public WebElement getPowerOffDropDown() {
		return PowerOffDropDown;
	}



	public WebElement getPowerOffButton() {
		return PowerOffButton;
	}
	
	
	//Business Libraries
	public void employee (String CompId,String Fstname,String Lstname,String MidName,String BDateFrm,String BrecentDate,String Position,String ContactNo)
	{
		EmpCmpId.sendKeys(CompId);
		FirstName.sendKeys(Fstname);
		LastName.sendKeys(Lstname);
		MiddleNme.sendKeys(MidName);
		BranchDate.sendKeys(BDateFrm);
		BRecentDate.sendKeys(BrecentDate);
		Possition.sendKeys(Position);
		EmpContactNo.sendKeys(ContactNo);
		SaveButton.click();	
	}

	public void addEmployee(HashMap<String, String> map,WebDriver driver)
	{
		for(Entry<String, String> s:map.entrySet())
		{
				
				driver.findElement(By.name(s.getKey())).sendKeys(s.getValue());
			
		}
		
		SaveButton.click();
	}
}
