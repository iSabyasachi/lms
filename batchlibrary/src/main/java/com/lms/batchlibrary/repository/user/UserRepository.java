package com.lms.batchlibrary.repository.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lms.batchlibrary.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{

}
