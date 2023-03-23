package com.jerry.member.dto;

import com.jerry.member.entity.Member;
import com.jerry.stamp.Stamp;
import com.jerry.validator.NotSpace;
import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

public class MemberDto {
    @AllArgsConstructor
    @Getter
    public static class Response {
        private long memberId;
        private String email;
        private Stamp stamp;

        public int getStamp() {
            return stamp.getStampCount();
        }
    }
}
