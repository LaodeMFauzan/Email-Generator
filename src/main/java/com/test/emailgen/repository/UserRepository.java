package com.test.emailgen.repository;

import com.test.emailgen.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends CrudRepository<User, Long> {

    List<User> findByEmail(@Param("email") String email);
}
