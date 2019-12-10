package com.wirtz.ecommerce.model.cartservice;

import com.wirtz.ecommerce.modelutil.exceptions.InstanceNotFoundException;

public interface CartService {
	
	public void  addCartline(Long productId)throws InstanceNotFoundException;
}
