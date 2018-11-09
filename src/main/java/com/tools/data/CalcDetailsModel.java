package com.tools.data;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

/**
 * This model will include the calculation details. When calculating prices and
 * discounts this model will hold all the intermediary values obtained during
 * calculus.
 * 
 * @author voicu.vac
 *
 */
public class CalcDetailsModel {

	private String jewelryBonus;
	private String marketingBonus;
	private String totalAmount;
	private String subTotal;
	private String ipPoints;
	private String totalDiscount;
	private String shipping;

	private String tax;
	private Map<String, String> segmentTotals = new HashMap<String, String>();
	private Map<String, String> calculationsList = new HashMap<String, String>();

	
	
	
	public String getShipping() {
		return shipping;
	}

	public void setShipping(String shipping) {
		this.shipping = shipping;
	}

	public String getTotalDiscount() {
		return totalDiscount;
	}

	public void setTotalDiscount(String totalDiscount) {
		this.totalDiscount = totalDiscount;
	}

	public Map<String, String> getSegmentTotals() {
		return segmentTotals;
	}

	public void setSegmentTotals(Map<String, String> segmentTotals) {
		this.segmentTotals = segmentTotals;
	}

	public Map<String, String> getCalculationsList() {
		return calculationsList;
	}

	public void setCalculationsList(Map<String, String> calculationsList) {
		this.calculationsList = calculationsList;
	}

	public String getJewelryBonus() {
		return jewelryBonus;
	}

	public String getMarketingBonus() {
		return marketingBonus;
	}

	public String getTotalAmount() {
		return totalAmount;
	}

	public String getSubTotal() {
		return subTotal;
	}

	public String getIpPoints() {
		return ipPoints;
	}

	public void addSegment(String key, String value) {
		segmentTotals.put(key, value);
	}

	public String findSegment(String key) {
		return segmentTotals.get(key);
	}

	public String calculateSegmentsTotal() {
		BigDecimal resultSum = BigDecimal.ZERO;

		for (String key : segmentTotals.keySet()) {
			resultSum = resultSum.add(BigDecimal.valueOf(Double.parseDouble(segmentTotals.get(key))));
		}

		return resultSum.toString();
	}

	public void addCalculation(String key, String value) {
		calculationsList.put(key, value);
	}

	public String findCalculation(String key) {
		return calculationsList.get(key);
	}

	public Map<String, String> getSegments() {
		return segmentTotals;
	}

	public Map<String, String> getCalculations() {
		return calculationsList;
	}

	public void setJewelryBonus(String jewelryBonus) {
		this.jewelryBonus = jewelryBonus;
	}

	public void setMarketingBonus(String marketingBonus) {
		this.marketingBonus = marketingBonus;
	}

	public void setTotalAmount(String totalAmount) {
		this.totalAmount = totalAmount;
	}

	public void setSubTotal(String subTotal) {
		this.subTotal = subTotal;
	}

	public void setIpPoints(String ipPoints) {
		this.ipPoints = ipPoints;
	}

	public String getTax() {
		return tax;
	}

	public void setTax(String tax) {
		this.tax = tax;
	}

	public void addCalculation(Map<String, String> map) {
		this.calculationsList = map;
	}

	public void addSegments(Map<String, String> map) {
		this.segmentTotals = map;
	}

	@Override
	public String toString() {
		return "CalcDetailsModel [jewelryBonus=" + jewelryBonus + ", marketingBonus=" + marketingBonus
				+ ", totalAmount=" + totalAmount + ", subTotal=" + subTotal + ", ipPoints=" + ipPoints
				+ ", totalDiscount=" + totalDiscount + ", shipping=" + shipping + ", tax=" + tax + ", segmentTotals="
				+ segmentTotals + ", calculationsList=" + calculationsList + "]";
	}

	

	
	
	
	
	
}
