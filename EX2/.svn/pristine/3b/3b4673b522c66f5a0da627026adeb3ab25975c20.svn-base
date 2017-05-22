package jdbc;

import java.sql.Connection;
import java.util.Properties;

import com.fdmgroup.properties.PropertiesLoader;

import dao.IStorage;
import exceptions.NoUserException;

public abstract class SuperDAO {

	// For loading properties from file
		Properties properties;
		String url, username, password;
		
		// For connecting to the database
		Connection conn;
		
		public SuperDAO(){
			
		
			properties = PropertiesLoader.getProperties("real.properties");
			
			if (properties != null) {
				
				url = properties.getProperty("url");
				username = properties.getProperty("username");
				password = properties.getProperty("password");
			}
		}
		
		public String getQuery(String queryName)
		{
			Properties qproperties = PropertiesLoader.getProperties("query.properties");
			String query = "";
			
			if (qproperties != null)			
				query = qproperties.getProperty(queryName);			
			
			return query;
		}
		
		
		
			public void delete(Integer id) throws NoUserException {
				// TODO Auto-generated method stub
				
			}
			


}
