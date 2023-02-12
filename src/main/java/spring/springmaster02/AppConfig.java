package spring.springmaster02;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import spring.springmaster02.discount.DiscountPolicy;
import spring.springmaster02.discount.FixDiscountPolicy;
import spring.springmaster02.member.MemberRepository;
import spring.springmaster02.member.MemberService;
import spring.springmaster02.member.MemberServiceImpl;
import spring.springmaster02.member.MemoryMemberRepository;
import spring.springmaster02.order.OrderService;
import spring.springmaster02.order.OrderServiceImpl;

@Configuration
public class AppConfig {

    @Bean
    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    @Bean
    public OrderService orderService() {
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    @Bean
    public DiscountPolicy discountPolicy() {
        return new FixDiscountPolicy();
    }
}
