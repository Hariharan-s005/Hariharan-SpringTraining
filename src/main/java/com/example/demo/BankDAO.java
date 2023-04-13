package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BankDAO extends JpaRepository<BankDTO,Integer>{
   
   	
}
