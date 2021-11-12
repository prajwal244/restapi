package com.restapi.service;

import java.util.List;



import com.restapi.model.Users;

public interface UsersService {

    List<Users> getUsers();
	Users saveUser(Users user);
	
	Users fetchSingleUserRecord(Long id);
	
	void deleteUser(Long id);
	
	Users updateuserRecord(Users user);
	
	List<Users> getUserbyName(String firstname);
	
	List<Users> getUserbyLastName(String lastname);
	
	List<Users> getUserbyPincode(Long pincode);
	
	List<Users> getUserWithSorting(String field);
	
	Integer deleteByUserName(String firstname);
}
