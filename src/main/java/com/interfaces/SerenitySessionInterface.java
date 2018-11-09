package com.interfaces;

import java.util.List;

public interface SerenitySessionInterface {
	
	public <T> List<T> read(T model, String testName);
	public <T> void write(T obiectul,String testName);

}
