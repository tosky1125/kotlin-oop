package hello.core.member

import AppConfig
import io.kotest.assertions.assertSoftly
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class MemberServiceImplTest : FunSpec({
    lateinit var memberService : MemberService

    beforeEach {
        val appConfig = AppConfig()
        memberService = appConfig.memberService()
    }

    test("join") {
        val member = Member(1L, "MemberA", Grade.VIP)
        memberService.join(member)
        val findMember = memberService.findMember(1L)
        assertSoftly {
            member shouldBe findMember
        }
    }
})
