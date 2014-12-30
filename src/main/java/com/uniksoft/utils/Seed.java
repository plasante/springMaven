package com.uniksoft.utils;

import java.util.HashSet;
import java.util.Set;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;

import com.uniksoft.form.Privilege;
import com.uniksoft.form.Role;
import com.uniksoft.service.EntityFacade;

public class Seed {

	/**
	 * EntityService will be injected by Spring
	 */
	@SuppressWarnings("rawtypes")
	@Autowired
	private EntityFacade entityService;
	
	@PostConstruct
	public void init() {
		System.out.println("*** seeding the db");
		populateRolePrivilege();
	}
	
	@SuppressWarnings("unchecked")
	private void populateRolePrivilege() {
		System.out.println("***** Populating ROLES and PRIVILEGES tables");
		Role role1 = new Role("admin");
		Role role2 = new Role("user");
		Role role3 = new Role("guest");
		
		Privilege priv1 = new Privilege("create");
		Privilege priv2 = new Privilege("edit");
		Privilege priv3 = new Privilege("delete");
		Privilege priv4 = new Privilege("view");
		
		entityService.addEntity(role1);
		entityService.addEntity(role2);
		entityService.addEntity(role3);
		
		entityService.addEntity(priv1);
		entityService.addEntity(priv2);
		entityService.addEntity(priv3);
		entityService.addEntity(priv4);
		
		Set<Privilege> privileges = new HashSet<>();
		privileges.add(priv1);
		privileges.add(priv2);
		privileges.add(priv3);
		privileges.add(priv4);
		role1.setPrivileges(privileges);
		entityService.updateEntity(role1);
	}
}
