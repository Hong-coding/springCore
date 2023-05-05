package com.hello.core;

import com.hello.core.discount.DiscountPolicy;
import com.hello.core.discount.FixDiscountPolicy;
import com.hello.core.discount.RateDisountPolicy;
import com.hello.core.member.MemberRepository;
import com.hello.core.member.MemberService;
import com.hello.core.member.MemberServiceImpl;
import com.hello.core.member.MemoryMemberRepository;
import com.hello.core.order.OrderService;
import com.hello.core.order.OrderServiceImpl;

public class AppConfig { //앱동작에 필요한 구현체를 생성하는 부분. 서비스 임플에서 new 하는 걸 다 없앰. 여기서 new 생성자를 통해서 참조값을 주입.주입연결.

    public MemberService memberService(){//AppConfig를 통해 누군가 멤버서비스를 조회하면 이 애플리케이션에서는 애플리케이션에서 결정한 멤버서비스 임플(구현)을 써
        return new MemberServiceImpl(memberRepository());
    }

    public MemberRepository memberRepository() { //메서드 명만 봐도 역할을 알 수 있게 됨.(명칭과 리턴타입) 메모리레파지토리 현재는 메모리꺼 (구현)
        return new MemoryMemberRepository();
    }

    public OrderService orderService(){ //내 오더서비스에서는 오서서비스 임플을 쓸거야. 애플리케이션에서 결정한 멤버레파지토리랑 디스카운트폴리시거로 가져올거야 (구현)
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    public DiscountPolicy discountPolicy(){ //그 디스카운트 폴리스는 픽스/ 레이트 여기서만 선택하면 끝
//        return new FixDiscountPolicy();
        return new RateDisountPolicy();
    }


    /*
    역할별로 리팩토링 하기 전
    public MemberService memberService(){//AppConfig를 통해 누군가 멤버서비스를 조회하면 멤버서비스 임플을 반환하는데. 그 때 구현체를 넣어서 반환.
        return new MemberServiceImpl(new MemoryMemberRepository()); //멤버서비스가 호출되는 시점(생성자통해서)에 멤버서비스"구현체"가 이 위치에서(서비스임플 외부에서) 들어가게 됨(생성자 주입: 인스턴스를 생성자로 넣어줌)
    }

    public OrderService orderService(){
        return new OrderServiceImpl(new MemoryMemberRepository(), new FixDiscountPolicy());
    }
    */
}
