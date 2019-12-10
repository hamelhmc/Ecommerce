package com.wirtz.ecommerce.model.cartline;

import org.springframework.stereotype.Repository;

import com.wirtz.ecommerce.model.product.Product;
import com.wirtz.ecommerce.model.product.ProductDao;
import com.wirtz.ecommerce.modelutil.dao.GenericDao;
import com.wirtz.ecommerce.modelutil.dao.GenericDaoHibernate;

@Repository
public class CartlineDaoHibernate extends GenericDaoHibernate<Cartline, Long> implements CartlineDao  {

}
