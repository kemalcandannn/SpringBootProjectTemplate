package com.template.service.implementation;

import java.util.Collection;

import javax.transaction.Transactional;

import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.template.entity.system.RoleProcess;
import com.template.repository.system.RoleProcessRepository;
import com.template.service.RoleProcessService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Service
@Transactional
@Slf4j
public class RoleProcessServiceImpl implements RoleProcessService {
	private final RoleProcessRepository repository;
	
	@Override
	public RoleProcess create(RoleProcess roleProcess) {
		log.info("Saving new RoleProcess: {}", ("[roleName = '" + roleProcess.getRoleId().getName() + "', processTableName='" + roleProcess.getProcessId().getTableName() + "']"));
		return repository.save(roleProcess);
	}

	@Override
	public Collection<RoleProcess> list(int limit) {
		log.info("Fetching {} RoleProcess", limit);
		return repository.findAll(PageRequest.of(0, limit)).toList();
	}

	@Override
	public RoleProcess get(Long id) {
		log.info("Fetching RoleProcess by id: {}", id);
		return repository.findById(id).get();
	}

	@Override
	public RoleProcess update(RoleProcess roleProcess) {
		log.info("Saving new RoleProcess: {}", ("[roleName = '" + roleProcess.getRoleId().getName() + "', processTableName='" + roleProcess.getProcessId().getTableName() + "']"));
		return repository.save(roleProcess);
	}

	@Override
	public Boolean delete(Long id) {
		log.info("Updating RoleProcess by id: {}", id);
		repository.deleteById(id);
		return Boolean.TRUE;
	}
}
