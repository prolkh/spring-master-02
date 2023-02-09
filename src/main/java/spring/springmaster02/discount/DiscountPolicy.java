package spring.springmaster02.discount;

import spring.springmaster02.member.Member;

public interface DiscountPolicy {

    /**
     * @return 할인 대상 금액
     */
    int discount(Member member, int price);
}
