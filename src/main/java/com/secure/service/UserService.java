package com.secure.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.secure.model.User;

@Service
public class UserService {
	private List<User> li = new ArrayList<>();

	public UserService() {
		li.add(new User("Dev2003", "Devesh@2003", "deveshsharma@gmail.com"));
		li.add(new User("Him2008", "Himanshu@2003", "himanshu98@gmail.com"));
		li.add(new User("Rav2004", "Ravinder@2004", "Ravi56@gmail.com"));
		li.add(new User("Deep2001", "Deepak@2001", "deepak34@gmail.com"));
		li.add(new User("Sur2000", "Surya@2000", "surya675@gmail.com"));
		li.add(new User("Jay2002", "jaiSur@2002", "jaisurya456@gmail.com"));
		li.add(new User("Rita2000", "Ritay@2000", "RitaS28@gmail.com"));
	}

	public List<User> getAllUser() {
		return this.li;
	}

	public User getUser(String username) {
		return this.li.stream().filter((user) -> user.getUsername().equals(username)).findAny().orElse(null);
	}

	public User addUser(User user) {
		this.li.add(user);
		return user;
	}

	public List<User> deleteUser (String username) {
		List<User> filteredList = li.stream().filter((user) -> !user.getUsername().equals(username))
				.collect(Collectors.toList());
		li.clear();
		li.addAll(filteredList);
		return li;
	}

}
