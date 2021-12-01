package hello.core.beanfind

import AppConfig
import hello.core.member.MemberService
import hello.core.member.MemberServiceImpl
import io.kotest.assertions.throwables.shouldThrowExactly
import io.kotest.core.spec.style.FunSpec
import org.springframework.beans.factory.NoSuchBeanDefinitionException
import org.springframework.context.annotation.AnnotationConfigApplicationContext

class ApplicationContextBasicFindTest : FunSpec({
    val ac = AnnotationConfigApplicationContext(AppConfig::class.java)

    test("retrieve by bean name") {
        val memberService = ac.getBean("memberService", MemberService::class.java)
        memberService is MemberService
    }

    test("retrieve by impl type") {
        val memberService = ac.getBean("memberService", MemberServiceImpl::class.java)
        memberService is MemberService
    }

    test("retrieve by type") {
        val memberService = ac.getBean(MemberService::class.java)
        memberService is MemberService
    }

    test("find bean by name xxx to be throw exception") {
        shouldThrowExactly<NoSuchBeanDefinitionException> {
            ac.getBean("xxx", MemberService::class.java)
        }
    }
})