package com.example.onefitclone.location;

import com.example.onefitclone.common.repository.GenericRepository;
import com.example.onefitclone.location.entity.Location;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface LocationRepository extends GenericRepository<Location, UUID> {
}
