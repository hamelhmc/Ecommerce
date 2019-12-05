package com.wirtz.ecommerce.model.userprofile;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.Version;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

import com.wirtz.ecommerce.model.cartline.Cartline;
import com.wirtz.ecommerce.model.order.Order;

@Entity
@Table(name = "Users")
public class UserProfile {

	@Column(name = "usrId")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long userProfileId;

	@NotBlank(groups = { LoginUserGroupValidator.class })
	@Size(min = 4, max = 8)
	private String loginName;
	@Column(name = "enPassword")
	private String encryptedPassword;

	// Added ++19
	@NotBlank(groups = { RegisterUserGroupValidator.class, LoginUserGroupValidator.class })
	@Size(min = 4, groups = { RegisterUserGroupValidator.class })
	@Transient
	private String password;

	@NotBlank(groups = { RegisterUserGroupValidator.class })
	@Size(min = 4, groups = { RegisterUserGroupValidator.class })
	// Added ++19
	@Transient
	private String passwordConfirm;
	@NotBlank
	@Size(min = 1)
	private String firstName;
	@NotBlank
	@Size(min = 1)
	private String lastName;
	@Email
	private String email;
	@Version
	private long version;

	@OneToMany(mappedBy = "userProfile")
	private final Set<Cartline> cartline = new HashSet<Cartline>();

	@OneToMany(mappedBy = "userProfile")
	private final Set<Order> orders = new HashSet<Order>();

	public UserProfile() {
	}

	public UserProfile(final String loginName, final String encryptedPassword, final String firstName,
			final String lastName, final String email) {
		/**
		 * NOTE: "userProfileId" *must* be left as "null" since its value is
		 * automatically generated.
		 */

		this.loginName = loginName;
		this.encryptedPassword = encryptedPassword;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}

	public Set<Cartline> getCartline() {
		return cartline;
	}

	public Set<Order> getOrders() {
		return orders;
	}

	public Long getUserProfileId() {
		return userProfileId;
	}

	public void setUserProfileId(final Long userProfileId) {
		this.userProfileId = userProfileId;
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(final String loginName) {
		this.loginName = loginName;
	}

	public String getEncryptedPassword() {
		return encryptedPassword;
	}

	public void setEncryptedPassword(final String encryptedPassword) {
		this.encryptedPassword = encryptedPassword;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(final String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(final String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(final String email) {
		this.email = email;
	}

	public long getVersion() {
		return version;
	}

	public void setVersion(final long version) {
		this.version = version;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(final String password) {
		this.password = password;
	}

	public String getPasswordConfirm() {
		return passwordConfirm;
	}

	public void setPasswordConfirm(final String passwordConfirm) {
		this.passwordConfirm = passwordConfirm;
	}

	@Override
	public int hashCode() {
		return loginName == null ? 0 : loginName.hashCode();
	}

	@Override
	public boolean equals(final Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof UserProfile)) {
			return false;
		}
		final UserProfile other = (UserProfile) obj;
		if (email == null) {
			if (other.getEmail() != null) {
				return false;
			}
		} else if (!email.equals(other.getEmail())) {
			return false;
		}
		if (encryptedPassword == null) {
			if (other.getEncryptedPassword() != null) {
				return false;
			}
		} else if (!encryptedPassword.equals(other.getEncryptedPassword())) {
			return false;
		}
		if (firstName == null) {
			if (other.getFirstName() != null) {
				return false;
			}
		} else if (!firstName.equals(other.getFirstName())) {
			return false;
		}
		if (lastName == null) {
			if (other.getLastName() != null) {
				return false;
			}
		} else if (!lastName.equals(other.getLastName())) {
			return false;
		}
		if (loginName == null) {
			if (other.getLoginName() != null) {
				return false;
			}
		} else if (!loginName.equals(other.getLoginName())) {
			return false;
		}
		if (userProfileId == null) {
			if (other.getUserProfileId() != null) {
				return false;
			}
		} else if (!userProfileId.equals(other.getUserProfileId())) {
			return false;
		}
		if (version != other.getVersion()) {
			return false;
		}
		return true;
	}

}