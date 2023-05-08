package com.masai;

import java.io.IOException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		System.out.println("Wewlcome to Thunder Electric Rajsthan");
		System.out.println();
		Scanner scanner = new Scanner(System.in);
		ElectricityBillSystem system = new ElectricityBillSystem();

		// Admin login
		while (true) {
			System.out.print("Enter admin username: ");
			String adminUsername = scanner.nextLine();

			System.out.print("Enter admin password: ");
			String adminPassword = scanner.nextLine();

			if (system.adminLogin(adminUsername, adminPassword)) {
				System.out.println("Admin login successful.");
				break;
			} else {
				System.out.println("Invalid username or password. Please try again.");
			}
		}

		while (true) {
			System.out.println("1. Register new consumer");
			System.out.println("2. View all consumers");
			System.out.println("3. View the bill of a consumer");
			System.out.println("4. View all bills");
			System.out.println("5. View all bills paid and pending");
			System.out.println("6. Delete consumer");
			System.out.println("7. Exit");
			System.out.print("Enter your selection");

			int choice = Integer.parseInt(scanner.nextLine());

			switch (choice) {
			case 1:
				// Register new consumer
				System.out.println("Enter first name: ");
				String firstName = scanner.nextLine();

				System.out.println("Enter last name: ");
				String lastName = scanner.nextLine();

				System.out.println("Enter address: ");
				String address = scanner.nextLine();

				System.out.println("Enter mobile number: ");
				String mobileNumber = scanner.nextLine();

				System.out.println("Enter email: ");
				String email = scanner.nextLine();

				System.out.println("Enter username: ");
				String userName = scanner.nextLine();

				System.out.println("Enter password: ");
				String passWord = scanner.nextLine();

				try {
					system.registerConsumer(userName, passWord, firstName, lastName, address, mobileNumber, email);
				} catch (InvalidDataException e) {
					System.out.println(e.getMessage());
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			case 2:
				// View all consumers
				system.displayAllConsumers();
				break;
			case 3:
				// View bill of a consumer
				System.out.println("Enter consumer username: ");
				String consumerUsername = scanner.nextLine();

				try {
					Bill bill = system.getLatestBill(consumerUsername);
					System.out.println(bill.toString());
				} catch (InvalidDataException e) {
					System.out.println(e.getMessage());
				}
				break;
			case 4:
				// View all bills
				system.displayAllBills();
				break;
			case 5:
				// View all paid and pending bills
				system.displayPaidAndPendingBills();
				break;
			case 6:
				// Delete consumer
				System.out.println("Enter consumer username: ");
				String username = scanner.nextLine();

				try {
					system.deleteConsumer(username);
					System.out.println("Consumer deleted successfully.");
				} catch (InvalidDataException e) {
					System.out.println(e.getMessage());
				}
				break;
			case 7:
				// Exit
				System.out.println("Exiting program.");
				System.exit(0);
			default:
				System.out.println("Invalid choice. Please try again.");
				break;
			}
		}
	}
}
