package com.hello.core.member;

import com.hello.core.AppConfig;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MemberServiceTest {

    MemberService memberService; //MemberService memberService = new MemberServiceImpl();

    @BeforeEach //각 Test 실행 전에 무조건 실행됨
    public void beforeEach(){
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();
    }
    @Test //더 빨리 테스트~. 선택아닌 필수. 눈으로 출력된 콘솔결과를 보면서 검증하는 것과 다름. 실패 시 오류 빨리 캐치 가능
    void join(){
        //given 만들어서
        Member member = new Member(1L, "memberB", Grade.VIP);
        //when 넣고 찾아서
        memberService.join(member);
        Member findMember = memberService.findMember(1L);

        //then 검증
        Assertions.assertThat(member).isEqualTo(findMember); //org.assertj.core.api
    }
}
