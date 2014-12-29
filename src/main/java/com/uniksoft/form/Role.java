package com.uniksoft.form;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "ROLES")
public class Role {

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "ID", unique = true, nullable = false)
	private Integer id;

	@Column(name = "ROLE_NAME", unique = true, nullable = false)
	private String roleName;

	public Role() {
	}

	public Role(String roleName) {
		this.roleName = roleName;
	}

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "ROLES_PRIVILEGES", 
	           joinColumns = { @JoinColumn(name = "ROLE_ID") }, 
	           inverseJoinColumns = { @JoinColumn(name = "PRIVILEGE_ID") })
	private Set<Privilege> privileges = new HashSet<>();

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public Set<Privilege> getPrivileges() {
		return this.privileges;
	}

	public void setPrivileges(Set<Privilege> privileges) {
		this.privileges = privileges;
	}
}
