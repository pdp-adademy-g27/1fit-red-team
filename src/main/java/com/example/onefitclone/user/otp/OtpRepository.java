package com.example.onefitclone.user.otp;

import com.example.onefitclone.user.otp.entity.Otp;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OtpRepository extends CrudRepository<Otp, String> {
}
