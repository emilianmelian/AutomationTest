package com.steps;

import com.connectors.store.Store;
import com.tools.constants.SerenityKeyConstants;
import com.tools.persistance.MongoReader;
import com.tools.utils.SerenitySessionUtils;

import net.thucydides.core.annotations.Step;

public class DataPreparationSteps extends AbstractSteps {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6989975368757184274L;

	@Step
	public void grabCustomerInformationFromMongo(Store store,String testName) {
		
		
		SerenitySessionUtils.putOnSession(SerenityKeyConstants.CUSTOMER_MODEL,
				MongoReader.grabCustomerFormModels(testName).get(0));
	}

}
