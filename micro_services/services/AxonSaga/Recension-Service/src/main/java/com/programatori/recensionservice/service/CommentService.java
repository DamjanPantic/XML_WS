package com.programatori.recensionservice.service;

import com.programatori.recensionservice.models.Comment;
<<<<<<< Updated upstream
import com.programatori.recensionservice.models.CommentStatus;
=======
>>>>>>> Stashed changes
import org.springframework.http.ResponseEntity;

public interface CommentService {

    public ResponseEntity<?> addComment(Comment comment);
<<<<<<< Updated upstream
    public ResponseEntity<?> getCommentsByStatus(CommentStatus status);
    public ResponseEntity<?> approveComment(Long id);
    public ResponseEntity<?> declineComment(Long id);

=======
>>>>>>> Stashed changes

}
