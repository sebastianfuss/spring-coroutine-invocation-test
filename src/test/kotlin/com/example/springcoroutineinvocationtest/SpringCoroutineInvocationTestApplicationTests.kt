package com.example.springcoroutineinvocationtest

import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.stereotype.Repository

@SpringBootTest
class SpringCoroutineInvocationTestApplicationTests(
    @Autowired private val testRepository: TestRepository,
) {
    @Test
    fun testSuspendFunctionAsMethodParam() = runBlocking {
        testRepository.update("4711") {
            it
        }
    }

    @Test
    fun testOpenMethodInSuperClass() = runBlocking {
        testRepository.save("foo")
    }
}

@Repository
class TestRepository : AbstractTestRepository<String> (){
    suspend fun update(id: String, action: suspend (String) -> String) {
        println("update [$id]: ${action("input")}")
    }
}

abstract class AbstractTestRepository<T> {
    open suspend fun save(entity: T) {
        println("save: $entity")
    }
}