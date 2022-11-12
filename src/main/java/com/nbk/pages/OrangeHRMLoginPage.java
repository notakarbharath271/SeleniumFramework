package com.nbk.pages;

import org.openqa.selenium.By;

import com.nbk.enums.WaitStrategy;

public final class OrangeHRMLoginPage extends BasePage{
	
	private final By textUsername = By.name("username");
	private final By textPassword = By.name("password");
	private final By btnLoginbtn = By.xpath("//*[text()=' Login ']");
	
	public OrangeHRMLoginPage enterUsername(String userName) {
		sendKeysInTOTextField(textUsername, userName, WaitStrategy.PRESENCES,"Username");
		return this;
	}
	
	public OrangeHRMLoginPage enterPassword(String pswd) {
		sendKeysInTOTextField(textPassword, pswd, WaitStrategy.PRESENCES,"Password");
		return this;
	}
	
	public OrangeHRMHomePage clickOnLogin() {
	
		clickOnElement(btnLoginbtn, WaitStrategy.CLICKABLE,"Login btn");
		return new OrangeHRMHomePage();
		
	}
	
	public String getTitle() {
		return getPageTitle();
	}

}
