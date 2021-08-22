package com.te4a.springboot.web.controller;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.te4a.springboot.domain.entity.Thread;
import com.te4a.springboot.domain.repository.ThreadRepository;

@Controller
public class ThreadController {
	
	@Autowired
	ThreadRepository repository;
	
	@RequestMapping("/thread")
	public ModelAndView index(ModelAndView mav) {
		mav.setViewName("thread");
		Iterable<Thread> threadList = repository.findAll();
		mav.addObject("threadData",threadList);
		return mav;
	}
	
	@RequestMapping(value="/thread/create", method=RequestMethod.GET)
	public String threadCreate() {
		return "threadcreate";
	}
	
	@RequestMapping(value="/thread/create", method=RequestMethod.POST)
	public String threadSave(@RequestParam(value="title")String title,
							 @RequestParam(value="handleName")String handleName) {
		Thread thread = new Thread();
		thread.setTitle(title);
		thread.setHandleName(handleName);
		repository.saveAndFlush(thread);
		return "redirect:/thread";
	}
	

	
	//ダミーデータの作成
	@PostConstruct
	public void ThreadInit(){
		Thread thread1 = new Thread();
		thread1.setTitle("Can you recommend any restaurants in Sendai?");
		thread1.setHandleName("testuser1");
		repository.saveAndFlush(thread1);
		
		Thread thread2 = new Thread();
		thread2.setTitle("Let's play games together!");
		thread2.setHandleName("testuser2");
		repository.saveAndFlush(thread2);

	}

}
