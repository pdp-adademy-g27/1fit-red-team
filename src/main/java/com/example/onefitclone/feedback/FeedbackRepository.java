package com.example.onefitclone.feedback;

import com.example.onefitclone.common.repository.GenericRepository;
import com.example.onefitclone.feedback.entity.Feedback;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface FeedbackRepository extends GenericRepository<Feedback, UUID> {
}
