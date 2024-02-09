package com.example.onefitclone.security.email.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@RedisHash(value = "Email", timeToLive = 60 * 60 * 24)
public class EmailDto implements Serializable {

    private String email;
    private String message;

}
