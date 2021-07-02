package com.reinforce.service;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reinforce.entity.UserEntity;
import com.reinforce.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	public UserEntity create(UserEntity userEntity) {
		return userRepository.save(userEntity);
	}

	public UserEntity update(UserEntity userEntity) {
		return userRepository.save(userEntity);
	}

	public List<UserEntity> get() {
		return userRepository.findAll();
	}

	public void delete(Long id) {

		Optional<UserEntity> oldUserEntity = findById(id);

		if (oldUserEntity.isPresent()) {
			userRepository.deleteById(id);
		} else {
			throw new EntityNotFoundException("Id Not Found " + id);
		}
	}

	public Optional<UserEntity> findById(Long id) {
		return userRepository.findById(id);
	}
}
