package com.model;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
@Service
@Transactional
public class MyService{

@Autowired
private AccountsDAO accountsDAO;

 public void doService(int accountId,int amount) {
	 AccountsDTO accountsDTO=accountsDAO.findByID(accountId);
	 accountsDTO.setAmount(amount);
	 accountsDAO.updateAccount(accountsDTO);

}

 public AccountsDAO getDAO() {
	 return accountsDAO;
	 
}

}