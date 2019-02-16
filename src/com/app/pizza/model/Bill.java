package com.app.pizza.model;

import java.util.List;

public class Bill {

	private List<BillItem> billItems;
	private Double totalBillAmount;

	public List<BillItem> getBillItems() {
		return billItems;
	}

	public void setBillItems(List<BillItem> billItems) {
		this.billItems = billItems;
	}

	public Double getTotalBillAmount() {
		return totalBillAmount;
	}

	public void setTotalBillAmount(Double totalBillAmount) {
		this.totalBillAmount = totalBillAmount;
	}

	@Override
	public String toString() {
		return "Bill [billItems=" + billItems + ", totalBillAmount=" + totalBillAmount + "]";
	}

}
