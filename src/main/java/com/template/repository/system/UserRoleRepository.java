package com.template.repository.system;

import org.springframework.data.jpa.repository.JpaRepository;

import com.template.entity.system.UserRole;

public interface UserRoleRepository extends JpaRepository<UserRole, Long> {
}
