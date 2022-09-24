package com.template.service;

import java.util.Collection;

import com.template.entity.system.Role;

public interface RoleService {
	Role create(Role role);

	Collection<Role> list(int limit);
	
	Role get(Long id);
	
	Role update(Role role);
	
	Boolean delete(Long id);
}
