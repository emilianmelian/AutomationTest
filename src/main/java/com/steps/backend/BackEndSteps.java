package com.steps.backend;

import com.pages.backend.MagentoLoginPage;
import com.pages.backend.NavigationPage;
import com.steps.AbstractSteps;
import com.tools.constants.SerenityKeyConstants;
import com.tools.constants.UrlConstants;
import com.tools.data.frontend.CustomerFormModel;
import com.tools.persistance.MongoReader;
import com.tools.utils.SerenitySessionUtils;

import net.thucydides.core.annotations.Step;

public class BackEndSteps extends AbstractSteps {

	private static final long serialVersionUID = 6989975368757184274L;

	@Step
	public void performAdminLogin(String userName, String userPass) {
		navigate(MongoReader.getBaseURL() + UrlConstants.BASE_URL_BE);
		
		getPage(MagentoLoginPage.class).inputUserName(userName);
		getPage(MagentoLoginPage.class).inputUserPassword(userPass);
		getPage(MagentoLoginPage.class).clickOnLogin();


		boolean isPresent = isdismissPopUpPresent();
	
		if (isPresent) {
			dismissPopUp();
		}
	}

	@Step
	public void openCustomersGrid() {
		getPage(NavigationPage.class).openMenu("customer");
		getPage(NavigationPage.class).openAllCustomers();

	}

	@Step
	public void openFilters() {
		navigationPage().clickOnFilters();
	}

	@Step
	public void searchForEmail() {
		
		CustomerFormModel model=SerenitySessionUtils.getFromSession(SerenityKeyConstants.CUSTOMER_MODEL);
		customerListPage().inputEmailFilter(model.getEmailName());
		customerListPage().clickOnSearch();

	}

	public void dismissPopUp() {
		navigationPage().dismissPopUp();
	}

	public boolean isdismissPopUpPresent() {
		return navigationPage().isDismissPopPresent();
	}

	public void clickOnEditCustomers() {
		customerListPage().clickOnEditCustomers();
	}
}
