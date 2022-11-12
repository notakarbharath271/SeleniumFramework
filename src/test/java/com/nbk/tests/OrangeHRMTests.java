package com.nbk.tests;

import java.util.Map;

import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

import com.nbk.listener.RetryFailTest;
import com.nbk.pages.OrangeHRMLoginPage;
import com.nbk.utilities.DataProviderUtility;

public class OrangeHRMTests extends BaseTest{
	
	private OrangeHRMTests() {}
	
	@Test
	public void loginlogoutTest(Map<String, String> data) {
	
		
	String title= new OrangeHRMLoginPage().enterUsername(data.get("UserName")).enterPassword(data.get("Password")).clickOnLogin()
				.clickOnDropdownIcon().clickOnLogout()
				.getTitle();
	
	Assertions.assertThat(title)
	.isEqualTo("OrangeHRM");
			
	}
	
	@Test
	public void newTest(Map<String, String> data) {
	
		
	String title= new OrangeHRMLoginPage().enterUsername(data.get("UserName")).enterPassword(data.get("Password")).clickOnLogin()
				.clickOnDropdownIcon().clickOnLogout()
				.getTitle();
	
	Assertions.assertThat(title)
	.isEqualTo("OrangeHRM");
			
	}
	

}
