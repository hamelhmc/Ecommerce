package com.wirtz.ecommerce.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.wirtz.ecommerce.model.cartline.Cartline;
import com.wirtz.ecommerce.model.cartservice.CartService;
import com.wirtz.ecommerce.model.product.Product;
import com.wirtz.ecommerce.model.productservice.ProductService;
import com.wirtz.ecommerce.model.userprofile.UserProfile;
import com.wirtz.ecommerce.model.util.Global;
import com.wirtz.ecommerce.modelutil.exceptions.InstanceNotFoundException;

@Controller
public class CartController {
	private final static String SEARCH_PRODUCTS_VIEW = "ProductsSearch";
	private final static String SEARCH_RESULT_VIEW = "ProductsSearchResult";
	private final static String DETAILS_RESULT_VIEW = "ProductDetails";

	private final static String PRODUCTS_ATT = "block";

	private final static String PRODUCTS_SEARCH_URL_PATTERN = "/products/search/%d/%d?keyWords=%s";
	
	@Autowired
	CartService cartlineService;
	
	@Autowired
	ProductService productService;
	
	@Autowired
	UserProfile userProfile;
	
	@GetMapping("/cart/{id}")
	public String addCartLine(@PathVariable Long id, HttpSession session ) throws InstanceNotFoundException {
	Product products;
	products = productService.findProduct(id);
	long  userID = 	(long) session.getAttribute(Global.USER_PROFILE_ID);
	Cartline cartline = new Cartline();
	
	return null;

	}
}
