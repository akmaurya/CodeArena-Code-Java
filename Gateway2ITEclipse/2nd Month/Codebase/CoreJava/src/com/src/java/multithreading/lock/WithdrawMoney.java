package com.src.java.multithreading.lock;

public class WithdrawMoney implements Runnable {
	private BankAccount bankAccount;

	@Override
	public void run() {
		try {
			withdraw(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void setBankAccount(BankAccount bankAccount) {
		this.bankAccount = bankAccount;
	}

	private void withdraw(final int amt) throws InterruptedException {
		System.out.println(Thread.currentThread().getName() + " is going to withdraw amount: "
				+ amt);
		bankAccount.withdraw(Thread.currentThread().getName(), amt);		
		System.out.println(Thread.currentThread().getName() + " completes the withdraw transaction.");
	}
}
