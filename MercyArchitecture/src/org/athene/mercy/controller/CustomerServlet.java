package org.athene.mercy.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServlet;

import org.athene.mercy.annotation.Action;
import org.athene.mercy.annotation.Controller;
import org.athene.mercy.annotation.Inject;
import org.athene.mercy.bean.Data;
import org.athene.mercy.bean.FileParam;
import org.athene.mercy.bean.Param;
import org.athene.mercy.bean.View;
import org.athene.mercy.model.Customer;
import org.athene.mercy.service.CustomerService;

/**
 * 客户列表
 * @author 850030121
 *
 */
@Controller
public class CustomerServlet extends HttpServlet {

	private static final long serialVersionUID = -4967092653247384584L;
	
	@Inject
	private CustomerService customerService;

	
	@Action("get:/customer")
	private Object doCustomerView() {
		List<Customer> customerList = customerService.getCustomerList();
		return new View("customer.jsp").addModel("customerList", customerList);
	}
	
	@Action("get:/toJson")
	private Object doJsonStr() {
		return new Data("I Love You!");
	}
	
	@Action("post:/createCustomer")
	private  Object createCustomer(Param param) {
		Map<String, Object> fieldMap = param.getFieldMap();
		FileParam fileParam = param.getFile("file");
		if(customerService.createCustomer(fieldMap, fileParam)) {
			List<Customer> customerList = customerService.getCustomerList();
			return new View("customer.jsp").addModel("customerList", customerList);
		}
		return new View("index.jsp");
	}
}
