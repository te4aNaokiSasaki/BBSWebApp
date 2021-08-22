package com.te4a.springboot.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.te4a.springboot.domain.entity.User;

@Repository
public interface UserRepository  extends JpaRepository<User,Integer>{

}
