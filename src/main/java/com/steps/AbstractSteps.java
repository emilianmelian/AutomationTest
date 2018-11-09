package com.steps;

import java.util.concurrent.TimeUnit;

import com.pages.backend.MagentoLoginPage;
import com.pages.backend.NavigationPage;
import com.pages.backend.customer.CustomerListPage;
import com.pages.backend.customer.details.CustomerDetailsPage;
import com.pages.frontend.CreateUserPage;
import com.pages.frontend.HomePage;
import com.pages.frontend.profile.MyAccountPage;

import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

public class AbstractSteps extends ScenarioSteps {

	private static final long serialVersionUID = 1L;
/*
	public DictionaryPage getHeaderPage() {

		switch (System.getProperty("runPlatform")) {

		case "desktop":
			return getPages().currentPageAt(DictionaryPage.class);
		case "mobile":
			// mobile page object to be returned here
			return getPages().currentPageAt(MobileDictionaryPage.class);
		default:
			return null;
		}
	}*/
	
	
	
	@Step
	public void navigate(String URL) {
		if (!URL.contains("www.atmyhome.com")) {
			getDriver().manage().timeouts().pageLoadTimeout(3600, TimeUnit.SECONDS);
			getDriver().get(URL);
			getDriver().manage().window().maximize();
		}

	}
	
	
	public <T extends PageObject> T getPage(Class<T> className) {
		return (T) getPages().currentPageAt(className);
	}
	
	
	public MagentoLoginPage magentoLoginPage() {
		return getPages().currentPageAt(MagentoLoginPage.class);
	}
	
	public NavigationPage navigationPage() {
		return getPages().currentPageAt(NavigationPage.class);
	}
	
	public CustomerListPage customerListPage() {
		return getPages().currentPageAt(CustomerListPage.class);
	}
	
	public CustomerDetailsPage customerDetailsHomePage() {
		return getPages().currentPageAt(CustomerDetailsPage.class);
	}
	
	public CreateUserPage createUserPage() {
		return getPages().currentPageAt(CreateUserPage.class);
	}
	
	public MyAccountPage myAccountPage() {
		return getPages().currentPageAt(MyAccountPage.class);
	}
	
	public HomePage homePage() {
		return getPages().currentPageAt(HomePage.class);
	}
}
