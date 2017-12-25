package com.boot.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.boot.bean.User;

@RestController
public class UserController {
	@Value("${server.port}")
	private String port ;
	@GetMapping("/getuser/{id}")
	public Object getUser(@PathVariable Integer id){
		User user = new User();
		user.setId(id);
		user.setName("port : "+port);
		HashMap<Object, Object> hashMap = new HashMap<>();
		hashMap.put("user",user);
		hashMap.put("success", true);
		return hashMap;
	}
}
