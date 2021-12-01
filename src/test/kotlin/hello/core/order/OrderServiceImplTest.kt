package hello.core.order

import AppConfig
import hello.core.member.*
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class OrderServiceImplTest : FunSpec({
    lateinit var orderService: OrderService
    lateinit var memberService: MemberService

    beforeEach {
        val appConfig = AppConfig()
        orderService = appConfig.orderService()
        memberService = appConfig.memberService()
    }

    test("createOrder") {
        val memberId = 1L
        val member = Member(memberId, "memberA", Grade.VIP)
        memberService.join(member)

        val order = orderService.createOrder(memberId, "itemA", 10000)
        order.discountPrice shouldBe 1000
        order.calculatePrice() shouldBe 9000
    }
})
