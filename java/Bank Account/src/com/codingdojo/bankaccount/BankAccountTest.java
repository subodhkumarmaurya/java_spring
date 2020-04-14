package com.codingdojo.bankaccount;

public class BankAccountTest {

	public static void main(String[] args) {
		BankAccount bA1 = new BankAccount();
		BankAccount bA2 = new BankAccount();
		BankAccount bA3 = new BankAccount();
		
		bA1.getAccount();
		bA1.getChecking();
		bA1.getSavings();
		bA1.depositMoney("checking", 5.5);
		bA1.getChecking();
		bA1.getSavings();
		
		bA2.getAccount();
		bA2.getChecking();
		bA2.getSavings();
		bA2.depositMoney("checking", 4.4);
		bA2.getChecking();
		bA2.getSavings();
		bA2.depositMoney(5.6);
		bA2.getChecking();
		bA2.getSavings();
		System.out.println(bA2.withdrawMoney(6));
		bA2.getChecking();
		bA2.getSavings();
		
		BankAccount.getAllTheMoney();
		BankAccount.getTotalAccounts();
	}

}
