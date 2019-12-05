package com.wirtz.ecommerce.model.order;

import java.io.Serializable;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

import com.wirtz.ecommerce.model.orderline.Orderline;
import com.wirtz.ecommerce.model.userprofile.UserProfile;

@Entity
@Table(name = "Orders")
public class Order implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 7897940257027322024L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "orderId")
	private long orderId;

	@Column(name = "orderDate")
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar orderDate;

	@OneToMany(mappedBy = "order")
	private final Set<Orderline> orderline = new HashSet<>();

	@ManyToOne
	@JoinColumn(name = "usrId")
	private UserProfile userProfile;

	@Version
	private long version;

	public Order() {

	}

	public long getOrderId() {
		return orderId;
	}

	public void setOrderId(final long orderId) {
		this.orderId = orderId;
	}

	public Calendar getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(final Calendar orderDate) {
		this.orderDate = orderDate;
	}

	public UserProfile getUserProfile() {
		return userProfile;
	}

	public void setUserProfile(final UserProfile userProfile) {
		this.userProfile = userProfile;
	}

	public long getVersion() {
		return version;
	}

	public void setVersion(final long version) {
		this.version = version;
	}

	public Set<Orderline> getOrderline() {
		return orderline;
	}

}
