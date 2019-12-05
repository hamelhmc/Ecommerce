package com.wirtz.ecommerce.model.cartline;

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

import com.wirtz.ecommerce.model.product.Product;
import com.wirtz.ecommerce.model.userprofile.UserProfile;

@Entity
@Table(name = "Cartlines")
public class Cartline implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = -5342584187349937354L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cartlineId")
	private long cartlineId;

	@ManyToOne
	@JoinColumn(name = "usrId")
	private UserProfile userProfile;

	@OneToOne
	@JoinColumn(name = "prodId")
	private Product product;

	private long quantity;

	@Version
	private long version;

	public Cartline() {
	}

	public Cartline(final UserProfile userProfile, final Product product, final long quantity) {
		this.userProfile = userProfile;
		this.product = product;
		this.quantity = quantity;
	}

	public long getCartlineId() {
		return cartlineId;
	}

	public void setCartlineId(final long cartlineId) {
		this.cartlineId = cartlineId;
	}

	public UserProfile getUserProfile() {
		return userProfile;
	}

	public void setUserProfile(final UserProfile userProfile) {
		this.userProfile = userProfile;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(final Product product) {
		this.product = product;
	}

	public long getQuantity() {
		return quantity;
	}

	public void setQuantity(final long quantity) {
		this.quantity = quantity;
	}

	public long getVersion() {
		return version;
	}

	public void setVersion(final long version) {
		this.version = version;
	}

}
