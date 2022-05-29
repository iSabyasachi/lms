package com.lms.accesslibrary.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.lms.accesslibrary.entity.user.User;

@RepositoryRestResource(collectionResourceRel = "user", path = "users")
public interface UserRepository extends JpaRepository<User, Long>{	
	Optional<User> findById(Long id);
}
