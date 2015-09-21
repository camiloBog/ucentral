package secure;

import java.util.List;

import entities.User;

public class Loger {


	public boolean validate(String name, String pass) {
		
		List<User> users = LogerSingleton.getInstance().getUsers();
		for (User user : users)
			if( user.getNombre().equals(name) && 
				user.getPassword().equals(pass) )
				return true;
		
		return false;
	}

}
