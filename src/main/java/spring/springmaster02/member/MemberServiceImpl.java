package spring.springmaster02.member;

/**
 * OCP 원칙을 잘 준수하지 않음
 * DIP 를 지키지 않고 의존성이 발견됨
 */
public class MemberServiceImpl implements MemberService{

    private final MemberRepository memberRepository = new MemoryMemberRepository();

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }
}