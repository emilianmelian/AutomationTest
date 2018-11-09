package com.interfaces;

import java.util.List;

public interface MongoInterface {

	public <T> List<T> read(T model, String testName);

	public <T> void write(T model, String testName);


}
