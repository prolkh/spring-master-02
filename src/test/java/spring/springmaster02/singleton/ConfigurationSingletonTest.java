package spring.springmaster02.singleton;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import spring.springmaster02.AppConfig;
import spring.springmaster02.member.MemberRepository;
import spring.springmaster02.member.MemberServiceImpl;
import spring.springmaster02.order.OrderServiceImpl;

import static org.assertj.core.api.Assertions.*;

public class ConfigurationSingletonTest {

    @Test
    void configurationTest() {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

        MemberRepository memberRepository = ac.getBean("memberRepository", MemberRepository.class);
        MemberServiceImpl memberService = ac.getBean("memberService", MemberServiceImpl.class);
        OrderServiceImpl orderService = ac.getBean("orderService", OrderServiceImpl.class);

        MemberRepository memberRepository1 = memberService.getMemberRepository();
        MemberRepository memberRepository2 = orderService.getMemberRepository();

        System.out.println("memberRepository = " + memberRepository);
        System.out.println("memberService -> memberRepository = " + memberRepository1);
        System.out.println("orderService -> memberRepository = " + memberRepository2);

        assertThat(memberRepository).isSameAs(memberService.getMemberRepository());
        assertThat(memberRepository).isSameAs(orderService.getMemberRepository());
    }

    @Test
    @DisplayName("@Configuration 과 SpringCGLIB")
    void configurationDeep() {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
        AppConfig bean = ac.getBean(AppConfig.class);

        System.out.println("bean.getClass() = " + bean.getClass());
        // 스프링이 CGLIB 라는 바이트코드 조작 라이브러리를 사용해서
        // AppConfig 클래스를 상속 받은 임의의 다른 클래스를 만들고,
        // 그 클래스를 스프링 빈으로 등록한 것이다.
    }
}
