package com.programatori.carservice.repository;

import com.programatori.carservice.models.LikeDislike;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LikeDislikeRepository extends JpaRepository<LikeDislike, Long> {
}
