package hello.core

import AppConfig
import hello.core.member.Grade
import hello.core.member.Member
import hello.core.member.MemberService
import org.springframework.context.annotation.AnnotationConfigApplicationContext


fun main(args: Array<String>) {
    val applicationContext = AnnotationConfigApplicationContext(AppConfig::class.java)
    val memberService = applicationContext.getBean("memberService", MemberService::class.java)
    val member = Member(1L, "memberA", Grade.VIP)
    memberService.join(member)

    val findMember = memberService.findMember(1L)
    println("new Member = " + member.name)
    println("find Member = " + findMember?.name)
}

