package com.DummyUser.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.DummyUser.model.User;
import com.DummyUser.service.UserService;

@RestController
@RequestMapping("api/users")
@CrossOrigin
public class Usercontroller {
	
	@Autowired
	private UserService service;
	
	@GetMapping("/fetch")
	public ResponseEntity<String> fetchUsers(){
		service.fetchandSaveUsers();
		return ResponseEntity.ok("Users data fetched");
		
	}
	
	@GetMapping("/")
    public List<User> getAllUsers() {
        return service.getAllUsers();
    }
	
	 @GetMapping("/{id}")
	    public ResponseEntity<User> getUserById(@PathVariable Long id) {
	        Optional<User> user = service.getUserById(id);
	        return user.map(ResponseEntity::ok)
	                   .orElseGet(() -> ResponseEntity.notFound().build());
	    }
	    
	    @GetMapping("/search")
	    public List<User> searchUsers(@RequestParam String keyword) {
	        return service.searchUsers(keyword);
	    }
	    
	    
	}


	


