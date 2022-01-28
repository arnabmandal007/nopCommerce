package com.nopCommerce.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	public WebDriver ldriver;
	
	public LoginPage(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	//.............Element identify.............
	//Email field
	@FindBy(xpath="//*[@id=\"Email\"]")
	WebElement txtemail;
	
	//Password field
	@FindBy(xpath="//*[@id=\"Password\"]")
	WebElement txtpassword;
	
	//Login button
	@FindBy(xpath="/html/body/div[6]/div/div/div/div/div[2]/div[1]/div/form/div[3]/button")
	WebElement btnlogin;
	
	//Logout button
	@FindBy(xpath="//*[@id=\"navbarText\"]/ul/li[3]/a")
	WebElement btnlogout;
	
	//.....................................................
	
	//..................Actions..............................
	//Email
	public void setusername(String uname)
	{
		txtemail.sendKeys(uname);
	}
	
	//password
	public void setpassword(String pwd)
	{
		txtpassword.sendKeys(pwd);
	}
	
	//Login button
	public void clicklogin()
	{
		btnlogin.click();
	}
	
	//logout button
	public void clicklogout()
	{
		btnlogout.click();
	}
	
	
	
	
	
}
