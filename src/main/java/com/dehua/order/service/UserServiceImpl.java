package com.dehua.order.service;

import java.util.Iterator;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dehua.order.model.User;
import com.dehua.order.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Resource 
	private UserRepository userRepository;

	@Override
	@Transactional
	public User create(User user) {
		return userRepository.save(user);
	}
	
	@Override
	public Iterator<User> create(Iterator<User> users) {
		return null;
	}
}
