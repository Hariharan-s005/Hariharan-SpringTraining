package com.example.exception;

/**
 * 
 * @author  Hariharan Shakthivel
 *
 */
public class IdAlreadyExistException extends Exception {

	private static final long serialVersionUID = 1L;

	public IdAlreadyExistException(String message) {
		super(message);
	}

}
