package com.connectors.store;

import java.util.List;

import com.interfaces.SerenitySessionInterface;
import com.tools.utils.SerenitySessionUtils;

import net.serenitybdd.core.Serenity;

public class SerenitySessionStore implements SerenitySessionInterface {

	Store mongoStore;
	
	@Override
	public <T> List<T> read(T model, String testName) {
		
		return SerenitySessionUtils.getFromSession(model.getClass().getSimpleName());

	}


	@Override
	public <T> void write(T object, String testName) {
		
		Serenity.getCurrentSession().put(object.getClass().getSimpleName(),
				object);

		
	}





}
