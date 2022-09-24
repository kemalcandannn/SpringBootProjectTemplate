package com.template.service;

import java.util.Collection;

import com.template.entity.system.Process;

public interface ProcessService {
	Process create(Process process);

	Collection<Process> list(int limit);
	
	Process get(Long id);
	
	Process update(Process process);
	
	Boolean delete(Long id);
}
