package com.recipe.ben.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.recipe.ben.config.UserPrincipal;
import com.recipe.ben.dao.DAOuser;
import com.recipe.ben.entity.User;



//@Component
@Service
public class UserDetailsServiceImpl implements UserDetailsService {


	@Autowired
	private DAOuser DAOuser;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		User user = DAOuser.findByEmail(username);

		if (user == null) {
			throw new UsernameNotFoundException("Username '" + username + "' not found in database");
		}

		return new UserPrincipal(user);
	}

}
