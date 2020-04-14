package com.codingdojo.bankaccount;
import java.util.Random;

public class BankAccount {
	private String accountNumber;
	private double checkingBalance;
	private double savingsBalance;
	static private int totalAccounts = 0;
	static private double allTheMoney = 0;
	
	public BankAccount() {
		accountNumber = createAccount();
		totalAccounts += 1;
	}
	
	private String createAccount() {
		Random r = new Random();
		accountNumber = "";
		for(int i=0;i<10;i++) {
			accountNumber += r.nextInt(10);
		}
		return accountNumber;
	}
	
	public void getAccount() {
		System.out.println(accountNumber);
	}
	public void getChecking() {
		System.out.println("Checking Balance = "+checkingBalance);
	}
	public void getSavings() {
		System.out.println("Savings Balance = "+savingsBalance);
	}
	public void depositMoney(double amount) {
		savingsBalance += amount;
		allTheMoney += amount;
	}
	public void depositMoney(String str, double amount) {
		if(str == "checking") {
			checkingBalance += amount;
		} else {
			savingsBalance += amount;
		}
		allTheMoney += amount;
	}
	public String withdrawMoney(double amount) {
		if(savingsBalance - amount < 0) {
			return "Insufficient funds";
		} else {
			savingsBalance -= amount;	
		}
		allTheMoney -= amount;
		return "Withdrew"+amount;
	}
	public String withdrawMoney(String str, double amount) {
		if(str == "checking") {
			if(checkingBalance - amount < 0) {
				return "Insufficient funds";
			} else {
				checkingBalance -= amount;	
			}
		} else {
			if(savingsBalance - amount < 0) {
				return "Insufficient funds";
			} else {
				savingsBalance -= amount;
			}
		}
		allTheMoney -= amount;
		return "Withdrew"+amount;
	}
	public static void getAllTheMoney() {
		System.out.println(allTheMoney);
	}
	public static void getTotalAccounts() {
		System.out.println(totalAccounts);
	}
}
