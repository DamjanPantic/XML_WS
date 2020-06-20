package com.programatori.recensionservice.repository;

import com.programatori.recensionservice.models.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}
