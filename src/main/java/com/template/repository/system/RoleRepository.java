package com.template.repository.system;

import org.springframework.data.jpa.repository.JpaRepository;

import com.template.entity.system.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
}
