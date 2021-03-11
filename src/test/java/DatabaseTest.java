import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.sql.Connection;
import java.sql.SQLException;

import javax.persistence.EntityManager;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import database.Database;

public class DatabaseTest {

	@Test
	@DisplayName("Teste de conexão com o banco de dados")
	public void testConnection() {
		
		EntityManager em = Database.connection("BankLineDB");
		
		assertNotNull(em);
		
	}
	
	
}
