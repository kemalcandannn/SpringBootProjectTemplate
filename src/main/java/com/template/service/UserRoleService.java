package com.template.service;

import java.util.Collection;

import com.template.entity.system.UserRole;

public interface UserRoleService {
	UserRole create(UserRole userRole);

	Collection<UserRole> list(int limit);
	
	UserRole get(Long id);
	
	UserRole update(UserRole userRole);
	
	Boolean delete(Long id);
}
