package com.octo.funicular.service

interface RememberService {

    fun store(value: String)

    fun forget(key: String)

    fun list(): String
}