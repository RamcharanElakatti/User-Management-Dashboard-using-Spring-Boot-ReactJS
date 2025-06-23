package com.DummyUser.service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.DummyUser.model.User;
import com.DummyUser.repository.UserRepo;

@Service
public class UserService {
	@Autowired
	private UserRepo repo;
	
	@Autowired
	private RestTemplate resttemplate;
		

	public void fetchandSaveUsers() {
		String url="https://dummyjson.com/users";
		 Map<String, Object> response = resttemplate.getForObject(url, Map.class);
		 List<Map<String, Object>> users = (List<Map<String, Object>>) response.get("users");
		
		 for (Map<String, Object> u : users) {
	            User user = new User();
	            user.setId(((Number) u.get("id")).longValue());
	            user.setFirstName((String) u.get("firstName"));
	            user.setLastName((String) u.get("lastName"));
	            user.setMaidenName((String) u.get("maidenName"));
	            user.setEmail((String) u.get("email"));
	            user.setAge((Integer) u.get("age"));
	            user.setPhone((String) u.get("phone"));
	            user.setImage((String) u.get("image"));
	            user.setGender((String) u.get("gender"));
	            user.setUniversity((String) u.get("university"));
	            user.setRole((String) u.get("role"));
	            
	            Map<String, Object> address = (Map<String, Object>) u.get("address");
	            if (address != null) {
	                user.setCity((String) address.get("city"));
	                user.setState((String) address.get("state"));
	                user.setCountry((String) address.get("country"));
	            }

	            Map<String, Object> company = (Map<String, Object>) u.get("company");
	            if (company != null) {
	                user.setCompanyName((String) company.get("name"));
	                user.setDepartment((String) company.get("department"));
	                user.setTitle((String) company.get("title"));
	            }

	            repo.save(user);
		 }
		
		
	}


	public List<User> getAllUsers() {
		return repo.findAll();
	}


	public Optional<User> getUserById(Long id) {
	    return repo.findById(id);
	}


	public List<User> searchUsers(String keyword) {
		// TODO Auto-generated method stub
		return repo.findByFirstNameContainingIgnoreCaseOrEmailContainingIgnoreCase(keyword, keyword);
	}

	
	

}
