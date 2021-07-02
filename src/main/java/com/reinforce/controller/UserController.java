package com.reinforce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.reinforce.entity.UserEntity;
import com.reinforce.proxy.service.UserProxyService;

import com.reinforce.util.Constants;

@RestController
@RequestMapping(Constants.USERS)
public class UserController {

	@Autowired
	private UserProxyService userProxyService;

	@GetMapping()
	public ResponseEntity<List<UserEntity>> users() {

		return new ResponseEntity<>(userProxyService.get(), HttpStatus.OK);
	}

	@PostMapping()
	public ResponseEntity<UserEntity> create(@RequestBody UserEntity user) {

		return new ResponseEntity<>(userProxyService.create(user), HttpStatus.CREATED);
	}

	@PutMapping
	public ResponseEntity<UserEntity> update(@RequestBody UserEntity user) {

		return new ResponseEntity<>(userProxyService.update(user), HttpStatus.OK);
	}

	@DeleteMapping
	public ResponseEntity<Void> delete(Long id) {

		userProxyService.delete(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

	@GetMapping("/{id}")
	public ResponseEntity<UserEntity> getById(@PathVariable Long id) {

		return new ResponseEntity<>(userProxyService.findById(id), HttpStatus.OK);
	}
}
