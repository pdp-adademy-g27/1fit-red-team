package com.example.onefitclone.comment;

import com.example.onefitclone.comment.entity.Comment;
import com.example.onefitclone.common.repository.GenericRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CommentRepository extends GenericRepository<Comment, UUID> {
}
