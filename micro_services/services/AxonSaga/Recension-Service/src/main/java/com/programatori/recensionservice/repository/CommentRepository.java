package com.programatori.recensionservice.repository;

import com.programatori.recensionservice.models.Comment;
<<<<<<< Updated upstream
import com.programatori.recensionservice.models.CommentStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {

    List<Comment> findAllByCommentStatus(CommentStatus status);
=======
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {
>>>>>>> Stashed changes
}
