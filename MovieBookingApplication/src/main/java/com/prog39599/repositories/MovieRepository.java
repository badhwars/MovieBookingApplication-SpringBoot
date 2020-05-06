package com.prog39599.repositories;
import org.springframework.data.jpa.repository.JpaRepository;

import com.prog39599.beans.*;
public interface MovieRepository extends JpaRepository<Movie, Long>{
	
long deleteByName(String title);

}
