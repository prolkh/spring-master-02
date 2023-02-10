package spring.springmaster02;

import spring.springmaster02.discount.FixDiscountPolicy;
import spring.springmaster02.member.MemberService;
import spring.springmaster02.member.MemberServiceImpl;
import spring.springmaster02.member.MemoryMemberRepository;
import spring.springmaster02.order.OrderService;
import spring.springmaster02.order.OrderServiceImpl;

public class AppConfig {

    public MemberService memberService() {
        return new MemberServiceImpl(new MemoryMemberRepository());
    }

    public OrderService orderService() {
        return new OrderServiceImpl(new MemoryMemberRepository(), new FixDiscountPolicy());
    }
}
