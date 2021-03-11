package database;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class Database {
	
	public static EntityManager connection(String persistenceUnit) {
		
		return Persistence.createEntityManagerFactory(persistenceUnit).createEntityManager();
		
	}
	
}
