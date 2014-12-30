package com.uniksoft.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.uniksoft.form.Privilege;
import com.uniksoft.form.Role;
import com.uniksoft.service.EntityFacade;

@Controller
public class RoleController {

	@SuppressWarnings("rawtypes")
	@Autowired
	private EntityFacade entityFacade;
	
	@RequestMapping(value = "/roles", method = RequestMethod.GET)
	public String listEntities(Map<String, Object> map) {
		map.put("role", new Role());
		map.put("roleList", entityFacade.listEntities(Role.class));
		map.put("privilegesMap", getPrivilegesMap());
		return "admin/role";
	}
	
	private Map<String, String> getPrivilegesMap() {
		Map<String, String> privilegeMap = new HashMap<>();
		List<Privilege> privileges = entityFacade.listEntities(Privilege.class);
		for (Privilege privilege : privileges) {
			privilegeMap.put(Integer.toString(privilege.getId()), privilege.getPrivilegeName());
		}
		return privilegeMap;
	}
}
