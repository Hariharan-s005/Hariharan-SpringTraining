package com.example.demo;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;



/**
 * BankDTO class
 * @author Hariharan Shakthivel
 *
 */

@Entity
@Table(name="bank")
public class BankDTO {
	@Id
	private int uid;
	private String name;
	private int amount;
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	@Override
	public String toString() {
		return "BankDTO [uid=" + uid + ", name=" + name + ", amount=" + amount + "]";
	}
	
}
