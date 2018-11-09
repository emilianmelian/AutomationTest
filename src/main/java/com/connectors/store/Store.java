package com.connectors.store;

import java.util.List;

public class Store {

	StoreAdapter storeAdapter;

	public <T> List<T> read(String storeType, T model,String testName) {

		storeAdapter = new StoreAdapter(storeType);
		return (List<T>) storeAdapter.read(storeType, model,testName);

	}

	public <T> void write(String storeType, T model,String testName) {

		storeAdapter = new StoreAdapter(storeType);
		 storeAdapter.write(storeType, model,testName);

	}
	
}
