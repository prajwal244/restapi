package com.restapi;



import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.restapi.model.Users;
import com.restapi.repository.UsersRepository;



@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
class SpringbootrestapiprojectApplicationTests {
    @Autowired
	UsersRepository uRepo;
	
	@Test
	@Order(1)
	public void TestCreate() {
		Users u = new Users();
		
		u.setId(10L);
		u.setFirstname("Sham");
		u.setLastname("lp");
		u.setDob("1997-11-25");
		u.setJoiningdate("2020-12-23");
		u.setEmail("sham@gmail.com");
		u.setPhnumber(7829544340L);
		u.setLocation("Noida");
		u.setPincode(258784);
		
		uRepo.save(u);
		Assertions.assertNotNull(uRepo.findById(10L).get());		
		
	}
	
	@Test
	@Order(2)
	public void testReadAll() {
		
		List<Users> list =uRepo.findAll();
		assertThat(list).size().isGreaterThan(0);
	}
	
	@Test
	@Order(3)
	public void testSingleRecord() {
		
		Users user =uRepo.findById(2L).get();
		Assertions.assertEquals("Smith",user.getFirstname());
	}
    
	@Test
	@Order(4)
	public void testUpdate() {
		
		Users user = uRepo.findById(4L).get();
		user.setFirstname("Prakash");
		uRepo.save(user);
		Assertions.assertNotEquals("dev", uRepo.findById(4L).get().getFirstname());
	}
	
	@Test
	@Order(5)
	public void testDelete() {
		
		uRepo.deleteById(1L);
		
		assertThat(uRepo.existsById(1L)).isFalse();
	}
}
