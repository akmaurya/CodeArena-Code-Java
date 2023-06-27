package com.src.java.multithreading.lock;

public class DepositMoney implements Runnable {
	private BankAccount bankAccount;

	@Override
	public void run() {
		try {
			deposit(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void setBankAccount(BankAccount bankAccount) {
		this.bankAccount = bankAccount;
	}

	private void deposit(final int amt) throws InterruptedException {
		System.out.println(Thread.currentThread().getName() + " is going to deposit amount: "
				+ amt);
		bankAccount.deposit(Thread.currentThread().getName(), amt);		
		System.out.println(Thread.currentThread().getName() + " completes the deposit transaction.");
	}
}
