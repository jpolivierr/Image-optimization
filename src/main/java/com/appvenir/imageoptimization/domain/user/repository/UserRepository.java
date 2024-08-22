package com.appvenir.imageoptimization.domain.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.appvenir.imageoptimization.domain.user.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {}
