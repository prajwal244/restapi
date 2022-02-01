package com.restapi.service;





import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.restapi.model.Users;
import com.restapi.repository.UsersRepository;

@Service
@Profile(value= {"local","dev","prod"})
public  class UsersServiceImpl implements UsersService {
     
	@Autowired
	private UsersRepository repo;
	
	
	

	@Override
	public Users saveUser(Users users) {
		
	return	repo.save(users);
	}

	@Override
	public Users fetchSingleUserRecord(Long id) {
	
	Optional<Users> users= repo.findById(id);	
	if(users.isPresent()) {
		return users.get();
	}
	throw new RuntimeException("User not found for id "+id);
	}

	@Override
	public void deleteUser(Long id) {
		repo.deleteById(id);
		
	}

	@Override
	public Users updateuserRecord(Users user) {
		
		 return repo.save(user);
	}

	@Override
	public List<Users> getUserbyName(String firstname) {
		
	return repo.findByFirstname(firstname);
	}

	@Override
	public List<Users> getUserbyLastName(String lastname) {
		return repo.findByLastname(lastname);
	}

	@Override
	public List<Users> getUserbyPincode(Long pincode) {
		return repo.findByPincode(pincode);
	}

	@Override
	public List<Users> getUsers() {
		return repo.findAll();
	}
	
@Override
	public List<Users> getUserWithSorting(String field){
       return repo.findAll(Sort.by(Sort.Direction.ASC,field));
}

@Override
public Integer deleteByUserName(String firstname) {
	
	return repo.deleteUserByName(firstname);
}

}
