package com.wirtz.ecommerce.model.cartservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wirtz.ecommerce.model.cartline.Cartline;
import com.wirtz.ecommerce.model.cartline.CartlineDao;
import com.wirtz.ecommerce.modelutil.exceptions.InstanceNotFoundException;

@Service
@Transactional
public class CartServiceImpl implements CartService {

	
	@Autowired
	private CartlineDao cartlineDao;

	@Transactional(readOnly = true)
	public void addCartline(Cartline cartline) throws InstanceNotFoundException {
		cartlineDao.create(cartline);
	}

}
