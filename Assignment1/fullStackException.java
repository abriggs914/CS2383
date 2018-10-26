/*
*	CS2383 Programming assignment 1
*	Oct 2018	
*	Avery Briggs
*	3471065
*
*	fullStackException.java
*	Java program to create an exception.
*	program takes a message from the throwing
*	method and prints it to the console.
*/

public class fullStackException extends Exception{
	public fullStackException(String message){
		System.out.println(message);
	}
}