package com.te4a.springboot.web.controller;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.te4a.springboot.domain.entity.Comment;
import com.te4a.springboot.domain.repository.CommentRepository;

@Controller
public class CommentController {
	@Autowired
	CommentRepository repository;
	
	@RequestMapping(value="/comment/{threadId}", method=RequestMethod.GET)
	public ModelAndView select(@PathVariable int threadId,ModelAndView mav) {
		mav.setViewName("comment");
		List<Comment> commentList = repository.findByThreadId(threadId);
		mav.addObject("data",commentList);
		return mav;
	}
	
	@RequestMapping(value="/comment/create", method=RequestMethod.GET)
	public String threadCreate() {
		return "commentcreate";
	}
	
	//作成中
	@RequestMapping(value="/comment/create", method=RequestMethod.POST)
	public String threadSave(@RequestParam(value="comment")String postComment,
							 @RequestParam(value="handleName")String handleName) {
		Comment comment = new Comment();
		comment.setComment(postComment);
		comment.setHandleName(handleName);
		Date date = new Date();
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		Date d = calendar.getTime();
		comment.setCommentDate(d);
		repository.saveAndFlush(comment);
		return "redirect:/thread";
	}
	
	
	
	//ダミーデータの作成
	@PostConstruct
	public void ommentInit(){
		
		Comment comment1 = new Comment();
		comment1.setThreadId(1);
		comment1.setHandleName("テストユーザー1");
		comment1.setComment("おすすめはありますか？");
		Date date1 = new Date();
		Calendar calendar1 = Calendar.getInstance();
		calendar1.setTime(date1);
		Date d1 = calendar1.getTime();
		comment1.setCommentDate(d1);
		repository.saveAndFlush(comment1);
		
		Comment comment2 = new Comment();
		comment2.setThreadId(1);
		comment2.setHandleName("テストユーザー2");
		comment2.setComment("何系が良いですか？");
		Date date2 = new Date();
		Calendar calendar2 = Calendar.getInstance();
		calendar2.setTime(date2);
		calendar2.add(Calendar.MONTH, 2);
		Date d2 = calendar2.getTime();
		comment2.setCommentDate(d2);
		repository.saveAndFlush(comment2);
		
		Comment comment3 = new Comment();
		comment3.setThreadId(2);
		comment3.setHandleName("テストユーザー３");
		comment3.setComment("どのゲームにします？");
		Date date3 = new Date();
		Calendar calendar3 = Calendar.getInstance();
		calendar3.setTime(date3);
		calendar3.add(Calendar.MONTH, 3);
		Date d3 = calendar3.getTime();
		comment3.setCommentDate(d3);
		repository.saveAndFlush(comment3);
		
		Comment comment4 = new Comment();
		comment4.setThreadId(2);
		comment4.setHandleName("テストユーザー４");
		comment4.setComment("何にしましょう");
		Date date4 = new Date();
		Calendar calendar4 = Calendar.getInstance();
		calendar4.setTime(date4);
		calendar4.add(Calendar.MONTH, 4);
		Date d4 = calendar4.getTime();
		comment4.setCommentDate(d4);
		repository.saveAndFlush(comment4);

	}
}
