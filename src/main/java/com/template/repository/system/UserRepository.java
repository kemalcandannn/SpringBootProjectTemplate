package com.template.repository.system;

import org.springframework.data.jpa.repository.JpaRepository;

import com.template.entity.system.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
