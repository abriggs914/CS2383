/*
*	CS2383 Programming assignment 1
*	Oct 2018	
*	Avery Briggs
*	3471065
*
*	Queue.java
*	Java program to simulate a queue using
*	an integer array of size 10. Reads in 
*	numbers one line at a time and executes
*	a single operation per value.
*	Added 'q' as a quick exit when entering
*	numbers on the command line.
*	x > 0 - enqueue(x)
*	x < 0 - dequeue()
*	x == 0 - front()
*/

import java.util.Scanner;

public class Queue{
	
	static int[] Q = new int[10];	// Integer array simulating the queue
	static int f = 0, r = 0;	// index pointer to the first and last index of the queue
	
	public static void main(String[] args) throws fullStackException{
		System.out.println("You may enter q at anytime to quit.\n");
		Scanner scan = new Scanner(System.in);
		String line;
		int val;
		queue_init();
		while(scan.hasNextLine()){
			line = scan.nextLine();
			if(line.equals("q")){
				return;
			}
			try{
				val = Integer.parseInt(line);
					if(val > 0){
						enqueue(val);
					}
					else if(val < 0){
						System.out.println(front());
					}
					else{
						dequeue();
					}
			}
			catch(fullStackException e){}
			catch(Exception ex){ //called when a non-integer is entered
				System.out.println("Exception caught in main\nNumbers only.\t'q' to quit");
			}
		}
		scan.close();
	}
	
	// init, initializes f and r to -1. called only to reset queue pointers
	public static void queue_init(){
		f = -1;
		r = -1;
	}
	
	// empty return true or false depending on if the queue is
	// populated or not. (true: r > 0).
	public static boolean empty(){
		return r == -1;
	}
	
	// push adds a new value to the top of the queue
	// throws fullStackException if the queue is full (t == A.length-1).
	public static void enqueue(int val) throws fullStackException{
		if(empty()){
			r = 0; 
			f = 0;
			Q[r] = val;
		}
		else{
			r++;
			if(r == Q.length-1){
				r = 0;
			}
			if(r == f){
				throw new fullStackException("error, queue is full. - Not enough room to enqueue.");
			}
			else{
				Q[r] = val;
			}
		}
	}
	
	// pop takes the first item in the front of the queue
	// throws fullStackException if queue is empty
	public static void dequeue() throws fullStackException{
		if(empty()){
				throw new fullStackException("error, queue is empty - Nothing to dequeue.");
		}
		else if(r == f){
			r = -1;
			f = -1;
		}
		else{
			f++;
			if(f == Q.length-1){
				f = 0;
			}
		}
	}
	
	// top returns the top value on the queue.
	// throws fullStackException if queue is empty.
	public static int front() throws fullStackException{
		if(empty()){
				throw new fullStackException("error, queue is empty.");
		}
		else{
			return Q[f];
		}
	}
}