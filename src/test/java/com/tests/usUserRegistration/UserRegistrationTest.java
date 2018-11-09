package com.tests.usUserRegistration;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.connectors.mongo.MongoConnector;
import com.connectors.store.Store;
import com.steps.frontend.UserRegistrationSteps;
import com.tests.BaseTest;
import com.tools.CustomVerification;
import com.tools.constants.AdapterConstants;
import com.tools.data.frontend.CustomerFormModel;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.WithTag;

@WithTag(name = "User Registration", type = "Scenarios")
@RunWith(SerenityRunner.class)
public class UserRegistrationTest extends BaseTest {

	@Steps
	public UserRegistrationSteps userRegistrationSteps;
	@Steps
	public CustomVerification customVerifications;

	private CustomerFormModel dataModel;
	Store store =new Store();
	

	@Before
	public void setUp() throws Exception {
		dataModel = new CustomerFormModel();
		MongoConnector.cleanCollection(getClass().getSimpleName());
	}

	@Test
	public void executeTest() {

		userRegistrationSteps.fillUserRegistrationForm(dataModel);
		userRegistrationSteps.verifyUserCreation(dataModel);
		customVerifications.printErrors();
	}
	

	@After
	public void afterExecute() {
		//MongoWriter.saveCustomerFormModel(dataModel, getClass().getSimpleName());
		
		store.write(AdapterConstants.MONGO, dataModel, getClass().getSimpleName());

	}
}