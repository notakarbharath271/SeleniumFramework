package com.nbk.pages;

import org.openqa.selenium.By;

import com.nbk.enums.WaitStrategy;

public class OrangeHRMHomePage extends BasePage {
	
	
	private final By dropdownIocn = By.xpath("//*[@class='oxd-icon bi-caret-down-fill oxd-userdropdown-icon']");
	private final By logoutbtn = By.xpath("//a[text()='Logout']");
	
	public  OrangeHRMHomePage clickOnDropdownIcon() {
		clickOnElement(dropdownIocn, WaitStrategy.CLICKABLE,"dropdown icon");
		return this;
	}
	
	public OrangeHRMLoginPage clickOnLogout() {
		
		clickOnElement(logoutbtn, WaitStrategy.CLICKABLE,"Logout btn");
		return new OrangeHRMLoginPage();
	}

}
