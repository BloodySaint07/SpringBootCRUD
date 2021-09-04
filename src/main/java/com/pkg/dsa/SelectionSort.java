package com.pkg.dsa;

public class SelectionSort {

	public void sorting(int arr[]) {

		int i, j, temp, min_index;
		int n = arr.length;

		// Looping over outer array
		for (i = 0; i < n - 1; i++) {
			min_index = i;
			// Unsorted Array
			for (j = i + 1; j < n; j++) {

				if (arr[j] < arr[min_index]) {
					min_index = j;
					
					//Swapping 1st one with min value
					temp = arr[min_index];
					arr[min_index] = arr[i];
					arr[i] = temp;

				}

			}

		}

	}
	
	
	void printArray(int arr[])
    {
        int n = arr.length;
        for (int i=0; i<n; ++i)
            System.out.print(arr[i]+" ");
        System.out.println();
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		SelectionSort ob = new SelectionSort();
        int arr[] = {64,25,12,22,11};
        ob.sorting(arr);
        System.out.println("Sorted array");
        ob.printArray(arr);
		
		
	}

}
