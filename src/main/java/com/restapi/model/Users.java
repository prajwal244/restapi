package com.restapi.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@Entity
public class Users {
     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
     
    
    
    @NotBlank(message="firstname should not be null")
	private String firstname;
	
    @NotBlank(message ="lastname should not be null")
	private String lastname;
	
	
	private String dob;
	
	
	private String joiningdate;
	
	@Email(message="email should be valid")
	private String email;
	
	
	private Long phnumber;
	
	private String location;
	
	private long pincode;
}
