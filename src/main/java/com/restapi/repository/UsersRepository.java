package com.restapi.repository;




import java.util.List;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.restapi.model.Users;

public interface UsersRepository extends JpaRepository<Users, Long> {

	List<Users> findByFirstname(String firstname);
	
	List<Users> findByLastname(String lastname);
	
	List<Users> findByPincode(Long pincode);
	
	@Transactional
	@Modifying
	@Query("DELETE FROM Users WHERE firstname=:firstname")
	Integer deleteUserByName(String firstname);
}
