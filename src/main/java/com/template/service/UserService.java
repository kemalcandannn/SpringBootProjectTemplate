package com.template.service;

import java.util.Collection;

import com.template.entity.system.User;

public interface UserService {
	User create(User user);

	Collection<User> list(int limit);
	
	User get(Long id);
	
	User update(User user);
	
	Boolean delete(Long id);
}
