package hello.core

import AppConfig
import hello.core.member.Grade
import hello.core.member.Member
import hello.core.member.MemberService
import hello.core.order.OrderService
import org.springframework.context.annotation.AnnotationConfigApplicationContext

fun main(args: Array<String>) {
    val applicationContext = AnnotationConfigApplicationContext(AppConfig::class.java)
    val orderService = applicationContext.getBean("orderService", OrderService::class.java)
    val memberService = applicationContext.getBean("memberService", MemberService::class.java)
    val memberId  = 1L
    val member = Member(memberId, "memberA", Grade.VIP)

    memberService.join(member)

    val order = orderService.createOrder(memberId, "itemA", 10000)

    println("order = $order")
}