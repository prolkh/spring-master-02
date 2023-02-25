package spring.springmaster02.order;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import spring.springmaster02.discount.DiscountPolicy;
import spring.springmaster02.member.Member;
import spring.springmaster02.member.MemberRepository;

@Component
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService{

    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }

    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}
