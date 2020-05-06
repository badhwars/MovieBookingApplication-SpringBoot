package com.prog39599.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.prog39599.beans.Roles;

import com.prog39599.repositories.CustomerRepository;
import com.prog39599.repositories.UserRepository;

@Service 
public class UsersDetailsServiceImpl implements UserDetailsService{

	@Autowired
	private UserRepository userRepo;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		//1) Find the user based on the user name
		com.prog39599.beans.User user = userRepo.findByUsername(username);
		// If the user doesn't exist throw an exception
		if (user == null) {
		System.out.println("User not found:" + username);
		throw new UsernameNotFoundException("User " + username + " was "
				+ "not found in the database");
		}
		
		//Next, we want to convert any Entity Roles we find related to said user
		//into something Spring Boot can understand and work with
		
		// 2)Change the list of the user's roles into a list of GrantedAuthority
		List<GrantedAuthority> grantList = new ArrayList<GrantedAuthority>();
		for (Roles role : user.getRoles()) {
		grantList.add(new SimpleGrantedAuthority(role.getRolename()));
		
		}
		
		
		//And last but not least for this service, roles in hand, we can now 
		//convert our User Entity into a Spring Boot UserDetails so
		//Spring can work its magic!
	
		// Create a user based on the information above.
		//This user is not an object of the User class we wrote!!!
		//It is a Spring Framework Security Core User Details user!
		UserDetails userDetails = (UserDetails) new User(user.getUsername(), 
				user.getEncryptedPassword(),
		grantList);
		return userDetails;
	}

}
