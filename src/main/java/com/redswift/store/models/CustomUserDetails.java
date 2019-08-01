package com.redswift.store.models;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.redswift.store.entities.Role;
import com.redswift.store.entities.User;

public class CustomUserDetails implements UserDetails {

	/**
	 * 
	 */
	
	private String username;
	private String password;
	private Collection<? extends GrantedAuthority> authorities;
	
	private static final long serialVersionUID = 1L;

	
	public CustomUserDetails(User byUsername) {
		this.username=byUsername.getUsername();
		this.password=byUsername.getPassword();
		List<GrantedAuthority> auths =  new ArrayList<>();
		for (Role role : byUsername.getRoles()) {
			auths.add(new SimpleGrantedAuthority(role.getName().toUpperCase()));
		}
		this.authorities=auths;
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public String getUsername() {
		return username;
	}

	@Override
	public boolean isAccountNonExpired() {
		return false;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

}
