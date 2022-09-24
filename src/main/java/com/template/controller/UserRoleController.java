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

import com.template.entity.system.UserRole;
import com.template.model.Response;
import com.template.service.implementation.UserRoleServiceImpl;

import lombok.RequiredArgsConstructor;
import util.Util;

@RestController
@RequestMapping("/userRole")
@RequiredArgsConstructor
public class UserRoleController {
	private final UserRoleServiceImpl userRoleService;

	@GetMapping("/list")
	public ResponseEntity<Response> getUserRoles(){
		return ResponseEntity.ok(
				Response.builder()
						.timestamp(now())
						.data(Map.of("userRoles", userRoleService.list(Util.comboLimit)))
						.message("UserRoles retrieved")
						.status(OK)
						.statusCode(OK.value())
						.build()
		);
	}

	@PostMapping("/save")
	public ResponseEntity<Response> saveUserRole(@RequestBody @Valid UserRole userRole){
		return ResponseEntity.ok(
				Response.builder()
						.timestamp(now())
						.data(Map.of("userRole", userRoleService.create(userRole)))
						.message("Role of User created")
						.status(CREATED)
						.statusCode(CREATED.value())
						.build()
		);
	}

	@GetMapping("/get/{id}")
	public ResponseEntity<Response> getUserRole(@PathVariable("id") Long id){
		return ResponseEntity.ok(
				Response.builder()
						.timestamp(now())
						.data(Map.of("userRole", userRoleService.get(id)))
						.message("Role of User retrieved")
						.status(OK)
						.statusCode(OK.value())
						.build()
		);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Response> updateUserRole(@PathVariable("id") Long id){
		return ResponseEntity.ok(
				Response.builder()
						.timestamp(now())
						.data(Map.of("deleted", userRoleService.delete(id)))
						.message("Role of User deleted")
						.status(OK)
						.statusCode(OK.value())
						.build()
		);
	}
}
