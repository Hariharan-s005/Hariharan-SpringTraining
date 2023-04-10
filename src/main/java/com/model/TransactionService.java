package com.model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
@Service("transactionService")
@Transactional
public class TransactionService {
	
	@Autowired
	private BankingService bankingService;
	
	public BankingService getBankingService() {
		return bankingService;
	}
	public void setBankingServices(BankingService bankingService) {
		this.bankingService = bankingService;
	}
	@Transactional(propagation = Propagation.REQUIRED)
	public void moneyTransfer(int creditId,int debitId,int amount)throws InsufficientBalance {
		bankingService.doCredit(creditId, amount);
		bankingService.doDebit(debitId, amount);			
	}
}