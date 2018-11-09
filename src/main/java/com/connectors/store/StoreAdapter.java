package com.connectors.store;

import java.util.List;

import com.tools.constants.AdapterConstants;
public class StoreAdapter {

	SerenitySessionStore serenitySessionStore;
	MongoStore mongoStore;

	public StoreAdapter(String storeType)  {
		if (storeType.equalsIgnoreCase(AdapterConstants.MONGO)) {
			try {
				mongoStore = new MongoStore();
			}
			catch (java.net.UnknownHostException e) {
			      System.out.println("Unknown Host Ex");
			}
			catch (Exception e) {
			      System.out.println("OTHER ERROR");
			}
		}
		if (storeType.equalsIgnoreCase(AdapterConstants.SERENITY)) {
			serenitySessionStore = new SerenitySessionStore();
		}
	}

	public <T>  List<T> read(String storeType, T model, String textName) {
		
		List<T> grabbedList = null;
		
		if (storeType.equalsIgnoreCase(AdapterConstants.SERENITY)) {
			grabbedList= mongoStore.read(model, textName);

		}
		if (storeType.equalsIgnoreCase(AdapterConstants.SERENITY)) {
			grabbedList=serenitySessionStore.read(model, textName);
		}
		return grabbedList;
	}

	public <T> void write(String storeType, T model, String testName) {
		if (storeType.equalsIgnoreCase(AdapterConstants.MONGO)) {
			mongoStore.write(model,testName);
		}
		if (storeType.equalsIgnoreCase(AdapterConstants.SERENITY)) {
			serenitySessionStore.write( model,testName);
		}
	}

}
