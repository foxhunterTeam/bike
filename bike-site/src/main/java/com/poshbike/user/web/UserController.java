package com.poshbike.user.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.poshbike.core.web.PageResult;
import com.poshbike.user.entity.User;
import com.poshbike.user.service.UserService;

@Controller
@RequestMapping("/user")
public class  UserController {
	@Autowired
	private UserService userService;

	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public PageResult<User> findAll(@RequestParam(value = "page") Integer page,
			@RequestParam(value = "limit") Integer limit) {
		PageRequest pageReq = new PageRequest(page - 1, limit);

		Page<User> users = userService.findAll(pageReq);

		return new PageResult<User>(users);
	}

	@RequestMapping(method = RequestMethod.POST)
	@ResponseBody
	public User insertUser(@RequestBody User user) {
		return this.userService.save(user);
	}


}
