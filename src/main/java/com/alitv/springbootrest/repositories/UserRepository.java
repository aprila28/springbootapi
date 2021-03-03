package com.alitv.springbootrest.repositories;

import com.alitv.springbootrest.model.UserModel;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<UserModel, Integer> {

}