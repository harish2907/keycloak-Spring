package com.infybuzz.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="users")
@Getter
@Setter
public class User {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@Column(name="first_name")
	private String first_name;
	private String last_name;
	private String email;
	private String username;
	private String password;
	
	@OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
	private Set<Role> role;
	

}
