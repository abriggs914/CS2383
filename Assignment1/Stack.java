/*
*	CS2383 Programming assignment 1
*	Oct 2018	
*	Avery Briggs
*	3471065
*
*	Stack.java
*	Java program to simulate a stack using
*	an integer array of size 10. Reads in 
*	numbers one line at a time and executes
*	a single operation per value.
*	Added 'q' as a quick exit when entering
*	numbers on the command line.
*	x > 0 - push(x)
*	x < 0 - top()
*	x == 0 - pop()
*/

import java.util.Scanner;

public class Stack{
	
	static int[] S = new int[10];	// Integer array simulating the stack
	static int t = 0;	// index pointer to the top of the stack
	
	public static void main(String[] args) throws fullStackException{
		System.out.println("You may enter q at anytime to quit.\n");
		Scanner scan = new Scanner(System.in);
		String line;
		int val;
		init();
		while(scan.hasNextLine()){
			line = scan.nextLine();
			if(line.equals("q")){
				return;
			}
			try{
				val = Integer.parseInt(line);
					if(val > 0){
						push(val);
					}
					else if(val < 0){
						System.out.println(top());
					}
					else{
						pop();
					}
			}
			catch(fullStackException e){}
			catch(Exception ex){ //called when a non-integer is entered
				System.out.println("Exception caught in main\nNumbers only.\t'q' to quit");
			}
		}
		scan.close();
	}
	
	// init, initializes t to -1. called only to reset stack
	public static void init(){
		t = -1;
	}
	
	// empty return true or false depending on if the stack is
	// populated or not. (true: t > 0).
	public static boolean empty(){
		return t < 0;
	}
	
	// push adds a new value to the top of the stack
	// throws fullStackException if the stack is full (t == S.length-1).
	public static void push(int val) throws fullStackException{
		if(t == S.length-1){
			throw new fullStackException("error, stack is full. - Not enough room to push.");
		}
		else{
			t++;
			S[t] = val;
		}
	}
	
	// pop takes the first item off the top of the stack
	// throws fullStackException if nothing to pop
	public static void pop() throws fullStackException{
		if(empty()){
				throw new fullStackException("error, stack is empty - Nothing to pop.");
		}
		else{
			t--;
		}
	}
	
	// top returns the top value on the stack.
	// throws fullStackException if nothing on top.
	public static int top() throws fullStackException{
		if(empty()){
				throw new fullStackException("error, stack is empty. - Nothing on top.");
		}
		else{
			return S[t];
		}
	}
}