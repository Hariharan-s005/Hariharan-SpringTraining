package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.exception.AmountvalueException;
import com.example.exception.InsufficientBalanceException;
import com.example.exception.NegativeAmountException;
import com.example.exception.SameIdException;

@RestController
@RequestMapping(value = "/bank")

/**
 * Class BankController having Controllers
 * 
 * @author Hariharan Shakthivel
 *
 */
public class BankController {
	@Autowired
	private BankService bank;

	/**
	 * Sets ViewName "menu" on URL path menu
	 * 
	 * @param modelAndView
	 * @return modelAndView
	 */
	@GetMapping("menu")
	public ModelAndView menu(ModelAndView modelAndView) {
		modelAndView.setViewName("menu");
		return modelAndView;
	}

	/**
	 * Creates object for BankDTO on URL path "createAccount"
	 * 
	 * @param modelAndView
	 * @return modelAndView
	 */
	@GetMapping("create-account")
	public ModelAndView create(ModelAndView modelAndView) {
		BankDTO bank = new BankDTO();
		modelAndView.addObject("bank", bank);
		modelAndView.setViewName("create-account");
		return modelAndView;
	}

	/**
	 * Creates user for BankDTO object bankDTO
	 * 
	 * @param bankDTO
	 * @param modelAndView
	 * @return modelAndView
	 */
	@PostMapping("create-account")
	public ModelAndView addAccount(BankDTO bankDTO, ModelAndView modelAndView) {
		try {
			bank.createUser(bankDTO);
		} catch (Exception e) {
			modelAndView.setViewName("invalid-id");
			return modelAndView;
		}
		modelAndView.setViewName("user");
		return modelAndView;
	}

	/**
	 * Checks balance of user
	 * 
	 * @param modelAndView
	 * @return modelAndView
	 */
	@GetMapping("check-balance")
	public ModelAndView checkBalance(ModelAndView modelAndView) {
		BankDTO bank = new BankDTO();
		modelAndView.addObject("bank", bank);
		modelAndView.setViewName("check-balance");
		return modelAndView;
	}

	/**
	 * Check balance for user id
	 * 
	 * @param bankDTO
	 * @param modelAndView
	 * @return modelAndView
	 */
	@PostMapping("check-balance")
	public ModelAndView find(BankDTO bankDTO, ModelAndView modelAndView) {
		int id = bankDTO.getUid();
		BankDTO balance = bank.checkBalance(id);
		modelAndView.addObject("balance", balance);
		modelAndView.setViewName("balance");
		return modelAndView;
	}

	/**
	 * Transfer money
	 * 
	 * @param modelAndView
	 * @return modelAndView
	 */
	@GetMapping("transfer")
	public ModelAndView transaction(ModelAndView modelAndView) {
		Transaction transfer = new Transaction();
		modelAndView.addObject("transfer", transfer);

		modelAndView.setViewName("transfer");
		return modelAndView;

	}

	/**
	 * Transfer status message display on URL path insufficientBalance and
	 * transferSuccessful
	 * 
	 * @param modelAndView
	 * @param transaction
	 * @return modelAndView
	 */
	@PostMapping("transfer")
	public ModelAndView transactionsuccess(ModelAndView modelAndView, Transaction transaction) {
		try {
			bank.transfer(transaction);
		} catch (InsufficientBalanceException e) {
			modelAndView.addObject("error", e);
			modelAndView.setViewName("insufficient-funds");
			return modelAndView;
		}
		catch(AmountvalueException e)
		{
			modelAndView.setViewName("amount-value-zero");
			return modelAndView;
		}
		catch(NegativeAmountException e)
		{
			modelAndView.setViewName("amount-value-negative");
			return modelAndView;
		}
		catch(SameIdException e)
		{
			modelAndView.setViewName("same-id");
			return modelAndView;
		}
		
		modelAndView.setViewName("transfer-successful");
		return modelAndView;
	}

}
