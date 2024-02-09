package com.example.onefitclone.membership;

import com.example.onefitclone.common.repository.GenericRepository;
import com.example.onefitclone.membership.entity.Membership;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface MembershipRepository extends GenericRepository<Membership, UUID> {
}
