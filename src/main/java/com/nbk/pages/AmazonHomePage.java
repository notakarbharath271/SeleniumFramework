package com.nbk.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.nbk.driver.DriverManager;

public final class AmazonHomePage extends BasePage {

	@FindBy(id="nav-hamburger-menu") private WebElement linkHamburger;
	
	public AmazonHomePage() {
		PageFactory.initElements(DriverManager.getDriver(), this);
	}
	
	public AmazonHamburgerMenuPage clickOnHamburger() {
		linkHamburger.click();
		return new AmazonHamburgerMenuPage();
	}
}
