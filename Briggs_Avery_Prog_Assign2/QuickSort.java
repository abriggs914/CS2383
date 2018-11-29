/*
*	CS2383
*	Programming Assignment 2
*   Nov 2018
*	Question 1 c)
* 	Avery Briggs
*	3471065	
*
*
*	Java Program to sort an integer
*	array using a quick sorting
*	algorithm.
*
*/

public class QuickSort{

    static boolean sorted = false;
    
    public QuickSort(){}
	
    public static void main(String[] args){
        int[] A = {3, 6, 10, 18, 8, 7, 25, 40};
        show(A);
        sort(A);
        show(A);
    }
    
    public static void sort(int[] arr){
        int n = arr.length;
        quickSort(arr, 0, n - 1);
        sorted = true;
    }
    
	public static void show(int[] A){
		int i, n = A.length;
		if(!sorted){
			System.out.print("A: {");
		}
		else{
			System.out.print("Quick Sort\nA: {");			
		}
		for(i = 0; i < n; i++){
			System.out.print(A[i]);
			if(i < n-1){
				System.out.print(", ");
			}
		}
		System.out.println("}");
    }    
 
	public static int partition(int arr[], int low, int high){ 
        int pivot = arr[high];  
        int i = low - 1, j;
        for(j = low; j < high; j++){ 
            if(arr[j] <= pivot){ 
                i++; 
                swap(arr, i, j);
            } 
        } 
        int temp = arr[i + 1]; 
        arr[i + 1] = arr[high]; 
        arr[high] = temp; 
        return i++; 
    } 

    public static void quickSort(int arr[], int low, int high){ 
        if(low < high){ 
            int p = partition(arr, low, high); 
            quickSort(arr, low, p - 1); 
            quickSort(arr, p + 1, high); 
        } 
    } 
	
	public static void swap(int[] A, int i, int k){
		int temp = A[i];
		A[i] = A[k];
		A[k] = temp;
	}
}