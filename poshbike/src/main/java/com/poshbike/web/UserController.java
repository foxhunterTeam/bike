package com.poshbike.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.poshbike.persistance.User;
import com.poshbike.persistance.UserMapper;

@Controller
public class UserController {
	
	@Autowired
	private UserMapper userMapper;
	
	@ResponseBody
	@RequestMapping(value="/users", method=RequestMethod.GET)
	public List<User>  getUsers(){
		List<User> r = new ArrayList<User>();
		User user = new User();
		user.setId(1);
		user.setUsername("Tom");
		r.add(user);
		
		User user2 = new User();
		user2.setId(2);
		user2.setUsername("Mike");
		r.add(user2);
		
		return r;
	}
	
	@ResponseBody
	@RequestMapping(value="/user/{userId}", method=RequestMethod.GET)
	public User  getUser(@PathVariable("userId") String id){
		User user = new User();
		user.setId(1);
		user.setUsername("Tom");	
		return user;
	}

}
