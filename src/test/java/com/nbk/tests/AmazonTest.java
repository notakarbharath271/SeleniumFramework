package com.nbk.tests;

import java.util.Map;

import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

import com.nbk.annotations.FrameworkAnnotation;
import com.nbk.enums.CatagoryType;
import com.nbk.pages.AmazonHomePage;

public final class AmazonTest extends BaseTest {
	private AmazonTest() {
	}
	@FrameworkAnnotation(author = { "Bharath","Satheesh" }, catagory = { CatagoryType.REGRESSION,CatagoryType.MINIREGRESSION,CatagoryType.SANATY,CatagoryType.SMOKE }, device = { "Chrome" })
	@Test
	public void amazonTest(Map<String, String> data) {
	
		String title = new AmazonHomePage().clickOnHamburger().clickMobileAndComputer()
				.clickOnSubMenuItem(data.get("menutext")).gettitle();
		System.out.println(title);
		Assertions.assertThat(title).isNotBlank();
		
	}

}
