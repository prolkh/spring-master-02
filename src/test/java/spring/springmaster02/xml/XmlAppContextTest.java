package spring.springmaster02.xml;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.support.GenericXmlApplicationContext;
import spring.springmaster02.member.MemberService;

import static org.assertj.core.api.Assertions.assertThat;

public class XmlAppContextTest {

    @Test
    @DisplayName("xml 기반으로 스프링 빈 설정하기")
    void xmlAppContext() {
        GenericXmlApplicationContext ac = new GenericXmlApplicationContext("appConfig.xml");
        MemberService memberService = ac.getBean("memberService", MemberService.class);
        assertThat(memberService).isInstanceOf(MemberService.class);
    }
}
