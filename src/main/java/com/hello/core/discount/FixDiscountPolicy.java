package com.hello.core.discount;

import com.hello.core.member.Grade;
import com.hello.core.member.Member;

public class FixDiscountPolicy implements DiscountPolicy{

    private int DiscountFixAmount = 1000; //할인금액
    @Override
    public int discount(Member member, int price) {
        if(member.getGrade()== Grade.VIP) {//조건 등급. Enum타입은 ==을 쓴다.
            return DiscountFixAmount;
        } else {
            return 0;
        }

    }
}
