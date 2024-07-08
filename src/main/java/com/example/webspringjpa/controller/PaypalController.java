package com.example.webspringjpa.controller;

import com.example.webspringjpa.entity.CartItem;
import com.example.webspringjpa.entity.Order;
import com.example.webspringjpa.service.PaypalService;
import com.example.webspringjpa.service.ShoppingCart;
import com.paypal.api.payments.Links;
import com.paypal.api.payments.Payment;
import com.paypal.base.rest.PayPalRESTException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class PaypalController {

	@Autowired
	PaypalService service;
	@Autowired
	private ShoppingCart shoppingCart;
	@Autowired
	private HttpServletRequest request;

	public static final String SUCCESS_URL = "paypal/success";
	public static final String CANCEL_URL = "paypal/cancel";

	@GetMapping("/")
	public String home() {
		return "index";
	}

	@PostMapping("/pay")
	public String payment(@ModelAttribute("order") Order order) {
		try {
			Payment payment = service.createPayment(order.getPrice(), order.getCurrency(), order.getMethod(),
					order.getIntent(), order.getDescription(), "http://localhost:8080/" + CANCEL_URL,
					"http://localhost:8080/" + SUCCESS_URL);
			for(Links link:payment.getLinks()) {
				if(link.getRel().equals("approval_url")) {
					return "redirect:"+link.getHref();
				}
			}
			
		} catch (PayPalRESTException e) {
		
			e.printStackTrace();
		}
		return "redirect:/";
	}
	
	 @GetMapping(value = CANCEL_URL)
	 public String cancelPay() {
		return "paypal/cancel";
	 }

	 @GetMapping(value = SUCCESS_URL)
	 public String successPay(@RequestParam("paymentId") String paymentId, @RequestParam("PayerID") String payerId) {
		try {
			Payment payment = service.executePayment(paymentId, payerId);
			System.out.println(payment.toJSON());
			if (payment.getState().equals("approved")) {
				List<CartItem> cartItems = shoppingCart.getItems();
				HttpSession session = request.getSession();
				Long userId = (Long) session.getAttribute("userId");

				return "paypal/success";
			}
		} catch (PayPalRESTException e) {
			System.out.println(e.getMessage());
		}
		return "redirect:/";
	 }
}
