package hello.core.beanfind

import hello.core.member.MemberRepository
import hello.core.member.MemoryMemberRepository
import io.kotest.assertions.throwables.shouldThrowExactly
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe
import org.springframework.beans.factory.NoUniqueBeanDefinitionException
import org.springframework.context.annotation.AnnotationConfigApplicationContext
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

class ApplicationContextSameBeanFindTest : FunSpec({
    val ac = AnnotationConfigApplicationContext(SameBeanConfig::class.java)

    test("if same bean existed, should throw exception") {
        shouldThrowExactly<NoUniqueBeanDefinitionException> {
            ac.getBean(MemberRepository::class.java)
        }
    }

    test("if same bean existed, should retrieve by name and type") {
        val bean = ac.getBean("memberRepository1", MemberRepository::class.java)
        bean is MemberRepository
    }

    test("retrieve by bean type") {
        val beansOfType = ac.getBeansOfType(MemberRepository::class.java)
        beansOfType.size shouldBe 2
    }

}) {
    @Configuration
    class SameBeanConfig {
        @Bean
        fun memberRepository1(): MemberRepository {
            return MemoryMemberRepository()
        }

        @Bean
        fun memberRepository2(): MemberRepository {
            return MemoryMemberRepository()
        }
    }
}