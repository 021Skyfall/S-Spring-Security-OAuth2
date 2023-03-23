package com.jerry.member.controller;

import com.jerry.dto.MultiResponseDto;
import com.jerry.dto.SingleResponseDto;
import com.jerry.member.dto.MemberDto;
import com.jerry.member.entity.Member;
import com.jerry.member.mapper.MemberMapper;
import com.jerry.member.service.MemberService;
import com.jerry.stamp.Stamp;
import com.jerry.utils.UriCreator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Positive;
import java.net.URI;
import java.util.List;


/**
 * - DI 적용
 * - Mapstruct Mapper 적용
 * - @ExceptionHandler 적용
 */
@RestController
@RequestMapping("/v11/members")
@Validated
@Slf4j
public class MemberController {
    private final static String MEMBER_DEFAULT_URL = "/v11/members";
    private final MemberService memberService;
    private final MemberMapper mapper;

    public MemberController(MemberService memberService, MemberMapper mapper) {
        this.memberService = memberService;
        this.mapper = mapper;
    }

    // TODO OAuth 2 인증 환경에서는 회원 정보를 별도로 관리하지 않으므로, 회원 정보를 어떻게 로드할 것인가는 추가적인 논의가 필요
}
