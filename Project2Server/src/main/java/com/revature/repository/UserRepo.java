package com.revature.repository;

import org.springframework.data.repository.CrudRepository;

import com.revature.beans.User;

//CRUD methods for our User controller
public interface UserRepo extends CrudRepository<User, Integer>{

}
