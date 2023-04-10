package com.model;

public class InsufficientBalance extends Exception{
	String message;

	public InsufficientBalance(String message) {
		this.message = message;
	}
	@Override
	public String toString() {
		return message;
	}
}
