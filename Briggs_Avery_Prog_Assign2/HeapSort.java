/*
*	CS2383
*	Programming Assignment 2
*   Nov 2018
*	Question 1 b)
* 	Avery Briggs
*	3471065	
*
*
*	Java Program to sort an integer
*	array using a heap sorting
*	algorithm.
*
*/

public class HeapSort{

    static boolean sorted = false;
    
    public HeapSort(){}
	
    public static void main(String[] args){
        int[] A = {3, 6, 10, 18, 8, 7, 25, 40};
        show(A);
        sort(A);
        show(A);
	}
 
	public static void sort(int[] arr){ 
        int n = arr.length, i; 
        for(i = n / 2 - 1; i >= 0; i--){
            heapify(arr, n, i); 
        } 
        for(i = n - 1; i >= 0; i--){ 
            int temp = arr[0]; 
            arr[0] = arr[i]; 
            arr[i] = temp; 
            heapify(arr, i, 0); 
        }
        sorted = true; 
    } 

	public static void show(int[] A){
		int i, n = A.length;
		if(!sorted){
			System.out.print("A: {");
		}
		else{
			System.out.print("Heap Sort\nA: {");			
		}
		for(i = 0; i < n; i++){
			System.out.print(A[i]);
			if(i < n - 1){
				System.out.print(", ");
			}
		}
		System.out.println("}");
    }    
    
    public static void heapify(int[] arr, int n, int i){ 
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        if(left < n && arr[left] > arr[largest]){
            largest = left; 
        }
        if(right < n && arr[right] > arr[largest]){
            largest = right; 
        }
        if(largest != i){ 
            swap(arr, i, largest);
            heapify(arr, n, largest); 
        } 
    }    
	
	public static void swap(int[] A, int i, int k){
		int temp = A[i];
		A[i] = A[k];
		A[k] = temp;
	}
}