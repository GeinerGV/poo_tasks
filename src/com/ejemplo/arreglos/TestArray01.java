package com.ejemplo.arreglos;

public class TestArray01 {
	public static void main(String[] args) {
		int[] array1 = {1,3,5,7,9,11,13,15};
		int[] array2;
		
		System.out.println("Array1 :");
		for (int i=0; i<array1.length; i++) {
			System.out.print("["+i+"]="+array1[i]+" , ");
		}
		System.out.println("\n");
		
		array2 = array1;
		for (int i=0; i<array2.length; i+=2) {
			array2[i]=i;
		}
		
		System.out.println("Array1 :");
		for (int i=0; i<array1.length; i++) {
			System.out.print("["+i+"]="+array1[i]+" , ");
		}
		System.out.println("\n");
		
		System.out.println("Array2 :");
		for (int i=0; i<array2.length; i++) {
			System.out.print("["+i+"]="+array2[i]+" , ");
		}
		System.out.println("\n");
	}
}
