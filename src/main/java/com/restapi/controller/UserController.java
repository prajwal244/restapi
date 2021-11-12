package com.restapi.controller;

import java.util.List;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.restapi.dto.APIResponse;
import com.restapi.model.Users;
import com.restapi.service.UsersService;

@RestController
public class UserController {
	
	@Autowired
	private UsersService uService;
	
	
	@Value("${app.name}")
	private String appName;
	
	@Value("${app.version}")
	private String appVersion;
	
	@GetMapping("/version")
	public String getAppDetails() {
		
		return appName+" - "+appVersion;
	}

	@GetMapping("/Users")
	public ResponseEntity<List<Users>> getUsers() {
		
		return new ResponseEntity<List<Users>>(uService.getUsers(),HttpStatus.OK);
	}
	
	
	
@GetMapping("/Users/{id}")	
	public ResponseEntity<Users> findByUsername(@PathVariable("id")Long id){
		return new ResponseEntity<Users>(uService.fetchSingleUserRecord(id),HttpStatus.OK);
	}
	
	@PostMapping("/Users")
	public ResponseEntity<Users> saveUser( @Valid @RequestBody Users users) {
		
		return new ResponseEntity<Users>(uService.saveUser(users),HttpStatus.CREATED);
	}
	
	@PutMapping("/Users/{id}")
	public ResponseEntity<Users> updateuser(@PathVariable Long id,@RequestBody Users user) {
		user.setId(id);
		
	return	new ResponseEntity<Users>(uService.updateuserRecord(user),HttpStatus.OK);
	}
	
	@DeleteMapping("/Users")
	public  ResponseEntity<HttpStatus> deleteUser(@RequestParam   Long id) {
		
		return new ResponseEntity<HttpStatus>(HttpStatus.NO_CONTENT);
	}
@GetMapping("/Users/filterByFirstname")	
public ResponseEntity<List<Users>> getUserByName (@RequestParam String firstname){
	
	return new ResponseEntity<List<Users>>(uService.getUserbyName(firstname),HttpStatus.OK);
	
}

@GetMapping("/Users/filterByLastname")	
public ResponseEntity<List<Users>> getUserByLastName (@RequestParam String lastname){
	
	return new ResponseEntity<List<Users>>(uService.getUserbyLastName(lastname),HttpStatus.OK);
}

@GetMapping("/Users/filterByPincode")	
public ResponseEntity<List<Users>> getUserByPincode (@RequestParam Long pincode){
	
	return new ResponseEntity<List<Users>>(uService.getUserbyPincode(pincode),HttpStatus.OK);
}

@GetMapping("/{field}")
private  APIResponse<List<Users>> getUserWithSorting(@PathVariable String field){
	
	List<Users> allUser = uService.getUserWithSorting(field);
	return new APIResponse<>(allUser.size(),allUser);
}
	
@DeleteMapping("/Users/delete/{firstname}")	
public ResponseEntity<String> deleteByUserName(@PathVariable String firstname){
	return new ResponseEntity<String>(uService.deleteByUserName(firstname)+" no of record affected",HttpStatus.OK);
	
}

}