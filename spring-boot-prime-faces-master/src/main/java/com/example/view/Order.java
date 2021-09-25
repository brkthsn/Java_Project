package com.example.view;

import java.math.BigDecimal;

public class Order {

	 private String orderNo;
     private String productName;
     private BigDecimal price;
     private int qty;

     public Order(String orderNo, String productName, 
                             BigDecimal price, int qty) {

         this.setOrderNo(orderNo);
         this.setProductName(productName);
         this.setPrice(price);
         this.setQty(qty);
     }

	public String getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

}
