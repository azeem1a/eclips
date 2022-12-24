package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.entity.user;
import com.example.demo.repository.repo;

@Controller
public class usercontroller {
@Autowired
repo rep;
@RequestMapping("index")
public String index() {
	return "index.jsp";
}
@RequestMapping("addUe")
public String addUe(user ue) {
	rep.save(ue);
	return "sucess.jsp";
}
@RequestMapping("getSuc")
public String getSuc() {
	return "index.jsp";
}
@RequestMapping("getUe")
public ModelAndView getUe(@RequestParam int id) {
	ModelAndView mv = new ModelAndView("display.jsp");
	user ue=rep.findById(id).orElse(new user());
	mv.addObject(ue);
	return mv;
}
@RequestMapping("del")
public ModelAndView del(@RequestParam int id) {
	ModelAndView mv = new ModelAndView("deldisplay.jsp");
	user ue = rep.findById(id).orElse(new user());
	rep.deleteById(id);
	mv.addObject(ue);
	return mv;
}
@RequestMapping("getupdate")
public ModelAndView getUpdate(user ue) {
	ModelAndView mv = new ModelAndView("update.jsp");
	ue = rep.findById(ue.getId()).orElse(new user());
	return mv;
}
}
