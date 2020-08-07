package com.test.hplus.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.test.hplus.beans.User;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {
}
