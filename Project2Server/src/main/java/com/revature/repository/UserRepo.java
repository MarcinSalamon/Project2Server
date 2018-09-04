package com.revature.repository;

import org.springframework.data.repository.CrudRepository;

import com.revature.beans.User;

public interface UserRepo extends CrudRepository<User, Integer>{

}
