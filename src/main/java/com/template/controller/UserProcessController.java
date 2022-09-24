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

import com.template.entity.system.UserProcess;
import com.template.model.Response;
import com.template.service.implementation.UserProcessServiceImpl;

import lombok.RequiredArgsConstructor;
import util.Util;

@RestController
@RequestMapping("/userProcess")
@RequiredArgsConstructor
public class UserProcessController {
	private final UserProcessServiceImpl userProcessService;

	@GetMapping("/list")
	public ResponseEntity<Response> getUserProcesses(){
		return ResponseEntity.ok(
				Response.builder()
						.timestamp(now())
						.data(Map.of("userProcesses", userProcessService.list(Util.comboLimit)))
						.message("UserProcesses retrieved")
						.status(OK)
						.statusCode(OK.value())
						.build()
		);
	}

	@PostMapping("/save")
	public ResponseEntity<Response> saveUserProcess(@RequestBody @Valid UserProcess userProcess){
		return ResponseEntity.ok(
				Response.builder()
						.timestamp(now())
						.data(Map.of("userProcess", userProcessService.create(userProcess)))
						.message("Process of User created")
						.status(CREATED)
						.statusCode(CREATED.value())
						.build()
		);
	}

	@GetMapping("/get/{id}")
	public ResponseEntity<Response> getUserProcess(@PathVariable("id") Long id){
		return ResponseEntity.ok(
				Response.builder()
						.timestamp(now())
						.data(Map.of("userProcess", userProcessService.get(id)))
						.message("Process of User retrieved")
						.status(OK)
						.statusCode(OK.value())
						.build()
		);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Response> updateUserProcess(@PathVariable("id") Long id){
		return ResponseEntity.ok(
				Response.builder()
						.timestamp(now())
						.data(Map.of("deleted", userProcessService.delete(id)))
						.message("Process of User deleted")
						.status(OK)
						.statusCode(OK.value())
						.build()
		);
	}
}
