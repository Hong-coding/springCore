package com.hello.core;

import com.hello.core.member.Grade;
import com.hello.core.member.Member;
import com.hello.core.member.MemberService;
import com.hello.core.member.MemberServiceImpl;

import javax.xml.transform.stream.StreamSource;

public class MemberApp {

    public static void main(String[] args) { //순수 자바로 테스트
        AppConfig appConfig = new AppConfig();
        MemberService memberService = appConfig.memberService(); //서비스, 서비스 임플에서 하던 생성을 appConfig가 다 결정. 서비스 달라고 하면 인터페이스(구현체 들어있는) 반환 // MemberService memberService = new MemberServiceImpl(null);// 기존에 멤버스비스를 메인에서 직접 생성

        Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member);

        Member findMember = memberService.findMember(1L);
        System.out.println("new member = " + member.getName());
        System.out.println("find Member = " + findMember.getName());
    }
}
