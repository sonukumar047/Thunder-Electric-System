package com.masai;

import java.util.*;

interface Bill {
    public void calculateBill();
}

class Consumer implements Bill {
    private String firstName;
    private String lastName;
    private String address;
    private String mobileNumber;
    private String email;
    private String username;
    private String password;
    private boolean isActive;
    private double fixedCharge = 100.0;
    private double unitCharge = 10.0;
    private double taxRate = 0.025;
    private double adjustment;
    private double totalBill;

    public Consumer(String firstName, String lastName, String address, String mobileNumber, String email, String username, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.mobileNumber = mobileNumber;
        this.email = email;
        this.username = username;
        this.password = password;
        this.isActive = true;
    }

    public String getFullName() {
        return this.firstName + " " + this.lastName;
    }

    public String getUsername() {
        return this.username;
    }

    public String getPassword() {
        return this.password;
    }

    public boolean isActive() {
        return this.isActive;
    }

    public void deactivate() {
        this.isActive = false;
    }

    public void calculateBill() {
        // Bill cycle is from 1st of every month to last day of the month
        int daysInMonth = Calendar.getInstance().getActualMaximum(Calendar.DAY_OF_MONTH);
        double unitsConsumed = 100.0; // For demo purposes, assuming 100 units consumed
        double energyCharge = unitsConsumed * this.unitCharge;
        double taxAmount = energyCharge * this.taxRate;
        this.totalBill = this.fixedCharge + energyCharge + taxAmount + this.adjustment;
    }

    public double getTotalBill() {
        return this.totalBill;
    }

    public void setAdjustment(double adjustment) {
        this.adjustment = adjustment;
    }
}
