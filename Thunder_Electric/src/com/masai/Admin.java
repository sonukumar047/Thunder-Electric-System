package com.masai;

class Admin {
    private String username;
    private String password;
    private List<Consumer> consumers;

    public Admin(String username, String password) {
        this.username = username;
        this.password = password;
        this.consumers = new ArrayList<>();
    }

    public boolean authenticate(String username, String password) {
        return this.username.equals(username) && this.password.equals(password);
    }

    public void registerConsumer(String firstName, String lastName, String address, String mobileNumber, String email, String username, String password) {
        Consumer consumer = new Consumer(firstName, lastName, address, mobileNumber, email, username, password);
        this.consumers.add(consumer);
        System.out.println("Consumer " + consumer.getFullName() + " registered successfully.");
    }

    public void viewAllConsumers() {
        for (Consumer consumer : this.consumers) {
            System.out.println(consumer.getFullName() + " (" + consumer.getUsername() + ")");
        }
    }

    public void viewConsumerBill(String username) {
        Consumer consumer = this.findConsumerByUsername(username);
        if (consumer != null) {
            consumer.calculateBill();
            System.out.println("Total bill for " + consumer.getFullName() + ": " + consumer.getTotalBill());
        } else {
            System.out.println("Consumer with username " + username + " not found.");
        }
    }

    public void viewAllBills() {
        for (Consumer consumer : this.consumers) {
            consumer.calculateBill();
            System.out.println(consumer.getFullName() + " (" + consumer.getUsername() + "): " + consumer.getTotalBill());
        }
    }

    public void viewBillsPaidAndPending() {
        int billsPaid = 0;
        int billsPending = 0;
        for (Consumer consumer : this.consumers) {
            if (consumer.isActive()) {
                consumer.calculateBill();
                if (consumer.getTotalBill() > 0) {
                    billsPending++;
                } else {
                    billsPaid++;
                }
            }
        }
        System.out.println("Bills paid: " + billsPaid);
        System.out.println("Bills pending: " + billsPending);
    }

    public void deleteConsumer(String username) {
        Consumer consumer = this.findConsumerByUsername(username);
        if (consumer != null) {
            consumer.deactivate();
            System.out.println("Consumer " + consumer.getFullName() + " deleted successfully.");
        } else {
            System.out.println("Consumer with username " + username + " not found.");
        }
    }

    private Consumer findConsumerByUsername(String username) {
        for (Consumer consumer : this.consumers) {
            if (consumer.getUsername().equals(username)) {
                return consumer;
            }
        }
        return null;
    }
}

