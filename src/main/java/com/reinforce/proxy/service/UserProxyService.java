package com.reinforce.proxy.service;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.reinforce.entity.UserEntity;
import com.reinforce.service.UserService;

@Component
public class UserProxyService {

	@Autowired
	private UserService userService;

	public UserEntity create(UserEntity userEntity) {
		return userService.create(userEntity);
	}

	public UserEntity update(UserEntity userEntity) {
		return userService.update(userEntity);
	}

	public List<UserEntity> get() {
		return userService.get();
	}

	public void delete(Long id) {
		userService.delete(id);
	}

	public UserEntity findById(Long id) {
		Optional<UserEntity> res = userService.findById(id);
		if (res.isPresent()) {
			return res.get();
		} else {
			throw new EntityNotFoundException("Id not found " + id);
		}
	}
}
