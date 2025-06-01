package org.koreait.member.libs;

import org.koreait.member.MemberInfo;
import org.koreait.member.constans.Authority;
import org.koreait.member.entities.Member;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Lazy
@Component
public class MemberUtil {

    // 로그인 상태 확인
    public boolean isLogin(){
        return getMember() != null;
    }

    // 관리자인지 확인
    public boolean isAdmin(){
        // isLogin으로 로그인 상태를 확인하고, getMember 내 회원 정보 중 일반/관리자 여부 부분인지 확인
        return isLogin() && getMember().getAuthority() == Authority.ADMIN;
    }

    //로그인한 회원 정보
    public Member getMember(){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        if (auth != null && auth.getPrincipal() instanceof MemberInfo memberInfo){
            return  memberInfo.getMember();
        }

        return null;
    }
}
