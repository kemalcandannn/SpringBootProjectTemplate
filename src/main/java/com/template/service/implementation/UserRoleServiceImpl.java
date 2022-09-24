package com.template.service.implementation;

import java.util.Collection;

import javax.transaction.Transactional;

import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.template.entity.system.UserRole;
import com.template.repository.system.UserRoleRepository;
import com.template.service.UserRoleService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Service
@Transactional
@Slf4j
public class UserRoleServiceImpl implements UserRoleService {
	private final UserRoleRepository repository;
	
	@Override
	public UserRole create(UserRole userRole) {
		log.info("Saving new UserRole: {}", ("[userName = '" + userRole.getUserId().getName() + "', roleName='" + userRole.getRoleId().getName() + "']"));
		return repository.save(userRole);
	}

	@Override
	public Collection<UserRole> list(int limit) {
		log.info("Fetching {} UserRole", limit);
		return repository.findAll(PageRequest.of(0, limit)).toList();
	}

	@Override
	public UserRole get(Long id) {
		log.info("Fetching UserRole by id: {}", id);
		return repository.findById(id).get();
	}

	@Override
	public UserRole update(UserRole userRole) {
		log.info("Saving new UserRole: {}", ("[userName = '" + userRole.getUserId().getName() + "', roleName='" + userRole.getRoleId().getName() + "']"));
		return repository.save(userRole);
	}

	@Override
	public Boolean delete(Long id) {
		log.info("Updating UserRole by id: {}", id);
		repository.deleteById(id);
		return Boolean.TRUE;
	}
}
