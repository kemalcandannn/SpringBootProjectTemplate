package com.template.repository.system;

import org.springframework.data.jpa.repository.JpaRepository;

import com.template.entity.system.UserProcess;

public interface UserProcessRepository extends JpaRepository<UserProcess, Long> {
}
