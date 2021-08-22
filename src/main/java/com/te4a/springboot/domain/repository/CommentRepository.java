package com.te4a.springboot.domain.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.te4a.springboot.domain.entity.Comment;
@Repository
public interface CommentRepository extends JpaRepository<Comment,Integer>{

	public List<Comment> findByThreadId(Integer threadId);
	public Optional<Comment> findById(Integer id);
}
