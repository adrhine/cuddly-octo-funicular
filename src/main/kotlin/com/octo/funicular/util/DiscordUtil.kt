package com.octo.funicular.util

object DiscordUtil {

    fun getBotToken(): String {
        try {
            return ClassLoader.getSystemResource("bot-token.txt").readText().trim()
        } catch (error: Exception) {
            throw RuntimeException("Failed to load bot token. Make sure to create a file named bot-token.txt in" +
                    " src/com.octo.funicular.main/resources and paste the bot token into that file.", error)
        }
    }
}