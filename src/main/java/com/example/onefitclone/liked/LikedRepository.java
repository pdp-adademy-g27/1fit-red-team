package com.example.onefitclone.liked;

import com.example.onefitclone.common.repository.GenericRepository;
import com.example.onefitclone.liked.entity.Liked;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface LikedRepository extends GenericRepository<Liked, UUID> {
}
