package hello.core.discount

import hello.core.member.Grade
import hello.core.member.Member

class RateDiscountPolicy : DiscountPolicy {
    private val discountRate = 10;

    override fun discount(member: Member, price: Int): Int {
        if (member.grade == Grade.VIP) {
            return price * discountRate / 100
        }
        return 0
    }
}