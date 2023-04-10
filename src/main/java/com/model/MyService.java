package com.model;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
@Service
@Transactional
public class MyService{

@Autowired
private AccountsDAO dao;

 public void doService(int accountId,int amount) {
	 AccountsDTO dto=dao.findByID(accountId);
	 dto.setAmount(amount);
	 dao.updateAccount(dto);

}

 public AccountsDAO getDAO() {
	 return dao;
	 
}

}