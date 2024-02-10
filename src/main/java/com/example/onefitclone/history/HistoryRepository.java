package com.example.onefitclone.history;

import com.example.onefitclone.common.repository.GenericRepository;
import com.example.onefitclone.history.entity.History;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface HistoryRepository extends GenericRepository<History, UUID> {
}
