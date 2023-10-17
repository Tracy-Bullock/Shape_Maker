/**
 * @author Tracy Bullock 
 * CMSC 335 7382 Object-Oriented and Concurrent Programming (2218) 
 * Project 2 
 * November 16, 2021 
 * Created with Eclipse IDE
 * 
 * InvalidInputException.java - A class that creates a exception 
 * for invalid input from the user.
 * 
 */

package javaShapeMaker;

public class InvalidInputException extends Exception {

	private static final long serialVersionUID = 1L;

	/**
	 * InvalidInputException - parameterized constructor that 
	 * gives a custom message depending on what is thrown.
	 * 
	 * @param message of type String.
	 */
	public InvalidInputException(String message) {
		super(message);
	}

}
