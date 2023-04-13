package com.example.demo;

import com.example.exception.AmountvalueException;
import com.example.exception.IdAlreadyExistException;
import com.example.exception.InsufficientBalanceException;
import com.example.exception.NegativeAmountException;

/**
 * BankServiceIntercae 
 * @author Hariharan Shakthivel
 *
 */
public interface BankServiceInterface {
      public void createUser(BankDTO bank) throws IdAlreadyExistException;
      public BankDTO checkBalance(int id);
     public void transfer(Transaction trans) throws InsufficientBalanceException, AmountvalueException, NegativeAmountException;
}
