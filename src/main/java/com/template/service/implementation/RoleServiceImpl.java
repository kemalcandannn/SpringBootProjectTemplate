package com.template.service.implementation;

import java.util.Collection;

import javax.transaction.Transactional;

import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.template.entity.system.Role;
import com.template.repository.system.RoleRepository;
import com.template.service.RoleService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Service
@Transactional
@Slf4j
public class RoleServiceImpl implements RoleService {
	private final RoleRepository repository;
	
	@Override
	public Role create(Role role) {
		log.info("Saving new Role: {}", role.getName());
		return repository.save(role);
	}

	@Override
	public Collection<Role> list(int limit) {
		log.info("Fetching {} Role", limit);
		return repository.findAll(PageRequest.of(0, limit)).toList();
	}

	@Override
	public Role get(Long id) {
		log.info("Fetching Role by id: {}", id);
		return repository.findById(id).get();
	}

	@Override
	public Role update(Role role) {
		log.info("Updating Role: {}", role.getName());
		return repository.save(role);
	}

	@Override
	public Boolean delete(Long id) {
		log.info("Updating Role by id: {}", id);
		repository.deleteById(id);
		return Boolean.TRUE;
	}
}
