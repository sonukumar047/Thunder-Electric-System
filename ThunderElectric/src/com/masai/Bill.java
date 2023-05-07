package com.masai;

public class Bill {
	private int billId;
	private String consumerUsername;
	private double fixedCharge;
	private int unitsConsumed;
	private double taxes;
	private double adjustment;
	private double totalAmount;
	private String status;

	public Bill(int billId, String consumerUsername, double fixedCharge, int unitsConsumed, double taxes,
			double adjustment, double totalAmount, String status) {
		super();
		this.billId = billId;
		this.consumerUsername = consumerUsername;
		this.fixedCharge = fixedCharge;
		this.unitsConsumed = unitsConsumed;
		this.taxes = taxes;
		this.adjustment = adjustment;
		this.totalAmount = totalAmount;
		this.status = status;
	}

	public int getBillId() {
		return billId;
	}

	public void setBillId(int billId) {
		this.billId = billId;
	}

	public String getConsumerUsername() {
		return consumerUsername;
	}

	public void setConsumerUsername(String consumerUsername) {
		this.consumerUsername = consumerUsername;
	}

	public double getFixedCharge() {
		return fixedCharge;
	}

	public void setFixedCharge(double fixedCharge) {
		this.fixedCharge = fixedCharge;
	}

	public int getUnitsConsumed() {
		return unitsConsumed;
	}

	public void setUnitsConsumed(int unitsConsumed) {
		this.unitsConsumed = unitsConsumed;
	}

	public double getTaxes() {
		return taxes;
	}

	public void setTaxes(double taxes) {
		this.taxes = taxes;
	}

	public double getAdjustment() {
		return adjustment;
	}

	public void setAdjustment(double adjustment) {
		this.adjustment = adjustment;
	}

	public double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	private void calculateTotalAmount() {
		double unitCost = 10.0;
		totalAmount = fixedCharge + (unitsConsumed * unitCost) + taxes + adjustment;
	}
}