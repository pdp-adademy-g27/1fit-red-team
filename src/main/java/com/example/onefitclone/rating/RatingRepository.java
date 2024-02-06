package com.example.onefitclone.rating;

import com.example.onefitclone.common.repository.GenericRepository;
import com.example.onefitclone.rating.entity.Rating;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface RatingRepository extends GenericRepository<Rating, UUID> {
}
