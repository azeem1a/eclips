package com.example.test.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.CrudRepository;

import com.example.test.model.Student;

public interface Repo extends MongoRepository<Student, Integer>{

}
