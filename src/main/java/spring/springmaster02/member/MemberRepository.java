package spring.springmaster02.member;

public interface MemberRepository {

    void save(Member member);

    Member findById(Long memberId);
}
