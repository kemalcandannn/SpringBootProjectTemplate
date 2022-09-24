package com.template.service;

import java.util.Collection;

import com.template.entity.system.RoleProcess;

public interface RoleProcessService {
	RoleProcess create(RoleProcess roleProcess);

	Collection<RoleProcess> list(int limit);
	
	RoleProcess get(Long id);
	
	RoleProcess update(RoleProcess roleProcess);
	
	Boolean delete(Long id);
}
