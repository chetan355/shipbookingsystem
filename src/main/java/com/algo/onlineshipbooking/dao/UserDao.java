package com.algo.onlineshipbooking.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.algo.onlineshipbooking.model.User;

@Repository
public interface UserDao extends JpaRepository<User, Long>{
	@Query("select u from User u where u.email = :email")
	public User getUserByUsername(@Param("email") String email);
}
