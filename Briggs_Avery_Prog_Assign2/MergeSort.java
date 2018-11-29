/*
*	CS2383
*	Programming Assignment 2
*   Nov 2018
*	Question 1 a)
* 	Avery Briggs
*	3471065	
*
*
*	Java Program to sort an integer
*	array using a merge sorting
*	algorithm.
*
*/

public class MergeSort{

	static boolean sorted = false;
	
    public MergeSort(){}
	
    public static void main(String[] args){
        int[] A = {3, 6, 10, 18, 8, 7, 25, 40};
        show(A);
        sort(A);
        show(A);
	}
	
	public static void sort(int[] arr){
		int n = arr.length;
		mergeSort(arr, 0, n - 1);
		sorted = true;
	}

	public static void show(int[] A){
		int i, n = A.length;
		if(!sorted){
			System.out.print("A: {");
		}
		else{
			System.out.print("Merge Sort\nA: {");			
		}
		for(i = 0; i < n; i++){
			System.out.print(A[i]);
			if(i < n - 1){
				System.out.print(", ");
			}
		}
		System.out.println("}");
	}	
 
	public static void merge(int[] arr, int l, int m, int r){ 
		int nLeft = m - l + 1; 
		int nRight = r - m; 
		int i = 0, j = 0, k; 
		int[] left = new int[nLeft]; 
		int[] right = new int[nRight]; 
		for(i = 0; i < nLeft; i++){
			left[i] = arr[l + i]; 
		}
		for(j = 0; j < nRight; j++){
			right[j] = arr[m + 1 + j];
		} 
		i = 0;
		j = 0;
		k = l; 
		while(i < nLeft && j < nRight){ 
			if(left[i] <= right[j]){ 
				arr[k] = left[i]; 
				i++; 
			} 
			else{ 
				arr[k] = right[j]; 
				j++; 
			} 
			k++; 
		} 
		while(i < nLeft){ 
			arr[k] = left[i]; 
			i++; 
			k++; 
		} 
		while(j < nRight){ 
			arr[k] = right[j]; 
			j++; 
			k++; 
		} 
	} 

	public static void mergeSort(int[] arr, int l, int r){ 
		if(l < r){ 			
			int m = (l + r)/2;
			mergeSort(arr, l, m); 
			mergeSort(arr , m + 1, r); 			 
			merge(arr, l, m, r); 
		}
	} 
    
}