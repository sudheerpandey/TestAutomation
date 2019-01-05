package com.qa.guru.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.guru.Base.TestBase;

public class HomePage extends TestBase {
	
	@FindBy(xpath="//a[text()='Mobile']")
	WebElement Mobile;
	
	@FindBy (xpath="(//select[@title='Sort By'])[1]")
	WebElement SortBy;
	
	public HomePage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public String validateHomePageTitle()
	{
		return driver.getTitle();
	}
	public void clickOnMobileLink()
	{
		Mobile.click();
	}

	public String validateTheTitleOfMoible()
	{
		return driver.getTitle();
	}
}
