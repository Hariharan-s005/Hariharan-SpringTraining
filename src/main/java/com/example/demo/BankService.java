package com.example.demo;

import java.util.Optional;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.example.exception.AmountvalueException;
import com.example.exception.IdAlreadyExistException;
import com.example.exception.InsufficientBalanceException;
import com.example.exception.NegativeAmountException;


/**
 * BankService class which implements BankServiceInterface
 * @author Hariharan Shakthivel
 *
 */
@Service("bankService")
@Transactional
public class BankService implements BankServiceInterface{

	@Autowired
	private BankDAO bankDAO;
	@Override
	public void createUser(BankDTO bank) throws IdAlreadyExistException {
		int id=bank.getUid();
		if(bankDAO.existsById(Integer.valueOf(id))) {
		throw new IdAlreadyExistException("User already exists for this Id");
		}
		else {
		bankDAO.save(bank);
		}
		}

	@Override
	public BankDTO checkBalance(int id) {
		// TODO Auto-generated method stub
		Optional<BankDTO> optional=bankDAO.findById(Integer.valueOf(id));
		BankDTO bankAccount=optional.get();
		return bankAccount;
	}

	@Override
	@Transactional(propagation =Propagation.REQUIRES_NEW)
	public void transfer(Transaction trans) throws InsufficientBalanceException, AmountvalueException, NegativeAmountException {
		
	  int creditId=trans.getCredit();
	  int debitId=trans.getDebit();
	  int amount =trans.getAmount();
	  
	  debitransfer(debitId, amount);
	  creditransfer(creditId, amount);
		
	}
	
	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public void debitransfer(int id,int amount) throws InsufficientBalanceException, AmountvalueException, NegativeAmountException {
		Optional<BankDTO> optional=bankDAO.findById(Integer.valueOf(id));
		BankDTO bankAccount=optional.get();
		if(bankAccount.getAmount()<amount) {
			throw new InsufficientBalanceException("Insufficient balance");
		}
		if(amount==0)
			throw new AmountvalueException("Please enter correct amount(should not be zero)");
		if(amount<0)
			throw new NegativeAmountException("Please enter correct amount(should be greater than zero)");
		
		bankAccount.setAmount(bankAccount.getAmount()-amount);
		System.out.println(bankAccount.getAmount());
		bankDAO.save(bankAccount);
	}
	
	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public void creditransfer(int id,int amount) {
		Optional<BankDTO> optional=bankDAO.findById(Integer.valueOf(id));
		BankDTO bankAccount=optional.get();
		bankAccount.setAmount(bankAccount.getAmount()+amount);
		System.out.println(bankAccount.getAmount());
		bankDAO.save(bankAccount);
	}
	
	
	

}
