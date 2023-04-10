package com.model;
import javax.naming.InsufficientResourcesException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
@Service("bankingService")
@Transactional
public class BankingService {
	
	@Autowired
	private AccountsDAO accountsDAO;
	
	@Transactional(propagation = Propagation.REQUIRED)
	public void doCredit(int accountId,int creditAmount) {
		AccountsDTO accountsDTO=accountsDAO.findByID(accountId);
		int amount=accountsDTO.getAmount();
		int newAmount=amount+creditAmount;
		accountsDTO.setAmount(newAmount);
		accountsDAO.updateAccount(accountsDTO);
	}
	@Transactional(propagation = Propagation.REQUIRED,rollbackFor = {InsufficientBalance.class})
	public void doDebit(int accountId,int debitAmount)throws InsufficientBalance {
		AccountsDTO accountsDTO=accountsDAO.findByID(accountId);
		int amount=accountsDTO.getAmount();
		if(amount<debitAmount) {
			throw new InsufficientBalance("Balance not sufficient");
		}
		int newAmount=amount-debitAmount;
		accountsDTO.setAmount(newAmount);
		accountsDAO.updateAccount(accountsDTO);
	}
}