package com.programatori.recensionservice.repository;

import com.programatori.recensionservice.models.Comment;
import com.programatori.recensionservice.models.CommentStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {

    List<Comment> findAllByCommentStatus(CommentStatus status);

    List<Comment> findAllByVehicleId(Long vehicleId);

    List<Comment> findAllByVehicleIdAndCommentStatus(Long vehicleId, CommentStatus approved);
}
