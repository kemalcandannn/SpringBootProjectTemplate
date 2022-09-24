package com.template.repository.system;

import org.springframework.data.jpa.repository.JpaRepository;

import com.template.entity.system.Process;

public interface ProcessRepository extends JpaRepository<Process, Long> {
}
