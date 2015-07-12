package com.dehua.order.service;

import java.util.Iterator;

import com.dehua.order.model.User;

public interface UserService {
	public User create(User user);
	public Iterator<User> create(Iterator<User> users) ;
}
