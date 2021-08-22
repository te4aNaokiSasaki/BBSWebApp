package com.te4a.springboot.web.controller;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.te4a.springboot.domain.entity.User;
import com.te4a.springboot.domain.repository.UserRepository;

@Controller
public class UserController {
	
	@Autowired
	UserRepository repository;
	
	@RequestMapping("/user")
	public ModelAndView index(ModelAndView mav) {
		mav.setViewName("user");
		Iterable<User> threadList = repository.findAll();
		mav.addObject("data",threadList);
		return mav;
	}
	
	
	
	//ダミーデータの作成
	@PostConstruct
	public void init(){
		User user1 = new User();
		user1.setUserId("tanaka0000");
		user1.setPassword("tanaka0000");
		user1.setHandleName("tanaka");
		repository.saveAndFlush(user1);
		
		User user2 = new User();
		user2.setUserId("satou0000");
		user2.setPassword("satou0000");
		user2.setHandleName("satou");
		repository.saveAndFlush(user2);

	}

}
