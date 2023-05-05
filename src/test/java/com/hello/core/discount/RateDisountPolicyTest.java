package com.hello.core.discount;

import com.hello.core.member.Grade;
import com.hello.core.member.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class RateDisountPolicyTest {

    RateDisountPolicy discountPolicy = new RateDisountPolicy();

    @Test
    @DisplayName("VIP는 10프로 할인이 적용되어야 한다")
        //한글로 이름을 쓸 수 있는 jUnit5부터 기능
    void vip_o() {
        //given
        Member member = new Member(1L, "memberVIP", Grade.VIP);

        //when
        int discount = discountPolicy.discount(member, 10000);

        //then
        assertThat(discount).isEqualTo(1000);
    }
    //실패테스트 만들기
    @Test
    @DisplayName("VIP가 아닌 경우는 할인이 적용되지 않아야 한다")
    void vip_x(){
        //given
        Member member = new Member(2L, "memberBasic", Grade.BASIC);

        //when
        int discount = discountPolicy.discount(member, 10000);

        //then
        assertThat(discount).isEqualTo(0); //Alt+ 엔터 : 테스트 할 때 Assertions 를 static import

    }
}