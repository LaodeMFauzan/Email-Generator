package com.test.emailgen.repository;

import com.test.emailgen.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
}
