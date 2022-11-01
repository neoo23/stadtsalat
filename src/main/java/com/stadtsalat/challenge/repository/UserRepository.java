package com.stadtsalat.challenge.repository;

import com.stadtsalat.challenge.domain.User;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

import org.apache.commons.lang3.stream.Streams;
import org.springframework.data.repository.CrudRepository;


public interface UserRepository extends CrudRepository<User, Long> {

    default List<User> findByLastName(String lastName) {
        return StreamSupport.stream(findAll().spliterator(), false)
            .filter(u -> u.getLastName().equalsIgnoreCase(lastName))
            .collect(Collectors.toList());
    }

    default Optional<User> findSingleByLastName(String lastName) {
        List<User> users = findByLastName(lastName);
        return users.size() == 1 ? users.stream().findFirst() : Optional.empty();
    }
}
