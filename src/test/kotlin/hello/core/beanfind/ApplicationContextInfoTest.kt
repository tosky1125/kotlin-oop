package hello.core.beanfind

import AppConfig
import io.kotest.core.spec.style.FunSpec
import org.springframework.beans.factory.config.BeanDefinition
import org.springframework.context.annotation.AnnotationConfigApplicationContext

class ApplicationContextInfoTest : FunSpec({

    val ac = AnnotationConfigApplicationContext(AppConfig::class.java)

    test("print all beans") {
        val beanDefinitionNames = ac.beanDefinitionNames
        for (beanName in beanDefinitionNames) {
            val selectedBean = ac.getBean(beanName)
            println("name = $beanName object = $selectedBean")
        }
    }

    test("print application beans") {
        val beanDefinitionNames = ac.beanDefinitionNames
        for (beanName in beanDefinitionNames) {
            val beanDefinition = ac.getBeanDefinition(beanName)
            if (beanDefinition.role == BeanDefinition.ROLE_APPLICATION) {
                val selectedBean = ac.getBean(beanName)
                println("name = $beanName object = $selectedBean")
            }
        }
    }
})