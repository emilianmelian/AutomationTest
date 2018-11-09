package com.connectors.mongo;

import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;
import com.mongodb.ServerAddress;
import com.tools.persistance.MongoConstants;

/**
 * MongoConnector Will handle all transactions with the Mongo DB environment.
 * 
 * @author vladvoicu
 */
public class MongoConnector {

	protected static MongoClient mongoClient;
	protected static DB workingDB;
	private List<ServerAddress> serverList = new ArrayList<ServerAddress>();

	public MongoConnector() throws UnknownHostException {
		serverList = grabServerList();
		if (mongoClient == null) {
			mongoClient = new MongoClient(serverList);
		}
	}

	public String getDbAddress() {
		return String.valueOf(mongoClient.getAddress());
	}

	private List<ServerAddress> grabServerList() throws UnknownHostException {
		List<ServerAddress> serverAddresses = new ArrayList<ServerAddress>();
		String[] hostList = MongoConstants.MONGO_URL.split(MongoConstants.COMMA_SEPARATOR);
		for (String hostNow : hostList) {
			serverAddresses.add(new ServerAddress(hostNow));
		}
		return serverAddresses;
	}

	public boolean verifyDatabaseExists(String dataBase) {
		List<String> dbs = mongoClient.getDatabaseNames();
		boolean b = false;
		for (String dbme : dbs) {
			if (dbme.contains(dataBase)) {
				b = true;
				break;
			}
		}
		return b;
	}

	public boolean verifyCollectionExists(String dataBase, String collection) {
		List<String> dbs = mongoClient.getDatabaseNames();
		boolean b = false;
		for (String dbme : dbs) {
			if (dbme.contains(dataBase)) {
				workingDB = mongoClient.getDB(dataBase);
				Set<String> colls = (workingDB.getCollectionNames());
				for (String colName : colls) {
					if (colName.contains(collection)) {
						b = true;
						break;
					}
				}
				break;
			}
		}
		return b;
	}

	public boolean verifyCollectionIsEmpty(String dataBase, String collection) {
		List<String> dbs = mongoClient.getDatabaseNames();
		boolean b = false;
		for (String dbme : dbs) {
			if (dbme.contains(dataBase)) {
				workingDB = mongoClient.getDB(dataBase);
				if (workingDB.getCollection(collection).count() == 0) {
					b = true;
					break;
				}
			}
		}
		return b;
	}
	
	
	public static void cleanCollection(String dataBase, String collection) {
		List<String> dbs = mongoClient.getDatabaseNames();
		for (String dbme : dbs) {
			if (dbme.contains(dataBase)) {
				workingDB = mongoClient.getDB(dataBase);
				
				DBCollection dbCollection = workingDB.getCollection(collection);
				dbCollection.drop();
			}
		}
	}

	public static void cleanCollection(String simpleName) {
		mongoClient.dropDatabase(simpleName);
	}

	public List<String> getDbNames() {
		List<String> dbNames = mongoClient.getDatabaseNames();
		for (String nameNow : dbNames) {
			System.out.println(nameNow);
		}

		return dbNames;
	}

	public void deleteDb(String dbName) {
		mongoClient.dropDatabase(dbName);
	}

	public void write(String name, String obiectul) {
		// TODO Auto-generated method stub
		
	}

}
