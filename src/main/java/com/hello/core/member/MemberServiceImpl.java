package com.hello.core.member;

public class MemberServiceImpl implements MemberService {
    private final MemberRepository memberRepository;    // 변경 후 ㅡ AppConfig.java에서 설정. 인터페이스에만 의존하게 됨. (DIP 준수) //    private final MemberRepository memberRepository = new MemoryMemberRepository();  // final 붙이면 기본으로 할당하든 생성자를 통해 할당이 되어야 함. //변경전 ㅡ 저장과 조회를 위해 필요한 의존관계. 인터페이스와 구현 모두에 의존하는 문제. (DIP위반)

    public MemberServiceImpl(MemberRepository memberRepository) { //변경 후 ㅡ 생성자로 맴버래파지토리의 구현체가 뭐가 들어갈지를 설정
        this.memberRepository = memberRepository;
    } //

    @Override

    public void join(Member member) {
        memberRepository.save(member); //다형성으로 run 시점에 구현체의 오버라이드한 메서드 호출

    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
