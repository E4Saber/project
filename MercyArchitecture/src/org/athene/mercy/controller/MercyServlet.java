package org.athene.mercy.controller;

import org.athene.mercy.annotation.Action;
import org.athene.mercy.annotation.Controller;
import org.athene.mercy.bean.View;

/**
 * 
 * @author 850030121
 *
 */
@Controller
public class MercyServlet {

	@Action("get:/")
	private View doWelcomePage() {
		return new View("index.jsp");
	}
	
	@Action("get:/createcustomerPage")
	private View docreatecustomerPage() {
		return new View("createcustomer.jsp");
	}
	
}
