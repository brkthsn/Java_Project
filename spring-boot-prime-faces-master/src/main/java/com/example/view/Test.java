//package com.example.view;
//
//import java.math.BigDecimal;
//import java.text.ParseException;
//import java.text.SimpleDateFormat;
//import java.util.Date;
//import java.util.List;
//
//import javax.faces.bean.ManagedBean;
//import javax.faces.bean.RequestScoped;
//
//import org.apache.log4j.Level;
//import org.primefaces.context.RequestContext;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//
//import com.example.model.Employee;
//import com.example.service.EmployeeService;
//
//@ManagedBean(name = "test")
//@RequestScoped
//@Controller
//public class Test {
//
//	@Autowired
//	private EmployeeService employeeService;
//
//	private int productId;
//	private String productName;
//	private BigDecimal productKrediTutar;
//	private BigDecimal productMonthValue;
//	private BigDecimal productTotalValue;
//	private String contractRemainingMonth;
//	private String churnMessage;
//
//	public List<Employee> getEmployeesList() {
//		return employeeService.getAllEmployees();
//	}
//
//	public void creditNoChange() {
//
//		if (this.getProductMonthValue() != null && this.getProductKrediTutar() != null) {
//
//			if (this.getProductKrediTutar().signum() != 0 && this.getProductMonthValue().signum() != 0) {
//
//				this.setProductTotalValue(this.getProductKrediTutar().multiply(this.getProductMonthValue()));
//			}
//		}
//	}
//
//	public void save() {
//		System.out.println("Deneme");
//		RequestContext context = RequestContext.getCurrentInstance();
//		try {
//			BigDecimal val = new BigDecimal("0");
//			if (getProductTotalValue().compareTo(val) == 1) {
//
//				Date today = new Date();
//				SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd.MM.yyyy");
//				String date = DATE_FORMAT.format(today);
//				Date dateFormatted = null;
//
//				try {
//					dateFormatted = DATE_FORMAT.parse(date);
//				} catch (ParseException e1) {
//					e1.printStackTrace();
//				}
//				java.sql.Date sqlDate = new java.sql.Date(dateFormatted.getTime());
//
//				// churnValidateContractProduct =
//				// churnOfferService.validateChurnProduct(
//				// new BigDecimal(product.getProductId()),
//				// product.getProductMonthValue(), sqlDate,
//				// product.getProductKrediTutar(), new
//				// BigDecimal(this.fesihNo));
//				// if
//				// (!churnValidateContractProduct.getChurnOfferSuccess().equalsIgnoreCase("0"))
//				// {
//				//
//				// this.churnMessage = "ISLEM DURUMU: " +
//				// churnValidateContractProduct.getChurnValidateResult();
//				// for (int i = 0; i < products.size(); i++) {
//				// if (products.get(i).getProductId() == product.getProductId()
//				// && product.getProductTotalValue().compareTo(val) == 1) {
//				// products.get(i).setProductKrediTutar(val);
//				// products.get(i).setProductMonthValue(val);
//				// products.get(i).setProductTotalValue(val);
//				// }
//				// }
//
//				context.execute("dlg1.show();");
//
//			} else {
//				this.churnMessage = "ISLEM DURUMU : " + "Basarılı bir sekilde kayıt gerceklesmistir";
//				// this.product = null;
//				// churnPreviousOffers();
//				context.execute("PF('dlg1').show()");
//			}
//			// }
//			// else {
//			// this.churnMessage = "ISLEM DURUMU : Toplam Kredi Tutarı 0 'dan
//			// buyuk olmalidir";
//			// // product = null;
//			// context.execute("dlg1.show();");
//			// }
//		} catch (Exception e) {
//			System.out.println(e.getMessage());
//			e.printStackTrace();
//			// SolarLogger.logOperation(Level.ERROR,
//			// "ApproveWaitingTasksController-Hata:" + e.getMessage() + ",
//			// StackTrace:" + e.getStackTrace());
//		}
//
//	}
//
//	public String getContractRemainingMonth() {
//		return contractRemainingMonth;
//	}
//
//	public void setContractRemainingMonth(String contractRemainingMonth) {
//		this.contractRemainingMonth = contractRemainingMonth;
//	}
//
//	public BigDecimal getProductTotalValue() {
//		return productTotalValue;
//	}
//
//	public void setProductTotalValue(BigDecimal productTotalValue) {
//		this.productTotalValue = productTotalValue;
//	}
//
//	public BigDecimal getProductMonthValue() {
//		return productMonthValue;
//	}
//
//	public void setProductMonthValue(BigDecimal productMonthValue) {
//		this.productMonthValue = productMonthValue;
//	}
//
//	public BigDecimal getProductKrediTutar() {
//		return productKrediTutar;
//	}
//
//	public void setProductKrediTutar(BigDecimal productKrediTutar) {
//		this.productKrediTutar = productKrediTutar;
//	}
//
//	public String getProductName() {
//		return productName;
//	}
//
//	public void setProductName(String productName) {
//		this.productName = productName;
//	}
//
//	public int getProductId() {
//		return productId;
//	}
//
//	public void setProductId(int productId) {
//		this.productId = productId;
//	}
//
//	public String getChurnMessage() {
//		return churnMessage;
//	}
//
//	public void setChurnMessage(String churnMessage) {
//		this.churnMessage = churnMessage;
//	}
//
//}