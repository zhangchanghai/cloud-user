package com.boot.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	@PostMapping("/getuser/{id}")
	public Object getUser2(@PathVariable Integer id,@RequestBody Map<String,Object> map){
		for(String key:map.keySet()){
			System.out.println(key+"  :  "+map.get(key));
		}
		System.out.println("port:\t"+map.get("port")+"\nlist:\t"+((ArrayList) (map.get("list"))).get(0));
		User user = new User();
		user.setId(id);
		user.setName("port : "+port);
		HashMap<Object, Object> hashMap = new HashMap<>();
		hashMap.put("user",user);
		hashMap.put("success", true);
		return hashMap;
	}
}
