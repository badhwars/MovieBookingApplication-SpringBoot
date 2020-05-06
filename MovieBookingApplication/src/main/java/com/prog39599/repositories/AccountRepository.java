package com.prog39599.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prog39599.beans.Account;

public interface AccountRepository extends JpaRepository<Account, Long> {

}
