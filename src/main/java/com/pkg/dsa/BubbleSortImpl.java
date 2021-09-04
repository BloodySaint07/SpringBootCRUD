package com.pkg.dsa;

public class BubbleSortImpl {

	public void sorting(int arr[]) {

		int size = arr.length;
		int i, j, temp;
        boolean swapped=false;
		for (i = 0; i <= size - 1; i++) {

			for (j = 0; j < size - 1 - i; j++) {
				if (arr[j] > arr[j + 1]) {

					temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
					
					swapped=true;
				}

			}
			if(!swapped) {
				break;
			}

		}

	}

	public void printSortedArray(int arr1[]) {

		int size = arr1.length;
		for (int x = 0; x < size; ++x) {
			System.out.print(arr1[x] + " ");
			System.out.println();
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		BubbleSortImpl ob = new BubbleSortImpl();
	        int arr[] = {64, 34, 25, 12, 22, 11, 90};
	        ob.sorting(arr);
	        System.out.println("Sorted array");
	        ob.printSortedArray(arr);

	}

}
