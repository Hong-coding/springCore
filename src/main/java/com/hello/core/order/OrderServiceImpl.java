package com.hello.core.order;

import com.hello.core.discount.DiscountPolicy;
import com.hello.core.discount.FixDiscountPolicy;
import com.hello.core.discount.RateDisountPolicy;
import com.hello.core.member.Member;
import com.hello.core.member.MemberRepository;
import com.hello.core.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService{//주문은 필요한 게 2개 맴버 찾고, 정책을 찾아 주문함

//    private final MemberRepository memberRepository = new MemoryMemberRepository();
//    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();
//    private final DiscountPolicy discountPolicy = new RateDisountPolicy();
    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;

    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId); //멤버 찾아서
        int discountPrice = discountPolicy.discount(member, itemPrice);//그대로 할인정책으로 넘겨버림. 좋은 설계. 주문서비스는 할인을 관여하지 않음. 할인 수정 시 할인만 고치면 됨.

        return new Order(memberId, itemName, itemPrice, discountPrice); //멤버 id가 없으면?
    }
}
