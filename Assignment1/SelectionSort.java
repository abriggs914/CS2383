/*
*	CS2383
*	Programming Assignment 1
*	Question 1 a)
* 	Avery Briggs
*	3471065	
*
*
*	Java Program to sort an integer
*	array using a selection sorting
*	algorithm.
*
*/

import java.util.Scanner;

public class SelectionSort{
	
	static boolean sorted;
	
	public static void main(String[] args){
		int[] A = {7,4,8,2,5,3,9};
		sorted = false;
		show(A);
		sort(A);
		show(A);
	}
	
	public static void sort(int[] A){
		int n = A.length;
		int i, j, k;
		for(i = 0; i < n; i++){
			k = i;
			for(j = i + 1; j < n; j++){
				if(A[j] < A[k]){
					k = j;
				}
			}
			swap(A, i, k);
		}
		sorted = true;
	}
	
	public static void show(int[] A){
		int i, n = A.length;
		if(!sorted){
			System.out.print("A: {");
		}
		else{
			System.out.print("Selection Sort\nA: {");			
		}
		for(i = 0; i < n; i++){
			System.out.print(A[i]);
			if(i < n-1){
				System.out.print(", ");
			}
		}
		System.out.println("}");
	}
	
	public static void swap(int[] A, int i, int k){
		int temp = A[i];
		A[i] = A[k];
		A[k] = temp;
	}
}