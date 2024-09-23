package com.infybuzz.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="roles")
@Getter
@Setter
public class Role {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@Column(name="role")
	private String role;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;

}
