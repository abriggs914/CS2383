/*
*	CS2383
*	Programming Assignment 1
*	Question 1 b)
* 	Avery Briggs
*	3471065	
*
*
*	Java Program to sort an integer
*	array using a insertion sorting
*	algorithm.
*
*/

import java.util.Scanner;

public class InsertSort{
	
	static boolean sorted;
	
	public static void main(String[] args){
		int[] A = {7,4,8,2,5,3,9};
		sorted = false;
		show(A);
		sort(A);
		show(A);
	}
	
	public static void sort(int[] A){
		int i, j, n = A.length, key;
        for (i = 1; i < n; i++){
            key = A[i];
            j = i - 1;
            while (j >= 0 && A[j] > key){
                A[j + 1] = A[j];
                j = j - 1;
            }
            A[j + 1] = key;
        }
		sorted = true;
	}
	
	public static void show(int[] A){
		int i, n = A.length;
		if(!sorted){
			System.out.print("A: {");
		}
		else{
			System.out.print("Insertion Sort\nA: {");			
		}
		for(i = 0; i < n; i++){
			System.out.print(A[i]);
			if(i < n-1){
				System.out.print(", ");
			}
		}
		System.out.println("}");
	}
}