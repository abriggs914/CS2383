/*
*	CS2383 Programming assignment 1
*	Oct 2018	
*	Avery Briggs
*	3471065
*
*	MonkeyEatPeach.java
*	Java program to recursively solve
*	for how many peaches a monkey must
*	have picked on Monday for him to only
*	have one left on Sunday morning.
*	The monkey eats ((n/2)+1) peaches 
*	every day.
*/

public class MonkeyEatPeach{
	
	public static void main(String[] args){
		int days = 7; 	// monday -> sunday 7 days
		// The monkey only has 1 peach left on Sunday, so monkeyPickPeach is called with (days, 1).
		System.out.println("\nThe monkey picked " + monkeyPickPeach(days, 1) + " peaches on Monday."); // == 190
	}
	
	// method monkeyPickPeach() takes two arguments.
	// days - the number of days the monkey has been 
	// eating the peaches
	// peaches - the running sum of how many peaches the 
	// monkey must have picked on Monday.
	public static int monkeyPickPeach(int days, int peaches){
		if(days == 1){
			return peaches;
		}
		else{
			return monkeyPickPeach(--days, ((peaches * 2) + 2));
		}
	}
}