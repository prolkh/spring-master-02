package spring.springmaster02.order;

import spring.springmaster02.discount.DiscountPolicy;
import spring.springmaster02.discount.FixDiscountPolicy;
import spring.springmaster02.member.Member;
import spring.springmaster02.member.MemberRepository;
import spring.springmaster02.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService{

    private final MemberRepository memberRepository = new MemoryMemberRepository();
    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
