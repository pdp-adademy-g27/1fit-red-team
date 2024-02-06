package com.example.onefitclone.studio;

import com.example.onefitclone.common.repository.GenericRepository;
import com.example.onefitclone.studio.entity.Studio;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface StudioRepository extends GenericRepository<Studio, UUID> {

}
