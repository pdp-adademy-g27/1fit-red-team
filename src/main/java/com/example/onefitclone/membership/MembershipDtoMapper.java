package com.example.onefitclone.membership;

import com.example.onefitclone.common.mapper.GenericMapper;
import com.example.onefitclone.membership.dto.MembershipCreateDto;
import com.example.onefitclone.membership.dto.MembershipResponseDto;
import com.example.onefitclone.membership.dto.MembershipUpdateDto;
import com.example.onefitclone.membership.entity.Membership;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MembershipDtoMapper extends GenericMapper<Membership, MembershipCreateDto, MembershipResponseDto, MembershipUpdateDto> {
    private final ModelMapper mapper;

    @Override
    public Membership toEntity(MembershipCreateDto membershipCreateDto) {
        return mapper.map(membershipCreateDto, Membership.class);
    }

    @Override
    public MembershipResponseDto toResponseDto(Membership membership) {
        return mapper.map(membership, MembershipResponseDto.class);
    }

    @Override
    public void toEntity(MembershipUpdateDto membershipUpdateDto, Membership membership) {
        mapper.map(membershipUpdateDto, membership);
    }

}
