package com.template.service.implementation;

import java.util.Collection;

import javax.transaction.Transactional;

import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.template.entity.system.UserProcess;
import com.template.repository.system.UserProcessRepository;
import com.template.service.UserProcessService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Service
@Transactional
@Slf4j
public class UserProcessServiceImpl implements UserProcessService {
	private final UserProcessRepository repository;
	
	@Override
	public UserProcess create(UserProcess userProcess) {
		log.info("Saving new UserProcess: {}", ("[userName = '" + userProcess.getUserId().getName() + "', processTableName='" + userProcess.getProcessId().getTableName() + "']"));
		return repository.save(userProcess);
	}

	@Override
	public Collection<UserProcess> list(int limit) {
		log.info("Fetching {} UserProcess", limit);
		return repository.findAll(PageRequest.of(0, limit)).toList();
	}

	@Override
	public UserProcess get(Long id) {
		log.info("Fetching UserProcess by id: {}", id);
		return repository.findById(id).get();
	}

	@Override
	public UserProcess update(UserProcess userProcess) {
		log.info("Saving new UserProcess: {}", ("[userName = '" + userProcess.getUserId().getName() + "', processTableName='" + userProcess.getProcessId().getTableName() + "']"));
		return repository.save(userProcess);
	}

	@Override
	public Boolean delete(Long id) {
		log.info("Updating UserProcess by id: {}", id);
		repository.deleteById(id);
		return Boolean.TRUE;
	}
}
