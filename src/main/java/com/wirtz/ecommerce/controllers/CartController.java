package com.wirtz.ecommerce.controllers;

import java.util.Set;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.wirtz.ecommerce.model.cartline.Cartline;
import com.wirtz.ecommerce.model.cartservice.CartService;
import com.wirtz.ecommerce.model.product.Product;
import com.wirtz.ecommerce.model.productservice.ProductService;
import com.wirtz.ecommerce.model.userprofile.UserProfile;
import com.wirtz.ecommerce.model.userservice.UserService;
import com.wirtz.ecommerce.model.util.Global;
import com.wirtz.ecommerce.modelutil.exceptions.InstanceNotFoundException;

@Controller
public class CartController {

	private final static String SEARCH_RESULT_VIEW = "ProductsSearchResult";
	private final static String DETAILS_RESULT_VIEW = "CartDetails";

	private final static String CARTLINE = "cartline";

	@Autowired
	CartService cartlineService;

	@Autowired
	ProductService productService;

	@Autowired
	UserService userService;

	@GetMapping("/cart")
	public String getForm(HttpSession session, Model model) throws InstanceNotFoundException {
		long userID = (long) session.getAttribute(Global.USER_PROFILE_ID);
		UserProfile userProfile;
		userProfile = userService.findUser(userID);
	
		model.addAttribute(CARTLINE, userProfile.getCartline());

		return DETAILS_RESULT_VIEW;
	}

	@GetMapping("/cart/{id}")
	public String addCartLine(@PathVariable Long id, HttpSession session) throws InstanceNotFoundException {

		Product products;
		products = productService.findProduct(id);

		long userID = (long) session.getAttribute(Global.USER_PROFILE_ID);
		UserProfile userProfile;
		userProfile = userService.findUser(userID);

		Cartline cartline = new Cartline();
		cartline.setProduct(products);
		cartline.setUserProfile(userProfile);
		cartline.setQuantity(1);
		cartlineService.addCartline(cartline);
		return SEARCH_RESULT_VIEW;
	}
}
