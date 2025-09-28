package com.mg.lab2;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class Interest {

	private double principal;
	private double rate;
	private int time;
	private int n;
	
	public Interest(double principalData, double rateData, int timeData) {
		if(Double.isNaN(principalData) || Double.isNaN(rateData) || Double.isNaN(timeData) ) {
			System.out.print("Please enter only Intiger values");
		}else if ((principalData < -1) || (rateData < -1) || (timeData < -1)) {
			System.out.print("Please enter only Positive values");
		}			
		
		this.principal = (double) principalData;
		this.rate = (double) rateData;
		this.time = (int) timeData;
		
		System.out.println("Principal: "+principal);
		System.out.println("Rate: "+rate);
		System.out.println("Time: "+time);
				
		double SI = SimpleInterest(principal,rate,time);
		System.out.printf("Simple Interest Rate Double: %.2f%n",SI);		
		
		BigDecimal SIbg = SimpleInterestBigDec(principal,rate,time);
		System.out.printf("Simple Interest Rate BigDecimal: %f%n",SIbg);		
	}
	
	public Interest(double principalData, double rateData, int timeData, int nData) {

		if(Double.isNaN(principalData) || Double.isNaN(rateData) || Double.isNaN(timeData) || Double.isNaN(nData) ) {
			System.out.print("Please enter only Intiger values");
		}else if ((principalData < -1) || (rateData < -1) || (timeData < -1) || (nData < -1)) {
			System.out.print("Please enter only Positive values");
		}			
		
		this.principal = (double) principalData;
		this.rate = (double) rateData;
		this.time = (int) timeData;
		this.n = (int) nData;
		
		System.out.println("\nCompounding periods/yr: "+n);
		
		double CI = CompoundInterest(principal,rate,time,n);
		System.out.printf("Compound Interest Rate Double: %.2f%n",CI);
		
		BigDecimal CIbg = CompoundInterestBigDec(principal,rate,time,n);
		System.out.printf("Compound Interest Rate Big Decimal: %f%n",CIbg);
	}
	
	// method for calculating SI = PxRxT/100;
	
	double SimpleInterest(double principal, double rate, int time) {
		double result = (principal*rate*time)/100;
		return result;
	}
	
	// method for calculating COMP INT
	double CompoundInterest(double principal, double rate, int time, int n) {
		double rDecimal = rate/100.0;
		double amount = principal*Math.pow(1+rDecimal / n,n*time);
		return amount - principal;
	}
	
	BigDecimal SimpleInterestBigDec(double principal, double rate, int time) {
		BigDecimal step1 = BigDecimal.valueOf(principal).multiply(BigDecimal.valueOf(rate));
		BigDecimal step2 = (step1.multiply(BigDecimal.valueOf(time)));
		BigDecimal result = step2.divide(BigDecimal.valueOf(100),10, RoundingMode.HALF_UP);
		return result;
	}
	
	// method for calculating COMP INT
	BigDecimal CompoundInterestBigDec(double principal, double rate, int time, int n) {
		BigDecimal P = BigDecimal.valueOf(principal);
        BigDecimal r = BigDecimal.valueOf(rate).divide(BigDecimal.valueOf(100), 10, RoundingMode.HALF_UP);
        BigDecimal one = BigDecimal.ONE;

        // (1 + r/n)
        BigDecimal base = one.add(r.divide(BigDecimal.valueOf(n), 10, RoundingMode.HALF_UP));

        // exponent = n * t
        int exponent = n * time;

        // (1 + r/n)^(n*t)
        BigDecimal factor = base.pow(exponent);

        // A = P * factor
        BigDecimal amount = P.multiply(factor);

        // CI = A - P
        return amount.subtract(P).setScale(10, RoundingMode.HALF_UP);
	}
}

