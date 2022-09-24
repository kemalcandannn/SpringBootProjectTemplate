package com.template.service.implementation;

import java.util.Collection;

import javax.transaction.Transactional;

import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.template.entity.system.Process;
import com.template.repository.system.ProcessRepository;
import com.template.service.ProcessService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Service
@Transactional
@Slf4j
public class ProcessServiceImpl implements ProcessService {
	private final ProcessRepository repository;
	
	@Override
	public Process create(Process process) {
		log.info("Saving new Process: {}", process.getName());
		return repository.save(process);
	}

	@Override
	public Collection<Process> list(int limit) {
		log.info("Fetching {} Process", limit);
		return repository.findAll(PageRequest.of(0, limit)).toList();
	}

	@Override
	public Process get(Long id) {
		log.info("Fetching Process by id: {}", id);
		return repository.findById(id).get();
	}

	@Override
	public Process update(Process process) {
		log.info("Updating Process: {}", process.getName());
		return repository.save(process);
	}

	@Override
	public Boolean delete(Long id) {
		log.info("Updating Process by id: {}", id);
		repository.deleteById(id);
		return Boolean.TRUE;
	}
}
