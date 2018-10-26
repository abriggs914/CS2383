/*
*	CS2383 Programming assignment 1
*	Oct 2018
*	Avery Briggs
*	3471065
*
*	CheckBrackets.java
*	Java program to take in an expression and
*	determine if the brackets match up.
*	Functionality only supports '(' and ')'
*	as brackets. Program will print the string
*	and true or false, whether the brackets
*	match. Program requires that ONLY 1 '='
*	sign is entered per expression. The '='
*	sign is used to check left and right hand
*	parity of the expression.
*/

import java.util.Scanner;

public class CheckBrackets{

	// Integer array stack to keep track of the brackets on the
	// left hand and or right hand sides of the expression.
	static Stack stack = new Stack();

	// recursive function parameters:
	// i 	 - start index
	// expr	 - the expression to be checked
	// stack - a data structure to store bracket data.
	// a positive string can be of form:
	// (((x+1)*y) = 10), because the algorithm simply
	// checks for matching brackets, rather than checking
	// if the line is a valid mathematical expression.
	public static boolean checkBrackets(int i, String expr, Stack stack){
		int expLength = expr.length();
		if(i >= expLength-1 && !stack.empty() || expLength == 1){ // end of string, stack isnt empty
			return false;
		}
		else if(i >= expLength-1){ // end of string stack is empty
			return true;
		}
		else{
			try{
				while(i < expLength && expr.charAt(i) != '='){
					if(expr.charAt(i) == '('){
						stack.push('(');
					}
					else if(expr.charAt(i) == ')'){
						stack.pop();
					}
					i++;
				}
			}
			catch(Exception e){ // error, tried to do something that it wasn't supposed to.
				return false;
			}
			return checkBrackets(++i, expr, stack); // recurse
		}
	}

	public static void main(String[] args) throws fullStackException{
		Scanner scan = new Scanner(System.in);
		String expression = scan.nextLine();
		int temp = 0, i = 0;
		stack.init();
		if(checkBrackets(i, expression, stack)){
			System.out.println("expression: <" + expression + "> has valid bracket sequences");
		}
		else{
			System.out.println("expression: <" + expression + "> has at least one invalid bracket sequence.");
		}
	}
}
