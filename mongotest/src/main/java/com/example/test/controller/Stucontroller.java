 package com.example.test.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.test.model.Student;
import com.example.test.repository.Repo;

@RestController
public class Stucontroller {
@Autowired
Repo repo;

@PostMapping("/addStu")
public String addStu(@RequestBody Student stu) {
	repo.save(stu);
	
	return "record inserted"+stu.getId();
}
@GetMapping("/display")
public List<Student> display(){
	return repo.findAll();
}
@GetMapping("/search/{id}")
public Optional<Student> search(@PathVariable int id){
	return repo.findById(id);
}
@DeleteMapping("/delete/{id}")
public String delete(@PathVariable int id) {
	repo.deleteById(id);
	return "record deleted" + id;
}
@RequestMapping("/updStu/{id}")
public String updStu(@RequestBody Student stu)
{	
	Student exist=repo.findById(stu.getId()).get();
	exist.setName(stu.getName());
	repo.save(exist);
	return "Record updated by"+stu.getId();
}
}
