package com.template.service;

import java.util.Collection;

import com.template.entity.system.UserProcess;

public interface UserProcessService {
	UserProcess create(UserProcess userProcess);

	Collection<UserProcess> list(int limit);
	
	UserProcess get(Long id);
	
	UserProcess update(UserProcess userProcess);
	
	Boolean delete(Long id);
}
