package com.example.pgfinder.models;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Entity
@Table(name = "user")
public class User implements UserDetails 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long user_id;
	
	@Column(nullable=false)
	private String user_name;
	
	@Column(nullable=false)
	private String password;
	
	@Column(nullable=false)
	private String user_firstName;
	
	@Column(nullable=false)
	private String user_lastName;
	
	@Column(nullable=false)
	private String user_email;
	
	@Column(nullable=false)
	private String user_phone_no;
	
	public User() {
		super();
	}
	
	public User(String user_name, String password, String user_firstName, String user_lastName, String user_email,
			String user_phone_no) {
		super();
		this.user_name = user_name;
		this.password = password;
		this.user_firstName = user_firstName;
		this.user_lastName = user_lastName;
		this.user_email = user_email;
		this.user_phone_no = user_phone_no;
	}
	
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinTable(name = "user_role", 
	joinColumns = @JoinColumn(name = "user", referencedColumnName = "user_id"),
	inverseJoinColumns = @JoinColumn(name = "role", referencedColumnName = "role_id")
	
	)
	
	private Set<Role> roles = new HashSet<>();
	
	public long getUser_id() {
		return user_id;
	}
	public void setUser_id(long user_id) {
		this.user_id = user_id;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUser_firstName() {
		return user_firstName;
	}
	public void setUser_firstName(String user_firstName) {
		this.user_firstName = user_firstName;
	}
	public String getUser_lastName() {
		return user_lastName;
	}
	public void setUser_lastName(String user_lastName) {
		this.user_lastName = user_lastName;
	}
	public String getUser_email() {
		return user_email;
	}
	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}
	public String getUser_phone_no() {
		return user_phone_no;
	}
	public void setUser_phone_no(String user_phone_no) {
		this.user_phone_no = user_phone_no;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<SimpleGrantedAuthority> authories = this.roles.stream().map((role)-> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
		
		return authories;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return this.user_name;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
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
