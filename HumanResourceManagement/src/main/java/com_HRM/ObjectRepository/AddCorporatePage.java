package com_HRM.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddCorporatePage
{
	//declaration
	@FindBy(xpath="//p[.='Add Corporate']")
	private WebElement AddCorporateRbtn;


    @FindBy(xpath="//h3[@class='card-title']")
    private WebElement AddCorporateBtn;
    
    
    @FindBy(name="corporate_name")
    private WebElement AddCorporateNewWindow;
    
    @FindBy(xpath="//button[.='Save']")
    private WebElement saveBtn;
    
    //initialization
    public AddCorporatePage(WebDriver driver)
    {
    	PageFactory.initElements(driver, this);
    	
    }

    //utilization
	public WebElement getAddCorporateRbtn() {
		return AddCorporateRbtn;
	}

	public WebElement getAddCorporateBtn() {
		return AddCorporateBtn;
	}

	public WebElement getAddCorporateNewWindow() {
		return AddCorporateNewWindow;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}
    
    
    //Business Libraries
	public void corporate()
	{
		AddCorporateRbtn.click();
		AddCorporateBtn.click();
		
	}
	public void newCorporate(String sendkeys )
	{
	AddCorporateNewWindow.sendKeys("Automation");
	saveBtn.click();
	}
}
