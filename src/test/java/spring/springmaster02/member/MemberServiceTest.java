package spring.springmaster02.member;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MemberServiceTest {

    MemberService memberService = new MemberServiceImpl();

    @Test
    @DisplayName("회원가입 기능이 정상 동작하다.")
    void join() {
        // Given
        Member member = new Member(1L, "memberA", Grade.VIP);

        // When
        memberService.join(member);
        Member findMember = memberService.findMember(1L);

        // Then
        Assertions.assertThat(member).isEqualTo(findMember);

    }
}