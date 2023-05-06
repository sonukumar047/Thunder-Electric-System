package com.masai;

public class Bill {
    private String consumerUsername;
    private double fixedCharge;
    private int unitsConsumed;
    private double taxes;
    private double adjustment;
    private double totalAmount;
    private String status;

    public Bill(String consumerUsername, double fixedCharge, int unitsConsumed,
                double taxes, double adjustment) {
        this.consumerUsername = consumerUsername;
        this.fixedCharge = fixedCharge;
        this.unitsConsumed = unitsConsumed;
        this.taxes = taxes;
        this.adjustment = adjustment;
        calculateTotalAmount();
        this.status = "Pending";
    }

    public String getConsumerUsername() {
        return consumerUsername;
    }

    public double getFixedCharge() {
        return fixedCharge;
    }

    public int getUnitsConsumed() {
        return unitsConsumed;
    }

    public double getTaxes() {
        return taxes;
    }

    public double getAdjustment() {
        return adjustment;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public String getStatus() {
        return status;
    }

    private void calculateTotalAmount() {
        double unitCost = 10.0;
        totalAmount = fixedCharge + (unitsConsumed * unitCost) + taxes + adjustment;
    }
}