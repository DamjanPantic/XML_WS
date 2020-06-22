package com.programatori.carrental.repository;

import com.programatori.carrental.models.Comment;
import com.programatori.carrental.models.CommentStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {




    @Query(value = "select c from Comment c inner join c.vehicle v where ((v.owner.id) = " +
            "(:owner)) and c.commentStatus = (:status)")
    List<Comment>  getVehicleCommentsForUser(@Param("owner") Long owner,
                                             @Param("status") CommentStatus status);



}
