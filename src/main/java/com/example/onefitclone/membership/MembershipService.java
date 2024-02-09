package com.example.onefitclone.membership;

import com.example.onefitclone.common.service.GenericService;
import com.example.onefitclone.membership.dto.MembershipCreateDto;
import com.example.onefitclone.membership.dto.MembershipResponseDto;
import com.example.onefitclone.membership.dto.MembershipUpdateDto;
import com.example.onefitclone.membership.entity.Membership;
import jakarta.persistence.EntityNotFoundException;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.UUID;

@Service
@Getter
@RequiredArgsConstructor
public class MembershipService extends GenericService<Membership, UUID, MembershipCreateDto, MembershipResponseDto, MembershipUpdateDto> {
    private final MembershipRepository repository;
    private final Class<Membership> entityClass = Membership.class;
    private final MembershipDtoMapper mapper;

    @Override
    protected MembershipResponseDto internalCreate(MembershipCreateDto membershipCreateDto) {
        Membership membership = mapper.toEntity(membershipCreateDto);
        membership.setId(UUID.randomUUID());
        membership.setBought_day(LocalDate.now());
        Membership saved = repository.save(membership);
        return mapper.toResponseDto(saved);
    }

    @Override
    protected MembershipResponseDto internalUpdate(UUID uuid, MembershipUpdateDto membershipUpdateDto) {

        Membership membership = repository
                .findById(uuid)
                .orElseThrow(
                        () -> new EntityNotFoundException("Membership not found")
                );
        mapper.toEntity(membershipUpdateDto, membership);
        Membership saved = repository.save(membership);
        return mapper.toResponseDto(saved);
    }
}
