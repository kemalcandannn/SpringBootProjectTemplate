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

import com.template.entity.system.RoleProcess;
import com.template.model.Response;
import com.template.service.implementation.RoleProcessServiceImpl;

import lombok.RequiredArgsConstructor;
import util.Util;

@RestController
@RequestMapping("/roleProcess")
@RequiredArgsConstructor
public class RoleProcessController {
	private final RoleProcessServiceImpl roleProcessService;

	@GetMapping("/list")
	public ResponseEntity<Response> getRoleProcesses(){
		return ResponseEntity.ok(
				Response.builder()
						.timestamp(now())
						.data(Map.of("roleProcesses", roleProcessService.list(Util.comboLimit)))
						.message("RoleProcesses retrieved")
						.status(OK)
						.statusCode(OK.value())
						.build()
		);
	}

	@PostMapping("/save")
	public ResponseEntity<Response> saveRoleProcess(@RequestBody @Valid RoleProcess roleProcess){
		return ResponseEntity.ok(
				Response.builder()
						.timestamp(now())
						.data(Map.of("roleProcess", roleProcessService.create(roleProcess)))
						.message("Process of Role created")
						.status(CREATED)
						.statusCode(CREATED.value())
						.build()
		);
	}

	@GetMapping("/get/{id}")
	public ResponseEntity<Response> getRoleProcess(@PathVariable("id") Long id){
		return ResponseEntity.ok(
				Response.builder()
						.timestamp(now())
						.data(Map.of("roleProcess", roleProcessService.get(id)))
						.message("Process of Role retrieved")
						.status(OK)
						.statusCode(OK.value())
						.build()
		);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Response> updateRoleProcess(@PathVariable("id") Long id){
		return ResponseEntity.ok(
				Response.builder()
						.timestamp(now())
						.data(Map.of("deleted", roleProcessService.delete(id)))
						.message("Process of Role deleted")
						.status(OK)
						.statusCode(OK.value())
						.build()
		);
	}
}
