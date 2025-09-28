package com.mg.lab2;
import java.util.Scanner;
import java.math.BigDecimal;

public class Driver {
	
	Scanner scan = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		Driver driver = new Driver(); // Create instance to access non-static scanner
		
		System.out.println("Enter 1 value: ");
		double v1 = driver.scan.nextDouble();
		
		System.out.println("Enter 2 value: ");
		double v2 = driver.scan.nextDouble();
		
		System.out.println("Enter 3 value: ");
		int v3 = driver.scan.nextInt();
		
		System.out.println("Enter 4 value: ");
		int v4 = driver.scan.nextInt();
		
		//Method overloaded
		Interest i1 = new Interest(v1,v2,v3);
		Interest i2 = new Interest(v1,v2,v3,v4);
		
		driver.scan.close();
	/*
	 * 5 Objects to be created!
	 * 
	 * User input into all 5 Objects
	 * 
	 * stopped 45mins left
	 */
	}

}
