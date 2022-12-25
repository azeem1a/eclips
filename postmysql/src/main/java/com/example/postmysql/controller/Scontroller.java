package com.example.postmysql.controller;

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

import com.example.postmysql.Model.Student;
import com.example.postmysql.Repository.Ruppo;

@RestController
@RequestMapping("/users")
public class Scontroller {
@Autowired

Ruppo repo;

@PostMapping("/addStu")
public String addStu(@RequestBody Student stu) {
	repo.save(stu);
	return "record inserted" +stu.getId();
}
@GetMapping("/display")
public List<Student> display() {
	return (List<Student>) repo.findAll();
}
@GetMapping("/display/{id}")
public Optional<Student> display(@PathVariable Integer id) {
	return  repo.findById(id);
}
@DeleteMapping("/delete/{id}")
public String delete(@PathVariable long id) {
	repo.deleteById((int) id);
	return "deleted"+id;
}
@RequestMapping("/udp/{id}")
public String upd(@RequestBody Student stu) {
	Student exist=repo.findById(stu.getId()).get();
	exist.setName(stu.getName());
	repo.save(exist);
	return "record updated"+stu.getId();
}
}






