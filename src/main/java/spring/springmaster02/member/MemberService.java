package spring.springmaster02.member;

public interface MemberService {

    void join(Member member);

    Member findMember(Long memberId);
}
