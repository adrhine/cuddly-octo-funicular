package com.octo.funicular.service

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class RememberInMemoryServiceTest {

    private val storedValue = "LALALLALALAL"

    private val rememberService = RememberInMemoryService()

    @BeforeEach
    private fun reset() {
        rememberService.reset()

        rememberService.store(storedValue)
    }

    @Test
    fun itStoresTheValue() {
        val x = "hodor"

        rememberService.store(x)
        assert(rememberService.list().contains(x))
    }

    @Test
    fun itShouldListTheValues() {
        assert(rememberService.list().contains(storedValue))
    }

    @Test
    fun itShouldForgetTheValue() {
        assert(rememberService.list().contains(storedValue))

        rememberService.forget(storedValue)

        Assertions.assertEquals(rememberService.list(), arrayListOf<String>().toString())
    }
}