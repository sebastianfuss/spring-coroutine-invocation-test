package com.example.springcoroutineinvocationtest

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.EnableAspectJAutoProxy

@SpringBootApplication
class SpringCoroutineInvocationTestApplication

fun main(args: Array<String>) {
    runApplication<SpringCoroutineInvocationTestApplication>(*args)
}
