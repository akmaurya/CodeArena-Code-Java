package com.src.java.multithreading.lock;


public class BankAccount {
	@SuppressWarnings("unused")
	private int accountNumber;
	private volatile double accountBalance;

	public BankAccount(final int actNo) {
		this.accountNumber = actNo;
		this.accountBalance = 3000;
	}
	
	public BankAccount(final int actNo, final double actBal) {
		this.accountNumber = actNo;
		this.accountBalance = actBal;
	}

	// to withdraw funds from the account
	public boolean withdraw(final String accountHolderName, final double amount) throws InterruptedException {
		double newAccountBalance;
		System.out.println("\t\tBalance Amount is: " + this.accountBalance + " into A/c: " + accountHolderName);
		
		if (amount > accountBalance) {
			System.err.println("\t\tThere are not enough funds in the account[" + accountHolderName + "]");
			return false;
		} else {
			newAccountBalance = accountBalance - amount;
			Thread.sleep(1000);
			accountBalance = newAccountBalance;
			System.out.println("\t\tAmount Withdraw: " + amount + " from A/c holder: " + accountHolderName);
			System.out.println("\t\tAcount balance is: " + newAccountBalance + " for A/c holder: " + accountHolderName);
			return true;
		}
	}

	public boolean deposit(final String accountHolderName, final double amount) throws InterruptedException {
		double newAccountBalance;
		System.out.println("\t\tBalance Amount is: " + this.accountBalance + " into A/c: " + accountHolderName);
		
		if (amount < 0.0) {
			System.err.println("\t\tCan not deposit a negative amount...");
			return false;
		} else {
			newAccountBalance = accountBalance + amount;
			Thread.sleep(1000);
			accountBalance = newAccountBalance;
			System.out.println("\t\tAmount Deposited: " + amount + " into A/c: " + accountHolderName);
			System.err.println("\t\tAcount balance is: " + newAccountBalance + " for A/c holder: " + accountHolderName);
			return true;
		}
	}
}
