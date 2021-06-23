package com.stadtsalat.challenge.repository;

import com.stadtsalat.challenge.domain.User;
import java.util.List;

import org.springframework.data.repository.CrudRepository;


public interface UserRepository extends CrudRepository<User, Long> {

    List<User> findByLastName(String lastName);

}
