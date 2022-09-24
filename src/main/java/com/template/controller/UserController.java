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

import com.template.entity.system.User;
import com.template.model.Response;
import com.template.service.implementation.UserServiceImpl;

import lombok.RequiredArgsConstructor;
import util.Util;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
	private final UserServiceImpl userService;

	@GetMapping("/list")
	public ResponseEntity<Response> getUsers(){
		return ResponseEntity.ok(
				Response.builder()
						.timestamp(now())
						.data(Map.of("users", userService.list(Util.comboLimit)))
						.message("Users retrieved")
						.status(OK)
						.statusCode(OK.value())
						.build()
		);
	}

	@PostMapping("/save")
	public ResponseEntity<Response> saveUser(@RequestBody @Valid User user){
		if(user.getId() != null) {
			User userFromDB = userService.get(user.getId());
			userFromDB.setBirthday(Util.notEmpty(user.getBirthday()) ? user.getBirthday() : userFromDB.getBirthday());
			userFromDB.setName(Util.notEmpty(user.getName()) ? user.getName() : userFromDB.getName());
			userFromDB.setUsername(Util.notEmpty(user.getUsername()) ? user.getUsername() : userFromDB.getUsername());
			
			user = userFromDB;
		}
		return ResponseEntity.ok(
				Response.builder()
						.timestamp(now())
						.data(Map.of("user", userService.create(user)))
						.message("User created")
						.status(CREATED)
						.statusCode(CREATED.value())
						.build()
		);
	}

	@GetMapping("/get/{id}")
	public ResponseEntity<Response> getUser(@PathVariable("id") Long id){
		return ResponseEntity.ok(
				Response.builder()
						.timestamp(now())
						.data(Map.of("user", userService.get(id)))
						.message("User retrieved")
						.status(OK)
						.statusCode(OK.value())
						.build()
		);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Response> updateUser(@PathVariable("id") Long id){
		return ResponseEntity.ok(
				Response.builder()
						.timestamp(now())
						.data(Map.of("deleted", userService.delete(id)))
						.message("User deleted")
						.status(OK)
						.statusCode(OK.value())
						.build()
		);
	}
}
