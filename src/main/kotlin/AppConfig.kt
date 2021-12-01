import hello.core.discount.FixDiscountPolicy
import hello.core.member.MemberService
import hello.core.member.MemberServiceImpl
import hello.core.member.MemoryMemberRepository
import hello.core.order.OrderService
import hello.core.order.OrderServiceImpl

class AppConfig {
    fun memberService(): MemberService {
        return MemberServiceImpl(memberRepository())
    }

    fun orderService(): OrderService {
        return OrderServiceImpl(memberRepository(), discountPolicy())
    }

    private fun discountPolicy() = FixDiscountPolicy()

    private fun memberRepository() = MemoryMemberRepository()
}