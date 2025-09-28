package com.mg.lab2;
import java.util.Scanner;
import java.math.BigDecimal;

public class Driver {
	
	Scanner scan = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		Driver driver = new Driver(); // Create instance to access non-static scanner
		
		System.out.println("Enter Principal value: ");
		double principal = driver.scan.nextDouble();
		
		System.out.println("Enter Rate: ");
		double rate = driver.scan.nextDouble();
		
		System.out.println("Enter Time: ");
		int time = driver.scan.nextInt();
		
		System.out.println("Enter Compounded/yr: ");
		int compounded = driver.scan.nextInt();
		
		//Method overloaded
		Interest Output1 = new Interest(principal,rate,time);
		Interest Output2 = new Interest(principal,rate,time,compounded);
		
		driver.scan.close();
	}

}
