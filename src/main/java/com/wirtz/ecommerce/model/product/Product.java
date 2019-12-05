package com.wirtz.ecommerce.model.product;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

import com.wirtz.ecommerce.model.util.CalendarUtil;

@Entity

public class Product implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 1681337337074255443L;
	@Column(name = "prodId")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long productId;
	private String name;
	private double price;
	private long stock;
	@Column(name = "crtDate")
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar creationDate;
	@Version
	private long version;

	public Product() {
	}

	public Product(final String name, final double price, final long stock, final Calendar creationDate) {
		/**
		 * NOTE: "productId" *must* be left as "null" since its value is automatically
		 * generated.
		 */
		// this.category = category;
		this.name = name;
		this.price = price;
		this.stock = stock;
		this.creationDate = creationDate;
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(final Long productId) {
		this.productId = productId;
	}

	public String getName() {
		return name;
	}

	public void setName(final String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(final double price) {
		this.price = price;
	}

	public long getStock() {
		return stock;
	}

	public void setStock(final long stock) {
		this.stock = stock;
	}

	public Calendar getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(final Calendar creationDate) {
		this.creationDate = creationDate;
	}

	public long getVersion() {
		return version;
	}

	public void setVersion(final long version) {
		this.version = version;
	}

	@Override
	public int hashCode() {
		return creationDate == null ? 0 : creationDate.hashCode();
	}

	@Override
	public boolean equals(final Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof Product)) {
			return false;
		}
		final Product other = (Product) obj;
		if (name == null) {
			if (other.getName() != null) {
				return false;
			}
		} else if (!name.equals(other.getName())) {
			return false;
		}
		if (Double.doubleToLongBits(price) != Double.doubleToLongBits(other.price)) {
			return false;
		}
		if (productId == null) {
			if (other.getProductId() != null) {
				return false;
			}
		} else if (!productId.equals(other.getProductId())) {
			return false;
		}
		if (stock != other.getStock()) {
			return false;
		}
		if (!(CalendarUtil.compare(creationDate, other.getCreationDate()))) {
			return false;
		}
		if (version != other.getVersion()) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "Product ID = " + getProductId() + " name = " + getName() + " price = " + getPrice() + "\n" + " stock = "
				+ getStock() + " creationDate = " + getCreationDate().toString() + " version = " + getVersion();
	}

}