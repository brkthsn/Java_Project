package com.example.view;

import org.primefaces.event.SelectEvent;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.faces.model.SelectItemGroup;
import javax.faces.validator.BeanValidator;
import javax.validation.Validation;

@ManagedBean(name="basicsBean")
@RequestScoped
@Controller
public class BasicsBean {

    private Integer selectedNumber;
    private Date selectedDate;
    private Date endDate;
    

    private String[] selectedOptions;
    private String[] selectedOptions2;
    private String[] selectedCities;
    private String[] selectedCities2;
    private List<String> cities;
    private List<SelectItem> countries;
    private String[] selectedCountries;

    
  private List <Order> orderList;
    
   
    
    @PostConstruct
    public void init() {
    	
    	setOrderList(new ArrayList<>());
    	Order o1= new Order("A0001", "Intel CPU", 
                new BigDecimal("700.00"), 1);
    	
    	getOrderList().add(o1);
    	
    	Order o2= new Order("A0001", "Intel CPU", 
                new BigDecimal("700.00"), 1);
    	getOrderList().add(o2);
    	
        cities = new ArrayList<>();
        cities.add("Miami");
        cities.add("London");
        cities.add("Paris");
        cities.add("Istanbul");
        cities.add("Berlin");
        cities.add("Barcelona");
        cities.add("Rome");
        cities.add("Brasilia");
        cities.add("Amsterdam");

        countries = new ArrayList<>();
        SelectItemGroup europeCountries = new SelectItemGroup("European Countries");
        europeCountries.setSelectItems(new SelectItem[]{
                new SelectItem("Germany", "Germany"),
                new SelectItem("Turkey", "Turkey"),
                new SelectItem("Spain", "Spain")
        });

        SelectItemGroup americaCountries = new SelectItemGroup("American Countries");
        americaCountries.setSelectItems(new SelectItem[]{
                new SelectItem("United States", "United States"),
                new SelectItem("Brazil", "Brazil"),
                new SelectItem("Mexico", "Mexico")
        });

        countries.add(europeCountries);
        countries.add(americaCountries);
    }
    
    public Integer getSelectedNumber() {
        return selectedNumber;
    }

    public void setSelectedNumber(Integer selectedNumber) {
        this.selectedNumber = selectedNumber;
    }

    public Date getSelectedDate() {
        return selectedDate;
    }

    public void setSelectedDate(Date selectedDate) {
        this.selectedDate = selectedDate;
    }

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	
   

    public String[] getSelectedOptions() {
        return selectedOptions;
    }

    public void setSelectedOptions(String[] selectedOptions) {
        this.selectedOptions = selectedOptions;
    }

    public String[] getSelectedOptions2() {
        return selectedOptions2;
    }

    public void setSelectedOptions2(String[] selectedOptions2) {
        this.selectedOptions2 = selectedOptions2;
    }

    public String[] getSelectedCities() {
        return selectedCities;
    }

    public void setSelectedCities(String[] selectedCities) {
        this.selectedCities = selectedCities;
    }

    public String[] getSelectedCities2() {
        return selectedCities2;
    }

    public void setSelectedCities2(String[] selectedCities2) {
        this.selectedCities2 = selectedCities2;
    }

    public List<String> getCities() {
    	cities = new ArrayList<>();
        cities.add("Miami");
        cities.add("London");
        cities.add("Paris");
        cities.add("Istanbul");
        cities.add("Berlin");
        cities.add("Barcelona");
        cities.add("Rome");
        cities.add("Brasilia");
        cities.add("Amsterdam");
        return cities;
    }

    public void setCities(List<String> cities) {
        this.cities = cities;
    }

    public List<SelectItem> getCountries() {
        return countries;
    }

    public void setCountries(List<SelectItem> countries) {
        this.countries = countries;
    }

    public String[] getSelectedCountries() {
        return selectedCountries;
    }

    public void setSelectedCountries(String[] selectedCountries) {
        this.selectedCountries = selectedCountries;
    }

	public List <Order> getOrderList() {
		return orderList;
	}

	public void setOrderList(List <Order> orderList) {
		this.orderList = orderList;
	}
}
