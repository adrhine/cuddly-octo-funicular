package com.octo.funicular.service

class RememberInMemoryService : RememberService{

    private var col = arrayListOf<String>()

    override fun store(value: String) {
        col.add(value)
    }

    override fun forget(key: String) {
        col.remove(key)
    }

    override fun list(): String {
        return col.toString()
    }

    fun reset() {
        col = arrayListOf()
    }
}