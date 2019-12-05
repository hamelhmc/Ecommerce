package com.wirtz.ecommerce.model.orderline;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Version;

import com.wirtz.ecommerce.model.order.Order;
import com.wirtz.ecommerce.model.product.Product;
import com.wirtz.ecommerce.model.userprofile.UserProfile;

@Entity
@Table(name = "Orderlines")
public class Orderline implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = -1273395712619171885L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "orderlineId")
	private long orderlineId;

	@OneToOne
	@JoinColumn(name = "prodId")
	private Product product;

	@ManyToOne
	@JoinColumn(name = "usrId")
	private UserProfile userProfile;

	@ManyToOne
	@JoinColumn(name = "orderId")
	private Order order;

	private long quantity;

	private double price;

	@Version
	private long version;

	public Orderline() {
	}

	public long getOrderlineId() {
		return orderlineId;
	}

	public void setOrderlineId(final long orderlineId) {
		this.orderlineId = orderlineId;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(final Product product) {
		this.product = product;
	}

	public UserProfile getUserProfile() {
		return userProfile;
	}

	public void setUserProfile(final UserProfile userProfile) {
		this.userProfile = userProfile;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(final Order order) {
		this.order = order;
	}

	public long getQuantity() {
		return quantity;
	}

	public void setQuantity(final long quantity) {
		this.quantity = quantity;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(final double price) {
		this.price = price;
	}

	public long getVersion() {
		return version;
	}

	public void setVersion(final long version) {
		this.version = version;
	}

}
