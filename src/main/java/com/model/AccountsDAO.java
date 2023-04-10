package com.model;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
@Component("accountsDAO")
public class AccountsDAO {
	
	@Autowired
	private SessionFactory factory;
	
	public AccountsDTO findByID(int id) {
		Session session=factory.getCurrentSession();
		AccountsDTO accountsDTO=session.get(AccountsDTO.class,Integer.valueOf(id));
		return accountsDTO;
	}
	public void updateAccount(AccountsDTO accountsDTO)
	{
		Session session = factory.getCurrentSession();
		session.persist(accountsDTO);
	}
	public SessionFactory getFactory() {
		return factory;
	}
	public void setFactory(SessionFactory factory) {
		this.factory = factory;
	}
}