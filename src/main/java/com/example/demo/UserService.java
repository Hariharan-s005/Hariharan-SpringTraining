package com.example.demo;

import org.springframework.stereotype.Service;

@Service
public class UserService {
	
	/**
	 *  Service class method to update User values
	 * @param user
	 * @param id
	 * @param userName
	 */
	public void updateUser(User user,int id,String userName)
	{
		user.setUserId(id);
		user.setUsername(userName);
	}
}
