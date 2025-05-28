package org.koreait.member.service;

import lombok.RequiredArgsConstructor;
import org.koreait.member.controllers.RequestJoin;
import org.koreait.member.entities.Member;
import org.koreait.member.repositories.MemberRepository;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Lazy
@Service
@RequiredArgsConstructor
public class JoinService {

    private final ModelMapper modelMapper;
    private final PasswordEncoder encoder;
    private final MemberRepository repository;

    public void process(RequestJoin form){
        /**
         * 1. 비밀번호를 BCrypt로 해시화
         * 2. 휴대전화번호 형식 통일화 - 숫자만 남기고 다 날려버려!
         * 3. DB에 영구 저장
         */

        // 해시화
        String hash = encoder.encode(form.getPassword());
        String mobile = form.getMobile();
        if(StringUtils.hasText(mobile)){
            //숫자가 아닌 부분은 모두 제거
            mobile = mobile.replaceAll("\\D", "");
        }

        Member member = modelMapper.map(form, Member.class);
        member.setPassword(hash);
        member.setMobile(mobile);

        repository.save(member);
    }
}
