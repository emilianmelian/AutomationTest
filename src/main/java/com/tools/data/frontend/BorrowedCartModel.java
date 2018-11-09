package com.tools.data.frontend;

public class BorrowedCartModel {

	private String name;
	private String prodCode;
	private String unitPrice;
	private String finalPrice;
	private String ipPoints;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getProdCode() {
		return prodCode;
	}

	public void setProdCode(String prodCode) {
		this.prodCode = prodCode;
	}

	public String getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(String unitPrice) {
		this.unitPrice = unitPrice;
	}

	public String getFinalPrice() {
		return finalPrice;
	}

	public void setFinalPrice(String finalPrice) {
		this.finalPrice = finalPrice;
	}

	public String getIpPoints() {
		return ipPoints;
	}

	public void setIpPoints(String ipPoints) {
		this.ipPoints = ipPoints;
	}

	@Override
	public String toString() {
		return "BorrowedCartModel [name=" + name + ", prodCode=" + prodCode + ", unitPrice=" + unitPrice
				+ ", finalPrice=" + finalPrice + ", ipPoints=" + ipPoints + "]";
	}

}
