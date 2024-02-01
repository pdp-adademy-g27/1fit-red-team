package com.example.onefitclone.user;

import com.example.onefitclone.common.repository.GenericRepository;
import com.example.onefitclone.user.entity.User;
import org.springframework.stereotype.Repository;


import java.util.UUID;

@Repository
public interface UserRepository extends GenericRepository<User, UUID> {

}

