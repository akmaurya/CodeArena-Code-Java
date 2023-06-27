package com.src.java.multithreading.lock;

public class AccountTesting {
	public static void main(String[] args) throws InterruptedException {
		DepositMoney depositMoney = new DepositMoney();
		BankAccount bankAccount = new BankAccount(123456);

		// Thread for Jack deposit transaction
		depositMoney.setBankAccount(bankAccount);
		Thread one = new Thread(depositMoney);
		one.setName("Jack");

		// Thread for Jack deposit transaction
		Thread two = new Thread(depositMoney);
		two.setName("Jill");

		one.start();
		one.join();
		two.start();
		two.join();

		// Thread for Jems transfer transaction
//		WithdrawMoney withdrawMoney = new WithdrawMoney();
//		withdrawMoney.setBankAccount(bankAccount);
//		Thread three = new Thread(withdrawMoney);
//		three.setName("Jems");
//		three.start();
	}
}
