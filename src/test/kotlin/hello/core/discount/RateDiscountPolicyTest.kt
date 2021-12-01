package hello.core.discount

import hello.core.member.Grade
import hello.core.member.Member
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class RateDiscountPolicyTest : FunSpec({
    val policy = RateDiscountPolicy()
    test("VIP는 10% 할인이 적용되어야 한다.") {
        val member = Member(1L,"VIP", Grade.VIP)
        val price = 10000
        val discount = policy.discount(member, price)
        discount shouldBe 1000
    }

    test("VIP가 아니면 할인이 적용되지 않아야 한다") {
        val member = Member(2L, "Normal", Grade.BASIC)
        val price = 10000
        val discount = policy.discount(member, price)
        discount shouldBe 0
    }
})
