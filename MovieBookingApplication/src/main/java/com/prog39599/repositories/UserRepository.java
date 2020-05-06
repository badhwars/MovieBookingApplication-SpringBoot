package com.prog39599.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prog39599.beans.User;

public interface UserRepository extends JpaRepository<User,Long>{
	public User findByUsername(String username);

}
