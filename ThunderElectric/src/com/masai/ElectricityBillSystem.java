package com.masai;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

class ElectricityBillSystem {
	private List<Consumer> consumers;
	private List<Bill> bills;

	public ElectricityBillSystem() {
		consumers = new ArrayList<>();
		bills = new ArrayList<>();
	}

	public void registerConsumer(String username, String password, String firstName, String lastName, String address,
			String mobileNumber, String email) {
		for (Consumer consumer : consumers) {
			if (consumer.getUsername().equals(username)) {
				throw new IllegalArgumentException("Username already exists. Please choose a different username.");
			}
		}
		Consumer newConsumer = new Consumer(username, password, firstName, lastName, address, mobileNumber, email);
		consumers.add(newConsumer);
		System.out.println("Consumer registered successfully.");
	}

	public void displayAllConsumers() {
		if (consumers.isEmpty()) {
			System.out.println("No consumers found.");
			return;
		}

		for (Consumer consumer : consumers) {
			if (consumer.isActive() == true) {

				System.out.println(consumer.getUsername() + "\t" + consumer.getFullName() + "\t" + consumer.getAddress()
						+ "\t" + consumer.getMobileNumber() + "\t" + consumer.getEmail());
			}
		}
	}

	public void displayConsumerBill(String consumerUsername) {
		Bill bill = getLatestBill(consumerUsername);
		if (bill == null) {
			System.out.println("No bill found for the consumer.");
			return;
		}
		System.out.println("Consumer: " + consumerUsername);
		System.out.println("Fixed Charge: $" + bill.getFixedCharge());
		System.out.println("Units Consumed: " + bill.getUnitsConsumed());
		System.out.println("Taxes: $" + bill.getTaxes());
		System.out.println("Adjustment: $" + bill.getAdjustment());
		System.out.println("Total Amount: $" + bill.getTotalAmount());
		System.out.println("Status: " + bill.getStatus());
	}

	public void payBill(String consumerUsername, double amount) {
		Bill bill = getLatestBill(consumerUsername);
		if (bill == null) {
			System.out.println("No bill found for the consumer.");
			return;
		}
		if (bill.getStatus().equals("Paid")) {
			System.out.println("The bill has already been paid.");
			return;
		}
		if (amount < bill.getTotalAmount()) {
			System.out.println("Insufficient amount. Please pay the full bill amount: $" + bill.getTotalAmount());
			return;
		}
		double change = amount - bill.getTotalAmount();
		bill.setStatus("Paid");
		System.out.println("Bill paid successfully. Change: $" + change);
	}

	public void viewTransactionHistory(String consumerUsername) {
		List<Bill> transactionHistory = new ArrayList<>();
		for (Bill bill : bills) {
			if (bill.getConsumerUsername().equals(consumerUsername)) {
				transactionHistory.add(bill);
			}
		}
		if (transactionHistory.isEmpty()) {
			System.out.println("No transaction history found for the consumer.");
			return;
		}
		System.out.println("Consumer: " + consumerUsername);
		System.out.println("Bill\tFixed Charge\tUnits Consumed\tTaxes\tAdjustment\tTotal Amount\tStatus");
		for (Bill bill : transactionHistory) {
			System.out.println(bill.getConsumerUsername() + "\t$" + bill.getFixedCharge() + "\t\t"
					+ bill.getUnitsConsumed() + "\t\t$" + bill.getTaxes() + "\t\t$" + bill.getAdjustment() + "\t\t$"
					+ bill.getTotalAmount() + "\t\t" + bill.getStatus());
		}
	}

	public void displayAllBills() {
		if (bills.isEmpty()) {
			System.out.println("No bills found.");
			return;
		}

		for (Bill bill : bills) {
			System.out.println(bill.getBillId() + "\t" + bill.getConsumerUsername() + "\t$" + bill.getFixedCharge()
					+ "\t\t" + bill.getUnitsConsumed() + "\t\t$" + bill.getTaxes() + "\t\t$" + bill.getAdjustment()
					+ "\t\t$" + bill.getTotalAmount() + "\t\t" + bill.getStatus());
		}
	}

	public void displayPaidAndPendingBills() {
		if (bills.isEmpty()) {
			System.out.println("No bills found.");
			return;
		}

		List<Bill> paidBills = new ArrayList<>();
		List<Bill> pendingBills = new ArrayList<>();

		for (Bill bill : bills) {
			if (bill.getStatus().equals("Paid")) {
				paidBills.add(bill);
			} else if (bill.getStatus().equals("Pending")) {
				pendingBills.add(bill);
			}
		}

		System.out.println("Paid Bills:");
		if (paidBills.isEmpty()) {
			System.out.println("No paid bills found.");
		} else {
			displayBills(paidBills);
		}

		System.out.println("\nPending Bills:");
		if (pendingBills.isEmpty()) {
			System.out.println("No pending bills found.");
		} else {
			displayBills(pendingBills);
		}
	}

	private void displayBills(List<Bill> billList) {
		System.out.println("Bill\tConsumer\tFixed Charge\tUnits Consumed\tTaxes\tAdjustment\tTotal Amount\tStatus");
		for (Bill bill : billList) {
			System.out.println(bill.getBillId() + "\t" + bill.getConsumerUsername() + "\t$" + bill.getFixedCharge()
					+ "\t\t" + bill.getUnitsConsumed() + "\t\t$" + bill.getTaxes() + "\t\t$" + bill.getAdjustment()
					+ "\t\t$" + bill.getTotalAmount() + "\t\t" + bill.getStatus());
		}
	}

	public void deleteConsumer(String consumerUsername) {
		Consumer consumerToRemove = null;
		for (Consumer consumer : consumers) {
			if (consumer.getUsername().equals(consumerUsername)) {
				consumerToRemove = consumer;
				break;
			}
		}

		if (consumerToRemove == null) {
			System.out.println("Consumer not found.");
			return;
		}

		// Set the consumer's connection as inactive
		consumerToRemove.setActive(false);

		// Remove all bills associated with the consumer
		Iterator<Bill> iterator = bills.iterator();
		while (iterator.hasNext()) {
			Bill bill = iterator.next();
			if (bill.getConsumerUsername().equals(consumerUsername)) {
				iterator.remove();
			}
		}

	}

	public Bill getLatestBill(String consumerUsername) {
		Bill latestBill = null;
		for (Bill bill : bills) {
			if (bill.getConsumerUsername().equals(consumerUsername)) {
				if (latestBill == null || bill.getBillId() > latestBill.getBillId()) {
					latestBill = bill;
				}
			}
		}
		return latestBill;
	}

	public boolean adminLogin(String username, String password) {
		// Check if the provided username and password match the admin credentials
		return username.equals("admin") && password.equals("123456");
	}

}