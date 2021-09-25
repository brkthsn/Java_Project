package com.example.view;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import org.springframework.stereotype.Controller;

 
@ManagedBean(name="order")
@RequestScoped
@Controller
public class OrderBean {


    private List <Order> orderList;
    
    @PostConstruct
    public void init() {
    	orderList=new ArrayList<>();
    	Order o1= new Order("A0001", "Intel CPU", 
                new BigDecimal("700.00"), 1);
    	
    	orderList.add(o1);
    	
    	Order o2= new Order("A0001", "Intel CPU", 
                new BigDecimal("700.00"), 1);
    	orderList.add(o2);
    	

    }
   

	public List <Order> getOrderList() {
		return orderList;
	}


	public void setOrderList(List <Order> orderList) {
		this.orderList = orderList;
	}


	
}