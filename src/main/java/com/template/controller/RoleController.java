package com.template.controller;

import static java.time.LocalDateTime.now;
import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

import java.util.Map;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.template.entity.system.Role;
import com.template.model.Response;
import com.template.service.implementation.RoleServiceImpl;

import lombok.RequiredArgsConstructor;
import util.Util;

@RestController
@RequestMapping("/role")
@RequiredArgsConstructor
public class RoleController {
	private final RoleServiceImpl roleService;

	@GetMapping("/list")
	public ResponseEntity<Response> getRoles(){
		return ResponseEntity.ok(
				Response.builder()
						.timestamp(now())
						.data(Map.of("roles", roleService.list(Util.comboLimit)))
						.message("Roles retrieved")
						.status(OK)
						.statusCode(OK.value())
						.build()
		);
	}

	@PostMapping("/save")
	public ResponseEntity<Response> saveRole(@RequestBody @Valid Role role){
		return ResponseEntity.ok(
				Response.builder()
						.timestamp(now())
						.data(Map.of("role", roleService.create(role)))
						.message("Role created")
						.status(CREATED)
						.statusCode(CREATED.value())
						.build()
		);
	}

	@GetMapping("/get/{id}")
	public ResponseEntity<Response> getRole(@PathVariable("id") Long id){
		return ResponseEntity.ok(
				Response.builder()
						.timestamp(now())
						.data(Map.of("role", roleService.get(id)))
						.message("Role retrieved")
						.status(OK)
						.statusCode(OK.value())
						.build()
		);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Response> updateRole(@PathVariable("id") Long id){
		return ResponseEntity.ok(
				Response.builder()
						.timestamp(now())
						.data(Map.of("deleted", roleService.delete(id)))
						.message("Role deleted")
						.status(OK)
						.statusCode(OK.value())
						.build()
		);
	}
}
