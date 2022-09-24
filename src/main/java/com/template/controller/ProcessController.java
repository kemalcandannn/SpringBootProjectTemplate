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

import com.template.entity.system.Process;
import com.template.model.Response;
import com.template.service.implementation.ProcessServiceImpl;

import lombok.RequiredArgsConstructor;
import util.Util;

@RestController
@RequestMapping("/process")
@RequiredArgsConstructor
public class ProcessController {
	private final ProcessServiceImpl processService;

	@GetMapping("/list")
	public ResponseEntity<Response> getProcesses(){
		return ResponseEntity.ok(
				Response.builder()
						.timestamp(now())
						.data(Map.of("processes", processService.list(Util.comboLimit)))
						.message("Processes retrieved")
						.status(OK)
						.statusCode(OK.value())
						.build()
		);
	}

	@PostMapping("/save")
	public ResponseEntity<Response> saveProcess(@RequestBody @Valid Process process){
		return ResponseEntity.ok(
				Response.builder()
						.timestamp(now())
						.data(Map.of("process", processService.create(process)))
						.message("Process created")
						.status(CREATED)
						.statusCode(CREATED.value())
						.build()
		);
	}

	@GetMapping("/get/{id}")
	public ResponseEntity<Response> getProcess(@PathVariable("id") Long id){
		return ResponseEntity.ok(
				Response.builder()
						.timestamp(now())
						.data(Map.of("process", processService.get(id)))
						.message("Process retrieved")
						.status(OK)
						.statusCode(OK.value())
						.build()
		);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Response> updateProcess(@PathVariable("id") Long id){
		return ResponseEntity.ok(
				Response.builder()
						.timestamp(now())
						.data(Map.of("deleted", processService.delete(id)))
						.message("Process deleted")
						.status(OK)
						.statusCode(OK.value())
						.build()
		);
	}
}
