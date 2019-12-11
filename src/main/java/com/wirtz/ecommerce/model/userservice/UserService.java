package com.wirtz.ecommerce.model.userservice;

import com.wirtz.ecommerce.model.cartline.Cartline;
import com.wirtz.ecommerce.model.product.Product;
import com.wirtz.ecommerce.model.userprofile.UserProfile;
import com.wirtz.ecommerce.modelutil.exceptions.DuplicateInstanceException;
import com.wirtz.ecommerce.modelutil.exceptions.InstanceNotFoundException;
import com.wirtz.ecommerce.modelutil.exceptions.PasswordMissmatchException;


public interface UserService {
	public Long registerUser(String loginName, String clearPassword,
			String confirmPassword,
			UserProfileDetails userProfileDetails)
	throws DuplicateInstanceException, PasswordMissmatchException;

	public LoginResult login(String loginName, String password,
			boolean passwordIsEncrypted) throws InstanceNotFoundException,
			IncorrectPasswordException;

	public UserProfileDetails findUserProfileDetails(Long userProfileId)
	throws InstanceNotFoundException;


	public UserProfile findUser(Long userProfileId)throws InstanceNotFoundException;
	
	public void  updateUserProfile(UserProfile userProfile)throws InstanceNotFoundException;

}
