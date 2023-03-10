package spring.springmaster02.discount;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import spring.springmaster02.annotation.MainDiscountPolicy;
import spring.springmaster02.member.Grade;
import spring.springmaster02.member.Member;

@Component
@MainDiscountPolicy
public class RateDiscountPolicy implements DiscountPolicy {

    private int discountPercent = 10;

    @Override
    public int discount(Member member, int price) {
        if (member.getGrade() == Grade.VIP) {
            return price * discountPercent / 100;
        } else {
            return 0;
        }
    }
}
