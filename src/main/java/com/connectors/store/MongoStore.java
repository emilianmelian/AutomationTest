package com.connectors.store;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

import com.connectors.mongo.MongoConnector;
import com.interfaces.MongoInterface;
import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.tools.utils.StringHelpers;

public class MongoStore extends MongoConnector implements MongoInterface {

	public MongoStore() throws UnknownHostException {
		super();
	}

	
	@Override
	public <T> List<T> read(T model, String testName) {

		DBObject dbObject = null;
		List<T> itemList = new ArrayList<T>();

		workingDB = mongoClient.getDB(testName);
		DBCursor cursor = workingDB.getCollection(model.getClass().getSimpleName()).find();

		try {
			while (cursor.hasNext()) {

				dbObject = cursor.next();
				for (java.lang.reflect.Field field : model.getClass().getDeclaredFields()) {
					if (dbObject.containsField(field.getName())) {
						Class<? extends Object> tClass = model.getClass();

						try {

							Method m_set = tClass.getMethod(
									"set" + StringHelpers.capitalizedFirstLetter(field.getName()),
									new Class[] { String.class });
							m_set.invoke(model, new Object[] { dbObject.get(field.getName()).toString() });

						} catch (NoSuchMethodException | SecurityException e) {
							e.printStackTrace();
						} catch (IllegalAccessException e) {
							e.printStackTrace();
						} catch (IllegalArgumentException e) {
							e.printStackTrace();
						} catch (InvocationTargetException e) {
							e.printStackTrace();
						}
					}
				}

				itemList.add(model);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			cursor.close();
		}
		return (List<T>) itemList;
	}

	

	@Override
	public <T> void write(T model, String testName) {
		workingDB = mongoClient.getDB(testName);
		DBCollection table = workingDB.getCollection(model.getClass().getSimpleName());
		BasicDBObject document = new BasicDBObject();

		for (java.lang.reflect.Field field : model.getClass().getDeclaredFields()) {
			String value = "";

			try {
				Method m_set = model.getClass()
						.getMethod("get" + StringHelpers.capitalizedFirstLetter(field.getName()));
				if (m_set.invoke(model) != null) {
					value = m_set.invoke(model).toString();
				}
				document.put(field.getName(), value);

			} catch (NoSuchMethodException | SecurityException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				e.printStackTrace();
			}

		}
		table.insert(document);
		
	}

	



}
