package hello.core.order

import hello.core.discount.DiscountPolicy
import hello.core.member.Grade
import hello.core.member.Member
import hello.core.member.MemberRepository

class OrderServiceImpl(
    private final val repository: MemberRepository,
    private final val discountPolicy: DiscountPolicy
) : OrderService {


    override fun createOrder(memberId: Long, itemName: String, itemPrice: Int): Order {
        var member = repository.findById(memberId)
        if (member == null) member = Member(1L, "test", Grade.VIP)
        val discountPrice = discountPolicy.discount(member, itemPrice)

        return Order(memberId, itemName, itemPrice, discountPrice)
    }
}