package com.arrays;

import java.util.Scanner;

class SecondLargestNumber {

	public void findSecondMaxNumber(int[] numbers) {
		int maximumOne = 0;
		int maximumTwo = 0;
		for (int n : numbers) {
			if (maximumOne < n) {
				maximumTwo = maximumOne;
				maximumOne = n;
			} else if (maximumTwo < n) {
				maximumTwo = n;
			}
		}

		System.out.println("Second Max Number: " + maximumTwo);
	}
}

public class SortingExample3 {
	/**
	 * @param a
	 */
	public static void main(String a[]) {

		Scanner input = new Scanner(System.in); // takes the input from console

		System.out.println("enter number of elements");

		int n = input.nextInt();

		int array[] = new int[n];

		System.out.println("enter elements");

		for (int i = 0; i < n; i++) { // for reading array
			array[i] = input.nextInt();

		}
		SecondLargestNumber secondLargestNum = new SecondLargestNumber();
		secondLargestNum.findSecondMaxNumber(array);
	}
}
