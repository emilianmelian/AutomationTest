package com.tests.usUserRegistration;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.connectors.store.Store;
import com.steps.DataPreparationSteps;
import com.steps.backend.BackEndSteps;
import com.steps.backend.customer.CustomerDetailsBackendSteps;
import com.tests.BaseTest;
import com.tools.CustomVerification;
import com.tools.constants.AdapterConstants;
import com.tools.constants.Credentials;
import com.tools.data.frontend.CustomerFormModel;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.WithTag;

@WithTag(name = " Check Customer Registration on Admin Test ", type = "Scenarios")
@RunWith(SerenityRunner.class)
public class CheckUserRegistrationOnAdmin extends BaseTest {

	@Steps
	private BackEndSteps backEndSteps;
	@Steps
	private CustomVerification customVerifications;
	@Steps
	private CustomerDetailsBackendSteps customerDetailsSteps;
	@Steps
	private DataPreparationSteps dataPreparation;

	Store store = new Store();
	
	CustomerFormModel customer;
	List<CustomerFormModel> customerList=new ArrayList<CustomerFormModel>();

	@Before
	public void setUp() throws Exception {
		customer= new CustomerFormModel();
		
		customerList=store.read(AdapterConstants.MONGO, customer, "UserRegistrationTest");
		
		store.write(AdapterConstants.SERENITY, customerList.get(0),"UserRegistrationTest");
	
	}

	@Test
	public void checkUserRegistrationOnAdmin() {

		backEndSteps.performAdminLogin(Credentials.BE_USER, Credentials.BE_PASS);
		backEndSteps.openCustomersGrid();
		backEndSteps.openFilters();
		backEndSteps.searchForEmail();
		backEndSteps.clickOnEditCustomers();
		customerDetailsSteps.openCustomerSubMenu();
		customerDetailsSteps.validateCustomerDetails();
		customVerifications.printErrors();
	}



	

}
