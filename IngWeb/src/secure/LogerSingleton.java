package secure;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map.Entry;
import java.util.Properties;

import entities.User;

public class LogerSingleton {
	
	private static LogerSingleton instance;
	private List<User> users;

	/**
	 * Constructor privado
	 */
	private LogerSingleton() {
		fillUsersList();
	}
	
	/**
	 * Devuelve la unica instancia creada
	 * @return
	 */
	public static LogerSingleton getInstance() {
		
		if(instance == null)
			instance = new LogerSingleton();
		
		return instance;
		
	}

	/**
	 * Carga la lista de usuarios	
	 * @return 
	 * @return
	 */
	private void fillUsersList() {

		users =  new ArrayList<User>();		
		Properties p = new Properties();
		
		try {
			p.load(new FileInputStream("/home/camilo/WorkSpaces/lunaWorkspace3/IngWeb/src/secure/usuarios.properties"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		Collection<Entry<Object, Object>> usersList = p.entrySet();		
		for (Entry<Object, Object> entry : usersList){
			
			
			
			String name = (String) entry.getKey();
			String pass = (String) entry.getValue();
			
			users.add( new User( name, pass ) );
			
			
		}
	}
	
	public List<User> getUsers() {
		return users;
	}

	
}
