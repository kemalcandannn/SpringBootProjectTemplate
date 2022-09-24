package com.template.service.implementation;

import java.util.Collection;

import javax.transaction.Transactional;

import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.template.entity.system.User;
import com.template.repository.system.UserRepository;
import com.template.service.UserService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Service
@Transactional
@Slf4j
public class UserServiceImpl implements UserService {
	private final UserRepository repository;
	
	@Override
	public User create(User user) {
		log.info("Saving new User: {}", user.getName());
		return repository.save(user);
	}

	@Override
	public Collection<User> list(int limit) {
		log.info("Fetching {} User", limit);
		return repository.findAll(PageRequest.of(0, limit)).toList();
	}

	@Override
	public User get(Long id) {
		log.info("Fetching User by id: {}", id);
		return repository.findById(id).get();
	}

	@Override
	public User update(User user) {
		log.info("Updating User: {}", user.getName());
		return repository.save(user);
	}

	@Override
	public Boolean delete(Long id) {
		log.info("Updating User by id: {}", id);
		repository.deleteById(id);
		return Boolean.TRUE;
	}
}
