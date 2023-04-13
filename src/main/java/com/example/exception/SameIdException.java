/**
 * 
 */
package com.example.exception;

/**
 * @author Hariharan Shakthivel
 *
 */
public class SameIdException extends Exception {
	private static final long serialVersionUID = 1L;

	public SameIdException(String message) {
		super(message);
	}

}
