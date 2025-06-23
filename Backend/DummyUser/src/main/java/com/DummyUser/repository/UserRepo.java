package com.DummyUser.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.DummyUser.model.User;


@Repository
public interface UserRepo  extends JpaRepository<User, Long>{

	List<User> findByFirstNameContainingIgnoreCaseOrEmailContainingIgnoreCase(String name, String email);


}
