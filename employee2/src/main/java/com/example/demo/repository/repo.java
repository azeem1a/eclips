package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.entity.user;

public interface repo extends CrudRepository<user, Integer>{

}
