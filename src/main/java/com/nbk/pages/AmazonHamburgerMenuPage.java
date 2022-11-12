package com.nbk.pages;

import org.openqa.selenium.By;

import com.nbk.enums.WaitStrategy;
import com.nbk.utilities.DyanmicXpath;

public final class AmazonHamburgerMenuPage extends BasePage {
	/*
	@FindBy(xpath = "//div[text()='Mobiles, Computers']/parent::a") private WebElement linkMobileAndComputer;	
	@FindBy(xpath = "//a[text()='Laptops']") private WebElement linkLaptops;
	@FindBy(xpath = "//a[text()='Drives & Storage']") private WebElement linkDriverAndStroage;
	@FindBy(xpath = "//a[text()='Printers & Ink']") private WebElement linkPrinterAndInk;
	
	public AmazonHamburgerMenuPage() {
		PageFactory.initElements(DriverManager.getDriver(),	this);
	}
	
	public AmazonHamburgerMenuPage clicklinkMobileAndComputer() {
		linkMobileAndComputer.click();
		return this;
	}
	public AmazonHamburgerMenuPage clicklinkLaptops() {
		linkLaptops.click();
		return new AmazonLaptopPage();
	}
	public AmazonHamburgerMenuPage clicklinkDriverAndStroage() {
		linkDriverAndStroage.click();
		return this;
	}
	public AmazonHamburgerMenuPage clicklinkPrinterAndInk() {
		linkPrinterAndInk.click();
		return new AmazonPrinterAndInkPage();
	}
	*/
	private String linkMobileAndComputer ="//div[text()='Mobiles, Computers']/parent::a"; 
	private String linksubmenu = "//a[text()='%s']";
	public AmazonHamburgerMenuPage clickMobileAndComputer() {
		clickOnElement(By.xpath(linkMobileAndComputer), WaitStrategy.CLICKABLE, "Mobiles, Computers");
		return this;
	}
	public AmazonLaptopPage clickOnSubMenuItem(String menutext) {
		String nexXpath = DyanmicXpath.getXpath(linksubmenu, menutext);
		clickOnElement(By.xpath(nexXpath), WaitStrategy.CLICKABLE, menutext);
		if(menutext.contains("Laptops")) {
			return new AmazonLaptopPage();
		}
		return null;
	}
	

}
